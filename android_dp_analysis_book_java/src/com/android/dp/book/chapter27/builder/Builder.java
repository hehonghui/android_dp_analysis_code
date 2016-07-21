package com.android.dp.book.chapter27.builder;

//抽象 Builder 类
public abstract class Builder {
	// 设置cpu
	public abstract void buildCpu(String board);
	// 设置显示器
	public abstract void buildDisplay(String display);
	// 设置操作系统
	public abstract void buildOS();
	// 创建 手机
	public abstract SmartDevice create();
}
