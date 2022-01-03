
package com.example.SpringCRUD.Model;


import java.util.Collection;

public class CommonUtils {
	public static boolean isListNullOrEmpty(Collection<?> data) {
		return (data == null || data.isEmpty());
	}

	public static String isStringEmpty(String value) {
		value = value.trim();
		if (value.isEmpty() || value == null || "undefined".equals(value) || "null".equals(value) || "".equals(value)) {
			return "";
		}
		return value;
	}

	public static boolean isObjectNullOrEmpty(Object value) {
		return (value == null
				|| (value instanceof String
						? (((String) value).isEmpty() || "".equals(((String) value).trim()) || "null".equals(value)
								|| "undefined".equals(value))
						: false));
	}


}
