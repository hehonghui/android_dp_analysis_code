package com.android.dp.book.chapter27.mediator;

public class Test {
	public static void main(String[] args) {
		
		// 中介
		RoomMediator mediator = new LianjiaMediator() ;
		
		// 参与者
		Host host = new Host(mediator) ;
		Tenant tenant = new Tenant(mediator) ;
		RepairMan worker = new RepairMan(mediator) ;
		
		// 将参与者设置给中介
		mediator.setHost(host) ;
		mediator.setTenant(tenant) ;
		mediator.setWorker(worker) ;
		
		// 执行操作
		tenant.rentARoom() ;
	}
}
