package com.android.dp.book.chapter27.factory;

import com.android.dp.book.chapter27.MobilePhone;
import com.android.dp.book.chapter27.simplefactory.XiaoMi;

// 小米手机工厂创建小米手机
public class XiaoMiFactory extends MobileFactory {

	@Override
	public MobilePhone createPhone() {
		return new XiaoMi();
	}
}
