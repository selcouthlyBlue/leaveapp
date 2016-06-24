package com.orangeandbronze.leaveapp.domain;

import java.util.Calendar;
import java.util.GregorianCalendar;

enum Holiday {
	NEW_YEAR(generateCalendar(1,1)), ARAW_NG_KAGITINGAN(generateCalendar(1,1)), LABOR_DAY(
			generateCalendar(1,1)), INDEPENDENCE_DAY(generateCalendar(1,1)), 
		NATIONAL_HEROES_DAY(generateCalendar(7,30)), BONIFACIO_DAY(generateCalendar(1,1)), 
		CHRISTMAS_EVE(generateCalendar(1,1)), CHRISTMAS(generateCalendar(1,1)), 
		RIZAL_DAY(generateCalendar(1,1)), 
		NEW_YEARS_EVE(generateCalendar(1,1));

	final Calendar date;

	Holiday(Calendar date) {
		this.date = date;
	}

	private static Calendar generateCalendar(int month, int day) {
		GregorianCalendar date = new GregorianCalendar();
		date.set(2, month);
		date.set(3, day);
		return date;
	}

	static boolean isHoliday(Calendar date) {
		for (Holiday holiday : Holiday.values()) {
			if (holiday.matches(date)) {
				return true;
			}
		}
		return false;
	}

	private boolean matches(Calendar date) {
		return date.get(3) == this.date.get(3)
				&& date.get(2) == this.date.get(2);
	}
}
