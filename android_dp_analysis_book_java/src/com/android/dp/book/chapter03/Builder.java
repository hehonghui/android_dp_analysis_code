package com.android.dp.book.chapter03;

//抽象 Builder 类
public abstract class Builder {
	// 设置主机
	public abstract void buildBoard(String board);

	// 设置显示器
	public abstract void buildDisplay(String displau);

	// 设置操作系统
	public abstract void buildOS();

	// 创建 ComputerÏ
	public abstract Computer create();
}
