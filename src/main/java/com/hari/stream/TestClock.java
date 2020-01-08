package com.hari.stream;

import java.time.Clock;
import java.time.ZoneId;

public class TestClock {
	public static void main(String[] args) throws InterruptedException {
		ZoneId zoneId = ZoneId.of("Asia/Calcutta");
		Clock clock = Clock.tickMinutes(zoneId);
		clock = Clock.systemUTC();
		System.out.println(clock.instant());
		while(true) {
			//System.out.print(Clock.tickMinutes(zoneId).instant() +"\r");
			System.out.println(Clock.systemUTC().instant().atZone(zoneId));
			Thread.sleep(1000L);
		}
	}
}
