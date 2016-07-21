package com.android.dp.book.chapter27.decoration;

public class Test {
	public static void main(String[] args) {
		Playable playable = new Player() ;
		playable.attack();
		
		Playable level2 = new Level2Player(playable) ;
		level2.attack() ;
	}
}
