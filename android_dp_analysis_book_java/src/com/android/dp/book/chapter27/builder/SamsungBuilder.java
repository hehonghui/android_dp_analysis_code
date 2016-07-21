package com.android.dp.book.chapter27.builder;

// 三星 Builder 类,
public class SamsungBuilder extends Builder {
	private SmartDevice mMobilePhone = new Samsung();

	@Override
	public void buildCpu(String cpu) {
		mMobilePhone.setCPU(cpu) ;
	}

	@Override
	public void buildDisplay(String display) {
		mMobilePhone.setDisplay(display);
	}

	@Override
	public void buildOS() {
		mMobilePhone.setOS();
	}

	@Override
	public SmartDevice create() {
		return mMobilePhone;
	}
}
