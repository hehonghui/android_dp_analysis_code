package com.android.dp.book.chapter03;

//Director 类,负责构造 Computer 
public class Director {
	Builder mBuilder = null;

	/**
	 * @param builder
	 */
	public Director(Builder builder) {
		mBuilder = builder;
	}

	/**
	 * 构建对象
	 */
	public void construct(String board, String display) {
		mBuilder.buildBoard(board);
		mBuilder.buildDisplay(display);
		mBuilder.buildOS();
	}
}