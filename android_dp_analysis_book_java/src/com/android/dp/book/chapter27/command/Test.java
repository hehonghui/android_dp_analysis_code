package com.android.dp.book.chapter27.command;

public class Test {
	public static void main(String[] args) {
		// 命令的发布者, invoker
		General general = new General() ;
		// 具体的命令, 命令中有执行者
		Command command = new AttackCommand(new Soldier()) ;
		
		general.setCommand(command) ;
		// 发布命令. 		[参考 Message, Handler的设计]
		general.publishCommand() ;
	}
}
