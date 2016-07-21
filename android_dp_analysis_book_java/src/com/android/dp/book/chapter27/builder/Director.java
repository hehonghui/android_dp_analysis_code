package com.android.dp.book.chapter27.builder;

//Director 类,负责构造手机 
public class Director {
	Builder mBuilder = null;

	/**
	 * @param builder
	 */
	public Director(Builder builder) {
		mBuilder = builder;
	}

	/**
	 * 构建对象 【这里的过程类似于 模板方法】
	 */
	public void construct(String cpu, String display) {
		mBuilder.buildCpu(cpu);
		mBuilder.buildDisplay(display);
		mBuilder.buildOS();
	}
}