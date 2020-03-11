package com.concox.model;

/**
 * @author Chandan Shrivastava
 *
 */
public class StatusInformation {

	private final int terminalInformationContent;
	private final int voltageLevel;
	private final int gsmSignalStrength;
	private final int alarmLanguage;
	
	public StatusInformation(int terminalInformationContent, int voltageLevel, int gsmSignalStrength,
			int alarmLanguage) {
		super();
		this.terminalInformationContent = terminalInformationContent;
		this.voltageLevel = voltageLevel;
		this.gsmSignalStrength = gsmSignalStrength;
		this.alarmLanguage = alarmLanguage;
	}

	public int getTerminalInformationContent() {
		return terminalInformationContent;
	}

	public int getVoltageLevel() {
		return voltageLevel;
	}

	public int getGsmSignalStrength() {
		return gsmSignalStrength;
	}

	public int getAlarmLanguage() {
		return alarmLanguage;
	}
}
