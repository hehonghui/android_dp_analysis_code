package com.android.dp.book.chapter27.command;

public class General {

	Command mCommand;

	public void setCommand(Command cmd) {
		this.mCommand = cmd;
	}

	public void publishCommand() {
		mCommand.execute();
	}
}
