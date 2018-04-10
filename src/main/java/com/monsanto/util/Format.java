package com.monsanto.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author archit.sud
 * This class will provide utility methods to check if String, List are empty or not.
 */
public class Format {

	/**
	 * Method to check if String is not empty and not null.
	 * @param arg
	 * @return Boolean
	 */
	public static Boolean isStringNotEmptyAndNotNull(String arg) {
		if (arg != null && !("").equals(arg) && !("").equals(arg.trim())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check if a List/Set is not null and not empty.
	 * @param c
	 * @return Boolean
	 */
	public static Boolean isCollectionNotEmtyAndNotNull(Collection<?> arg) {
		if (arg != null && !arg.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check if an object is not null or zero.
	 * @param arg as Object
	 * @return true if object is not null or zero
	 */
	public static Boolean isObjectNotEmptyAndNotZero(Object arg) {
		if (arg != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to check if a Integer is not 0 and not empty.
	 * @param Integer arg
	 * @return Boolean
	 */
	public static Boolean isIntegerNotEmtyAndNotZero(Integer arg) {
		if (arg != null && arg != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method to format date in dd MMM yyyy.
	 * @param dateStr as date
	 * @return formatted String
	 */
	public static String parseDateFormatDDMMMYYHHMMA(Date date) {
		SimpleDateFormat format = null;
		String datestr = null;
		try {
			format = new SimpleDateFormat("dd MMM yyyy hh:mm a");
			datestr = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datestr;
	}
	
	/**
	 * Method to format date in dd MMM yyyy.
	 * @param dateStr as date
	 * @return formatted String
	 */
	public static String parseDateFormatDDMMMYY(Date date) {
		SimpleDateFormat format = null;
		String datestr = null;
		try {
			format = new SimpleDateFormat("dd-MM-yyyy");
			datestr = format.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datestr;
	}
	
	/**
	 * Method to format date in yyyy-MM-dd.
	 * @param dateStr as String
	 * @return formatted date
	 */
	public static Date parseDateFormatDDMMMYY(String dateStr) {
		SimpleDateFormat format = null;
		Date date = null;
		try {
			format = new SimpleDateFormat("dd-MM-yyyy");
			date = format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
