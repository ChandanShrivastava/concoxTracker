package com.concox.model;

/**
 * @author Chandan Shrivastava
 *
 */
public interface IConcoxPacket {

	static String CONCOX = "CONCOX";
	
	//Protocol Numbers 
	static final int LOGIN_PROTOCOL = Integer.valueOf("01",16);
	static final int LOCATION_PROTOCOL = Integer.valueOf("12",16);
	static final int STATUS_PROTOCOL = Integer.valueOf("13",16);
	static final int ALARM_PROTOCOL = Integer.valueOf("16",16);
	// Information Bytes length
	static final int GPS_BYTES = 12;
	static final int LBS_BYTES = 9;
	static final int LOGIN_BYTES = 1;
	static final int STATUS_BYTES = 5;
	
	boolean validateConcoxDataPacket(String[] tokens);
	DataPacket buildDataPacket(String[] tokens);
}
