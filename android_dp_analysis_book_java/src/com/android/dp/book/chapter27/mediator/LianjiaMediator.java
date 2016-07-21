package com.android.dp.book.chapter27.mediator;

public class LianjiaMediator extends RoomMediator {

	@Override
	public void rentRoom() {
		mHost.makePrice();
		mHost.sign();
		if (mWorker != null) {
			mWorker.repair();
		}
		System.out.println("完成租房!");
	}

}
