package com.blackwater.blackwaterbillingmanagementsystem.utils;

import java.util.UUID;

public class Utils {
	
	public static String generateID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "").toUpperCase();
	}

}
