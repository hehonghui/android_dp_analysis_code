package com.android.dp.book.chapter27.decoration;

public class Player implements Playable {
	
	@Override
	public void attack() {
		System.out.println("攻击敌人, 生命值减1");
	}
}
