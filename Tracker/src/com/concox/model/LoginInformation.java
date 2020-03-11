package com.concox.model;

/**
 * @author Chandan Shrivastava
 *
 */
public class LoginInformation {

	private final int terminalId;

	public LoginInformation(int terminalId) {
		super();
		this.terminalId = terminalId;
	}

	public int getTerminalId() {
		return terminalId;
	}
}
