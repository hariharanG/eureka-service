package com.hari.eureka;

import java.io.IOException;
import java.util.Arrays;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Delete;
import io.searchbox.indices.IndicesExists;

public class JestExample {
	
	private static JestClient jestClient = jestClient();
	
	public static void main(String ... args) {
		// JestClient jestClient = jestClient();
		JestResult result =  indicesExists("abc_no_index");  // indicesExists("demo", "demo1"); // indicesExists("demo");
		if(result.isSucceeded()) {
			System.out.println("Yep! Index/Indices available.");
		}else {
			System.out.println("Nope!  Index/Indices NOT available.");
		}
	}
	
	private static JestClient jestClient() {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200")
				.multiThreaded(true)
				.defaultMaxTotalConnectionPerRoute(2)
				.maxTotalConnection(10)
				.build());
		return factory.getObject(); 
	}
	
	public static JestResult deleteDocument(String id, String index) {
		JestResult jestResult = null;
		try {
			jestResult = jestClient.execute(new Delete.Builder(id).index(index).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jestResult;
	}
	
	public static JestResult indicesExists(String ... indices) {
		JestResult jestResult = null;
		try {
			jestResult = jestClient.execute(new IndicesExists.Builder(Arrays.asList(indices)).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jestResult;
	}
	
	
}
