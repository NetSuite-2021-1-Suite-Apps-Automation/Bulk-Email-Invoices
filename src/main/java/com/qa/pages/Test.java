package com.qa.pages;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import bsh.ParseException;

public class Test{
	public static void main(String[] a) throws java.text.ParseException, ParseException {
		// TODO Auto-generated method stub

		Test t= new Test();
		t.timeZonePSTConvrsn();
		t.date_function(1, timeZonePSTConvrsn());
//		String s = t.timeZonePSTConvrsn();
//		System.out.println("s is: " +s);
	}

public String date_function(int no_of_days, String dateFormat) throws ParseException, java.text.ParseException {

		Date currentDay=new SimpleDateFormat("M/d/yyyy").parse(dateFormat);
		SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDay);
		cal.add(Calendar.DATE, no_of_days);
		Date next_day = cal.getTime();
		String strDate= formatter.format(next_day);
		System.out.println(strDate);
		return strDate;
	}

public static String timeZonePSTConvrsn() throws java.text.ParseException {
	
	ZonedDateTime date = ZonedDateTime.now();
	ZoneId la = ZoneId.of("America/Los_Angeles");
	ZonedDateTime date2 = date.withZoneSameInstant(la);
	return DateTimeFormatter.ofPattern("M/d/yyyy").format(date2);

}
}