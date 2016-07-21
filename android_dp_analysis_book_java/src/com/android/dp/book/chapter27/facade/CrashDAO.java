package com.android.dp.book.chapter27.facade;

public class CrashDAO {
	public void insert(String stacktrace) {
		System.out.println("上传失败, 插入数据库 : " + stacktrace);
	}
	
	public String query() {
		System.out.println("读取crash缓存 ");
		return "缓存的crash 信息";
	}
}
