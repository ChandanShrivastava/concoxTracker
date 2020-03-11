package com.concox.model;

/**
 * @author Chandan Shrivastava
 *
 */
public class LBSInformation {

	private final int mobileCountryCode;
	private final int mobileNetworkCode;
	private final int localAreaCode;
	private final int cellTowerId;
	
	public LBSInformation(int mobileCountryCode, int mobileNetworkCode, int localAreaCode, int cellId) {
		super();
		this.mobileCountryCode = mobileCountryCode;
		this.mobileNetworkCode = mobileNetworkCode;
		this.localAreaCode = localAreaCode;
		this.cellTowerId = cellId;
	}

	public int getMobileCountryCode() {
		return mobileCountryCode;
	}

	public int getMobileNetworkCode() {
		return mobileNetworkCode;
	}

	public int getLocalAreaCode() {
		return localAreaCode;
	}

	public int getCellTowerId() {
		return cellTowerId;
	}

	@Override
	public String toString() {
		return "LBSInformation [mobileCountryCode=" + mobileCountryCode + ", mobileNetworkCode=" + mobileNetworkCode
				+ ", localAreaCode=" + localAreaCode + ", cellTowerId=" + cellTowerId + "]";
	}
	
	
}
