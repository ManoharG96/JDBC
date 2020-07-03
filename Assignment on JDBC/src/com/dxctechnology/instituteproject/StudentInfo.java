package com.dxctechnology.instituteproject;

public class StudentInfo {
	
	private int studId;
	private String studName;
	private String studAddress;
	private String studCity;
	private String studCountry;
	private long studMobNo;
	public int getStudId() {
		return studId;
	}
	public String getStudName() {
		return studName;
	}
	public String getStudAddress() {
		return studAddress;
	}
	public String getStudCity() {
		return studCity;
	}
	public String getStudCountry() {
		return studCountry;
	}
	public long getStudMobNo() {
		return studMobNo;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}
	public void setStudCity(String studCity) {
		this.studCity = studCity;
	}
	public void setStudCountry(String studCountry) {
		this.studCountry = studCountry;
	}
	public void setStudMobNo(long studMobNo) {
		this.studMobNo = studMobNo;
	}
	@Override
	public String toString() {
		return "StudentInfo [studId=" + studId + ", studName=" + studName + ", studAddress=" + studAddress
				+ ", studCity=" + studCity + ", studCountry=" + studCountry + ", studMobNo=" + studMobNo + "]";
	}
	

}
