package com.android.dp.book.chapter27.proxy;

import java.util.Random;

public class GameProxy implements Game{
	Game mGame ;
	String mUserName;
	String mUserPwd ;
	public GameProxy(Game game,String name, String pwd) {
		mGame = game ;
		mUserName = name ;
		mUserPwd = pwd ;
	}
	
	@Override
	public void play() {
		System.out.println("正在登录对方账户...");
		if ( login() ) {
			System.out.println("登录成功");
			mGame.play();
			System.out.println("游戏升级,得装备");
			System.out.println("退出游戏");
		}
	}
	
	private boolean login() {
		return new Random().nextInt(10) % 2 == 0 ;
	}
}
