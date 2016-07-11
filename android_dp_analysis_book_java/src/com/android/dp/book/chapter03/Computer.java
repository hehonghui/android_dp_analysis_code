package com.android.dp.book.chapter03;

public abstract class Computer {
	protected String mBoard; 
	protected String mDisplay; 
	protected String mOS;
	
	protected Computer() { }
	// 设置 CPU 核心数
	public void setBoard(String board) {
		mBoard = board; 
	}
	// 设置内存
	public void setDisplay(String display) {
		mDisplay = display; 
	}
	// 设置操作系统
	public abstract void setOS();
	
	@Override
	public String toString() {
		return "Computer [mBoard=" + mBoard + ", mDisplay=" + mDisplay + ", mOS=" + mOS + "]";
	}
}
