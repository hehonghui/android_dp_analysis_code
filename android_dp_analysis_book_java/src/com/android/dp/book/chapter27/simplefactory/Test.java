package com.android.dp.book.chapter27.simplefactory;

import com.android.dp.book.chapter27.MobilePhone;

public class Test {
	public static void main(String[] args) {
		// 创建三星手机
		MobilePhone samsung = MobileFactory.createPhone("samsung");
		// 创建小米手机
		MobilePhone xiaomi = MobileFactory.createPhone("xiaomi");
	}
}
