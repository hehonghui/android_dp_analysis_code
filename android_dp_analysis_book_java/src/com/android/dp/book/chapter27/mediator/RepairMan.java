package com.android.dp.book.chapter27.mediator;

public class RepairMan extends Participator {

	public RepairMan(RoomMediator mediator) {
		super(mediator);
	}
	
	public void repair() {
		System.out.println("维修人员检查并维修家电");
	}

}
