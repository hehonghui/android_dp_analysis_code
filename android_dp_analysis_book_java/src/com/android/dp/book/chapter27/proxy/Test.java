package com.android.dp.book.chapter27.proxy;

public class Test {
	public static void main(String[] args) {
		Game wowGame = new WOWGame() ;
		Game proxy = new GameProxy(wowGame, "mrsimple", "testpwd");
		proxy.play() ;
	}
}
