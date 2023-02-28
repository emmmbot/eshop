package com.eshop.utils;

import java.util.UUID;

//获取string类型的序列号
public class IdUtils {

	public static String getUUID() {

		return UUID.randomUUID().toString();

	}
}
