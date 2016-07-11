package com.android.dp.book.chapter03;

//测试代码 
public class Test {
	public static void main(String[] args) { // 构建器
		Builder builder = new MacbookBuilder();
		// Director
		Director pcDirector = new Director(builder);
		// 封装构建过程, 4 核, 内存 2GB, Mac 系统 
		pcDirector.construct("英特尔主板","Retina 显示器");
		// 构建电脑, 输出相关信息
		System.out.println("Computer Info : " + builder.create().toString());
	}
}
