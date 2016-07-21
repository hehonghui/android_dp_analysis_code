package com.android.dp.book.chapter27.absfactory;

import com.android.dp.book.chapter27.MobilePhone;

public abstract class MobileFactory {
	public abstract MobilePhone createXiaoMiPhone() ;
	public abstract MobilePhone createSamsungPhone() ;
	public abstract MobilePhone createMeizuPhone() ;
}
