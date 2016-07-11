package com.android.dp.book.chapter03;

//具体的 Computer 类,Macbook 

public class Macbook extends Computer {
	protected Macbook() {
	}

	@Override
	public void setOS() {
		mOS = "Mac OS X 10.10";
	}
}
