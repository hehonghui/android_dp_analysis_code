package com.android.dp.book.chapter27.builder;

//具体的 Computer 类,Macbook 

public class Ipad extends SmartDevice {
	protected Ipad() {
	}

	@Override
	public void setOS() {
		mOS = "iOS 9.3.2系统";
	}
}
