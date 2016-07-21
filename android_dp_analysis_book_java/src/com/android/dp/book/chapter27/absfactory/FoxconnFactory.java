package com.android.dp.book.chapter27.absfactory;

import com.android.dp.book.chapter27.MobilePhone;
import com.android.dp.book.chapter27.simplefactory.Meizu;
import com.android.dp.book.chapter27.simplefactory.Samsung;
import com.android.dp.book.chapter27.simplefactory.XiaoMi;

// 富士康生产一系列品牌的手机
public class FoxconnFactory extends MobileFactory {

	@Override
	public MobilePhone createXiaoMiPhone() {
		return new XiaoMi();
	}

	@Override
	public MobilePhone createSamsungPhone() {
		return new Samsung();
	}

	@Override
	public MobilePhone createMeizuPhone() {
		return new Meizu();
	}
}
