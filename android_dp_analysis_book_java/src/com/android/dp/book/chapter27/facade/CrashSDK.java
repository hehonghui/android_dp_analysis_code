package com.android.dp.book.chapter27.facade;

import java.lang.Thread.UncaughtExceptionHandler;

public final class CrashSDK {
	// 数据上传子系统
	private CrashUploader mUploader = new CrashUploader();
	// 数据存储子系统
	private CrashDAO mCrashDAO = new CrashDAO();

	public void setExceptionHandler() {
		System.out.println("初始化 Crash SDK");
		// 设置异常处理
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				// crash信息上传失败则插入到数据库
				if (!mUploader.upload(e.getMessage())) {
					mCrashDAO.insert(e.getMessage());
				}
			}
		});
	}
}
