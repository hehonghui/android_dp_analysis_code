package com.android.dp.book.chapter03;

//具体的 Builder 类,

public class MacbookBuilder extends Builder {
	private Computer mComputer = new Macbook();

	@Override
	public void buildBoard(String board) {
		mComputer.setBoard(board);
	}

	@Override
	public void buildDisplay(String display) {
		mComputer.setDisplay(display);
	}

	@Override
	public void buildOS() {
		mComputer.setOS();
	}

	@Override
	public Computer create() {
		return mComputer;
	}
}
