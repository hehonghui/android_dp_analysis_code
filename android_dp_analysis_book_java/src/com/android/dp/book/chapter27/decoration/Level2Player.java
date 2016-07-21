package com.android.dp.book.chapter27.decoration;

public class Level2Player implements Playable {

	Playable mPlayer ;
	public Level2Player(Playable playable) {
		mPlayer = playable ;
	}
	
	@Override
	public void attack() {
		System.out.println("装配战斧");
		mPlayer.attack();
		System.out.println("敌人被砍伤,生命值再减10");
	}
}
