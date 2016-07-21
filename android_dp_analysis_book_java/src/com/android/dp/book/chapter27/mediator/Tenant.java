package com.android.dp.book.chapter27.mediator;

// 承租人
public class Tenant extends Participator {

	public Tenant(RoomMediator mediator) {
		super(mediator);
	}
	
	public void rentARoom() {
		System.out.println("----租户通过中介租房----");
		mMediator.rentRoom() ;
	}
}
