package com.qa.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Space {
	public static void main (String args[]) throws ParseException
	{
		String s1="s1,s2,s3";
		String s2="s3";
		List<String> l=null;
		l=new ArrayList<String>(Arrays.asList(s1.split(",")));
		System.out.println(l);
		System.out.println(l.remove(s2));
		System.out.println(l);
		
}
}
