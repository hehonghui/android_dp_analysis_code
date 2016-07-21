package com.android.dp.book.chapter27.facade;

import java.util.Random;

public class CrashUploader {
	public boolean upload(String stacktrace) {
		System.out.println("上传crash信息 :  " + stacktrace);
		return new Random().nextInt(10) % 4 == 0 ;
	}
}
