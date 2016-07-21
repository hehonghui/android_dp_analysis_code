package com.android.dp.book.chapter27.factory;

import com.android.dp.book.chapter27.MobilePhone;
import com.android.dp.book.chapter27.simplefactory.Samsung;

//三星手机工厂创建三星手机
public class SamsungFactory extends MobileFactory {

	@Override
	public MobilePhone createPhone() {
		return new Samsung();
	}
}
