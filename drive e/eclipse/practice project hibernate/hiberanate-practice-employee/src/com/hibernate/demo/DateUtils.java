package com.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {
private static	 SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
	public static void main(String[] args) throws ParseException {
	
		System.out.println(parse("10/12/2019"));
		
	}
	
	public static Date parse(String date) throws ParseException	{
		return formatter.parse(date);
	}
	
	public static String format(Date dt)	{
		if(dt != null) {
			return formatter.format(dt);
		}else {
			return null;
		}
	}

	public static void currentDateTime() {
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt.getDayOfMonth());
		System.out.println(ldt.getDayOfMonth());
	}

	public static void customDateTime(int year, int month, int day) {
		LocalDateTime ldt = LocalDateTime.of(year, month, day, 19, 30);
		System.out.println("DOB:" + ldt);
	}

	public static void zone() {
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);

	}

}
