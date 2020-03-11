package com.concox.model;

import java.util.Calendar;
import java.util.Date;
import static com.concox.model.IConcoxPacket.*;

/**
 * @author Chandan Shrivastava
 *
 */
public class Information {

	private Information(InformationBuilder builder) {
		this.gpsInformation = builder.gpsInformation;
		this.lbsInformation = builder.lbsInformation;
		this.loginInformation = builder.loginInformation;
		this.statusInformation = builder.statusInformation;
	}

	private GPSInformation gpsInformation;
	private LBSInformation lbsInformation;
	private LoginInformation loginInformation;
	private StatusInformation statusInformation;
	
	
	public static class InformationBuilder {
		private final int protocolNumber;
		//private final String informationSection;
		public InformationBuilder(int protocolNumber){
			this.protocolNumber = protocolNumber;
		}
		
		GPSInformation gpsInformation;
		LBSInformation lbsInformation;
		LoginInformation loginInformation;
		StatusInformation statusInformation;
		/*
		 * Only available in Location and Alarm Datapacket
		 */
		//0B 08 1D 11 2E 10    CC 02 7A C7 EB 0C 46 58 49 00 14 8F
		public InformationBuilder setLocationInformation(String[] tokens) {
			int i = 0;
			int year = Integer.valueOf(tokens[i++], 16);
			int month = Integer.valueOf(tokens[i++], 16);
			int date = Integer.valueOf(tokens[i++], 16);
			int hourOfDay = Integer.valueOf(tokens[i++], 16);
			int minute = Integer.valueOf(tokens[i++], 16);
			int second = Integer.valueOf(tokens[i++], 16);

			Calendar cal = Calendar.getInstance();
			// Date todayDate = new Date();
			cal.set(year, month, date, hourOfDay, minute, second);

			Date dateObj = cal.getTime();

			int numberOfSattelites = Integer.valueOf(tokens[i++], 16);
			int latitude = Integer.valueOf(tokens[i++] + tokens[i++] + tokens[i++] + tokens[i++], 16);
			int longitude = Integer.valueOf(tokens[i++] + tokens[i++] + tokens[i++] + tokens[i++], 16);
			int speed = Integer.valueOf(tokens[i++], 16);
			String byte1 = Integer.toBinaryString(Integer.valueOf(tokens[i++], 16));
			String byte2 = Integer.toBinaryString(Integer.valueOf(tokens[i++], 16));
			String status = byte1.substring(0, 4);
			String course = byte2.substring(4);

			gpsInformation = new GPSInformation(dateObj, numberOfSattelites, latitude, longitude, speed, course,
					status);
			int mcc = Integer.valueOf(tokens[i++] + tokens[i++], 16);
			int mnc = Integer.valueOf(tokens[i++], 16);
			int lac = Integer.valueOf(tokens[i++] + tokens[i++], 16);
			int cellTowerId = Integer.valueOf(tokens[i++] + tokens[i++] + tokens[i++], 16);
			lbsInformation = new LBSInformation(mcc, mnc, lac, cellTowerId);
			return this;
		}
		
		
		public InformationBuilder setStatusInformation(String[] tokens) {
			int i = 0;
			int terminalInformationContent = Integer.valueOf(tokens[i++], 16);
			int voltageLevel = Integer.valueOf(tokens[i++], 16);
			int gsmSignalStrength = Integer.valueOf(tokens[i++], 16);
			int alarmLanguage = Integer.valueOf(tokens[i++] + tokens[i++], 16);
			statusInformation = new StatusInformation(terminalInformationContent, voltageLevel, gsmSignalStrength, alarmLanguage);
			return this;
		}
		
		public InformationBuilder setLoginInformation(String[] tokens) {
			int i = 0;
			int terminalId = Integer.valueOf(tokens[i++], 16);
			loginInformation = new LoginInformation(terminalId);
			return this;
		}
		
		public Information build() {
			return new Information(this);
		}
	}


	@Override
	public String toString() {
		return "Information [" + gpsInformation != null ? ("gpsInformation=" + gpsInformation + ",") : "" 
								+ lbsInformation != null ? (" lbsInformation=" + lbsInformation + ",") : ""
								 + loginInformation != null ? ("loginInformation=" + loginInformation + ",") : ""
									 + statusInformation != null ? ("statusInformation=" + statusInformation + ",") : ""
				+ "]";
	}
	
	
}
