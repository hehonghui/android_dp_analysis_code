package com.android.dp.book.chapter27.absfactory;

import com.android.dp.book.chapter27.MobilePhone;

public class Test {
	public static void main(String[] args) {
		MobileFactory factory = new FoxconnFactory() ;
		// 创建小米手机
		MobilePhone xiaomi = factory.createXiaoMiPhone() ;
		// 创建魅族手机
		MobilePhone meizu = factory.createMeizuPhone() ;
		// 创建三星手机
		MobilePhone samsung = factory.createSamsungPhone() ;
	}
}
