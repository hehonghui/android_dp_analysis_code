package com.android.dp.book.chapter27.mediator;

public abstract class Participator {
	RoomMediator mMediator ;

	public Participator(RoomMediator mediator) {
		this.mMediator = mediator;
	}
}
