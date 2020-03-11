package com.concox.model;

import java.util.Date;

/**
 * @author Chandan Shrivastava
 *
 */
public class GPSInformation {

	private final Date dateTime;
	private final int gpsQuantity;
	private final int latitude;
	private final int longitude;
	private final int speed;
	private final String course;
	private final String status;
	
	public GPSInformation(Date dateTime, int gpsQuantity, int latitude, int longitude, int speed, String course,
			String status) {
		super();
		this.dateTime = dateTime;
		this.gpsQuantity = gpsQuantity;
		this.latitude = latitude;
		this.longitude = longitude;
		this.speed = speed;
		this.course = course;
		this.status = status;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public int getGpsQuantity() {
		return gpsQuantity;
	}

	public int getLatitude() {
		return latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getSpeed() {
		return speed;
	}

	public String getCourse() {
		return course;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "GPSInformation [dateTime=" + dateTime + ", gpsQuantity=" + gpsQuantity + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", speed=" + speed + ", course=" + course + ", status=" + status + "]";
	}
	
	
}
