package com.hari.stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

	public static void main(String[] args) {
		Stream<Integer> list = Stream.of(1,2,3,4);
		System.out.println(list.anyMatch(i-> i==3));
		System.out.println("********************");
		list = Stream.of(1,2,3,4);
		System.out.println(list.allMatch(e -> e<10));
		System.out.println("********************");
		list = Stream.of(1,2,3,4);
		System.out.println(list.noneMatch(i -> i==10));
		System.out.println("********************");
		list = Stream.of(1,2,3,4);
		Optional<Integer> findFirst = list.findFirst();
		System.out.println(findFirst.isPresent());
		System.out.println(findFirst.get());
		System.out.println("********************");
		list = Stream.of(1,2,3,4);
		Optional<Integer> findAny = list.findAny();
		System.out.println(findAny.isPresent());
		System.out.println(findAny.get());
		System.out.println("********************");
		list = Stream.of(1,2,3,4);
		System.out.println(list.collect(Collectors.toMap(i->i.hashCode(), i->i)) );
		System.out.println("********************");
		Stream<String> listStrm = Stream.of("1","2","3","4");
		//System.out.println(listStrm.collect(Collectors.toMap(i->i.hashCode(), i->i)) );
		String[] arrayStrm = listStrm.toArray(String[]::new);
		System.out.println("********************");
		listStrm = Stream.of("1","2","3","4");
		listStrm.forEach(e -> System.out.println(e));
		System.out.println("********************");
		listStrm = Stream.of("a","b","c","d");
		System.out.println( listStrm.map(e-> { return e.toUpperCase(); } ).collect(Collectors.toList()) );
		System.out.println("********************");
		listStrm = Stream.of("123","ab","555","cool","daemon");
		//System.out.println( "NaturalOrder: " + listStrm.sorted().collect(Collectors.toList()) );
		System.out.println( "ReverseOrder: " + listStrm.sorted(Comparator.reverseOrder()).collect(Collectors.toList()) );
		System.out.println("********************");
		list = Stream.of(1,2,3,4,5);
		//Optional<Integer> sum = list.reduce( (i,j) -> { return i+j;} );
		Optional<Integer> mul = list.reduce( (i,j) -> { return i*j;} );
		System.out.println("Multiplication: " + mul.get());
		System.out.println("********************");
		list = Stream.of(-1,82,390,-980,99999);
		Optional<Integer> max = list.max(Integer::compare);
		System.out.println("Maximum: " + max.get());
		System.out.println("********************");
		list = Stream.of(-1,82,390,-980,99999);
		Optional<Integer> min = list.min(Integer::compare);
		System.out.println("Minimum: " + min.get());
		System.out.println("********************");
		list = Stream.of(-1,82,390,-980,99999);
		list.forEach(e-> System.out.println(e));
		System.out.println("********************");
		list = Stream.of(-1,82,390,-980,99999);
		max = list.min(Comparator.reverseOrder());
		System.out.println("Maximum: " + max.get());
		System.out.println("********************");
		list = Stream.of(-1,82,390,-980,99999);
		min = list.min(Comparator.naturalOrder());
		System.out.println("Minimum: " + min.get());
		System.out.println("********************");
	}

}
