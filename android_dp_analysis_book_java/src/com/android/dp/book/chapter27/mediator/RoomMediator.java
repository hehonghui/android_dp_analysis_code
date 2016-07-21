package com.android.dp.book.chapter27.mediator;

public abstract class RoomMediator {
	Host mHost ;
	Tenant mTenant ;
	RepairMan mWorker ;
	
	
	public void setHost(Host host) {
		this.mHost = host;
	}
	
	public void setTenant(Tenant tenant) {
		this.mTenant = tenant;
	}
	
	public void setWorker(RepairMan mWorker) {
		this.mWorker = mWorker;
	}

	public abstract void rentRoom() ;
}
