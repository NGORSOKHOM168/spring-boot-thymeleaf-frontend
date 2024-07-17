package com.learning.utils;

import java.math.BigInteger;
import java.util.UUID;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StringAppUtils {
	
	public static String uuid16digits() {
		String uuid = String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
		String uuid16digits = uuid.substring(uuid.length() - 16);	
		return uuid16digits;
	}
	
}
