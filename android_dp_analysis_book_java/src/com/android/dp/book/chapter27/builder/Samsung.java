package com.android.dp.book.chapter27.builder;

//具体的 Computer 类,Macbook 

public class Samsung extends SmartDevice {
	protected Samsung() {
	}

	@Override
	public void setOS() {
		mOS = "三星 Android系统";
	}
}
