package com.android.dp.book.chapter27.factory;

import com.android.dp.book.chapter27.MobilePhone;

public class Test {
	public static void main(String[] args) {
		MobileFactory factory = new SamsungFactory() ;
		// 创建三星手机
		MobilePhone samsung = factory.createPhone() ;
	}
}
