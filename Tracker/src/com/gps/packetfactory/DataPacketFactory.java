package com.gps.packetfactory;

import java.util.Arrays;
import java.util.logging.Logger;

import com.concox.model.DataPacket;
import com.concox.model.IConcoxPacket;
import com.concox.model.Information;

public class DataPacketFactory implements IConcoxPacket {
	
	//Logger logger = Logge
	private DataPacketFactory() {
		
	}
	
	public static DataPacket getDataPacket(String bytes, String make) {
		DataPacketFactory factory = new DataPacketFactory();
		if (CONCOX.equals(make) && bytes != null) {
			String tokens[] = bytes.trim().split(" ");
			if(factory.validateConcoxDataPacket(tokens)){
				return factory.buildDataPacket(tokens);
			} else {
				System.out.println("Validation Failed .. ");
				return null;
			}
		}else {
			return null;
		}
	}
	
	public boolean validateConcoxDataPacket(String[] tokens){
		if(tokens.length < 4){
			return false;
		}
		int packetLength = Integer.valueOf(tokens[2], 16);
		int protocolNumber = Integer.valueOf(tokens[3], 16);
		if(packetLength != defaultPacketLength(protocolNumber)){
			return false;
		}
		return true;
	}
	
	public DataPacket buildDataPacket(String[] tokens) {
		Information info = null;
		int index = 0;
		int startBit = Integer.valueOf(tokens[index++] + tokens[index++], 16);
		int packetLength = Integer.valueOf(tokens[index++], 16);
		int protocolNumber = Integer.valueOf(tokens[index++], 16);
		int infoLength = defaultInformationContentLength(protocolNumber);
		if (LOCATION_PROTOCOL == protocolNumber ){
			info = new Information.InformationBuilder(protocolNumber).setLocationInformation(Arrays.copyOfRange(tokens, index, index+infoLength)).build();
		}else if(LOGIN_PROTOCOL == protocolNumber){
			info = new Information.InformationBuilder(protocolNumber).setLoginInformation(Arrays.copyOfRange(tokens, index, index+infoLength)).build();
		}else if(STATUS_PROTOCOL == protocolNumber){
			info = new Information.InformationBuilder(protocolNumber).setStatusInformation(Arrays.copyOfRange(tokens, index, index+infoLength)).build();
		}else if(ALARM_PROTOCOL == protocolNumber){
			info = new Information.InformationBuilder(protocolNumber).setLocationInformation(Arrays.copyOfRange(tokens, index, index+infoLength)).build();
		}
		index+=infoLength;
		int informationSerialNumber = Integer.valueOf(tokens[index++] + tokens[index++], 16);
		int errorCheck = Integer.valueOf(tokens[index++] + tokens[index++], 16);
		int stopBit = Integer.valueOf(tokens[index++] + tokens[index++], 16);
		return new DataPacket(startBit, packetLength, protocolNumber, info, informationSerialNumber, errorCheck, stopBit);
	}
	private static int defaultPacketLength(int protocolNumber){
		int N = defaultInformationContentLength(protocolNumber);
		int length=1+ N+2+2;// Protocol Number + Information Content(N) + Information Serial Number + Error Check, totally (5+N)Bytes
		return length;
	}
	
	private static int defaultInformationContentLength(int protocolNumber){
		int n = 0;
		switch(protocolNumber) {
		case 1:
			n = 1;
			break;
		case 18://Location Packet
			n = 18 + 8;
			break;
		case 19:
			n = 5;
			break;
		case 22:
			n = 18 + 5;
			break;
		}
		return n;
	}
}
