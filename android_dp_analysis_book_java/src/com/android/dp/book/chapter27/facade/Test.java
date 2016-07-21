package com.android.dp.book.chapter27.facade;

public class Test {
	public static void main(String[] args) {
		CrashSDK excepHandler = new CrashSDK() ;
		excepHandler.setExceptionHandler() ;
		
		throw new NullPointerException("空指针异常") ;
	}
}
