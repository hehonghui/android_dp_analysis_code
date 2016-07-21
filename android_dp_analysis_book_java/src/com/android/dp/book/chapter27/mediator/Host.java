package com.android.dp.book.chapter27.mediator;
// 房主
public class Host extends Participator {
	
	public Host(RoomMediator mediator) {
		super(mediator);
	}
	
	public void makePrice() {
		System.out.println("房东报价");
	}
	
	public void sign() {
		System.out.println("房东签合同");
	}
}
