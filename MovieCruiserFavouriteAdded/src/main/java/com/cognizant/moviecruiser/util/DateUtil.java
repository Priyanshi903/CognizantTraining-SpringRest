package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

//	converts a string to date

	public static Date convertToDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		return formatter.parse(date);
	}

}
