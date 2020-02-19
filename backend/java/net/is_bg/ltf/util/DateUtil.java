package net.is_bg.ltf.util;

import java.sql.Date;

public class DateUtil {
	public static java.sql.Date toSQLDate(java.util.Date date) {
		java.sql.Date sqlDate = null;
		if (date != null)
			sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

}
