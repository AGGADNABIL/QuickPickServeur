package com.quick.pickup.commun;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IDateFormatter {

	private static DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("hhmmss");
	
	private IDateFormatter() {
	}

	public static String currentHour() {
		return timeformatter.format(LocalTime.now());
	}
}
