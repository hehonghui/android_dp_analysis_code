package com.android.dp.book.chapter27.builder;


//测试代码 
public class Test {
	public static void main(String[] args) { // 构建器
		Builder builder = new SamsungBuilder();
		// Director
		Director pcDirector = new Director(builder);
		// 封装构建过程, 8核CPU, 5.5英寸的大屏手机
		pcDirector.construct("AMD 8核","5.5英寸显示器");
		// 构建电脑, 输出相关信息
		System.out.println("手机信息 : " + builder.create().toString());
		
		
		IpadBuilder ipadBuilder = new IpadBuilder() ;
		pcDirector = new Director(ipadBuilder);
		// 封装构建过程, 8核CPU, 5.5英寸的大屏手机
		pcDirector.construct("Intel 双核","7.9 Retina");
		// 构建电脑, 输出相关信息
		System.out.println("手机信息 : " + ipadBuilder.create().toString());
	}
}
