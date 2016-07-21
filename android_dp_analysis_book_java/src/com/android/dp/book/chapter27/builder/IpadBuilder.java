package com.android.dp.book.chapter27.builder;

// Ipad Builder 类,
public class IpadBuilder extends Builder {
	private SmartDevice mMobilePhone = new Ipad();

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
