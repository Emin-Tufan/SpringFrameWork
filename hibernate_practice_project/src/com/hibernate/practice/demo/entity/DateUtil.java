package com.hibernate.practice.demo.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static SimpleDateFormat formatt = new SimpleDateFormat("dd/MM/yyyy");

	public static Date parseDate(String dateStr) {
		
		Date date=null;
		try {
			date = formatt.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;

	}

	public static String formatDate(Date date) {
		
		String result = null;

		if (date != null) {
			result = formatt.format(date);
		}
		return result;

	}
}
