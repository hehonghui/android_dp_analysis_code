package com.android.dp.book.chapter27.builder;

// 智能设备基类
public abstract class SmartDevice {
	protected String mCpu; 
	protected String mDisplay; 
	protected String mOS;
	
	protected SmartDevice() { }
	
	// 设置 CPU 核心数
	public void setCPU(String cpu) {
		mCpu = cpu; 
	}
	
	// 设置显示器
	public void setDisplay(String display) {
		mDisplay = display; 
	}
	
	// 设置操作系统
	public abstract void setOS();
	
	@Override
	public String toString() {
		return "MobilePhone [cpu=" + mCpu + ", 显示器=" + mDisplay + ", 系统=" + mOS + "]";
	}
}
