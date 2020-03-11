package com.concox.model;

/**
 * @author Chandan Shrivastava
 *
 */
public class DataPacket {

	final int startBit;// 2 Bytes
	final int packetLength; // 1 Byte
	final int protocolNumber; // 1 Byte
	final Information information; 
	final int informationSerialNumber; // 2 Bytes
	final int errorCheck; // 2 Bytes
	final int stopBit; // 2 Bytes
	
	
	public DataPacket(int startBit, int packetLength, int protocolNumber, Information info, int informationSerialNumber, int errorCheck,
			int stopBit) {
		super();
		this.startBit = startBit;
		this.packetLength = packetLength;
		this.protocolNumber = protocolNumber;
		this.information = info;
		this.informationSerialNumber = informationSerialNumber;
		this.errorCheck = errorCheck;
		this.stopBit = stopBit;
	}


	public int getStartBit() {
		return startBit;
	}


	public int getPacketLength() {
		return packetLength;
	}


	public int getProtocolNumber() {
		return protocolNumber;
	}


	public Information getInformation() {
		return information;
	}


	public int getInformationSerialNumber() {
		return informationSerialNumber;
	}


	public int getErrorCheck() {
		return errorCheck;
	}


	public int getStopBit() {
		return stopBit;
	}


	@Override
	public String toString() {
		return "DataPacket [startBit=" + startBit + ", packetLength=" + packetLength + ", protocolNumber="
				+ protocolNumber + ", information=" + information + ", informationSerialNumber="
				+ informationSerialNumber + ", errorCheck=" + errorCheck + ", stopBit=" + stopBit + "]";
	}
	
}
