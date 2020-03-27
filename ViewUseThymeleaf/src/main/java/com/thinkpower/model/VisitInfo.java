package com.thinkpower.model;

public class VisitInfo {
	public String username;
	public String visitip;
	public String visittime;
	public VisitInfo(String username , String visitip , String visittime) {
		this.username = username;
		this.visitip =visitip;
		this.visittime =visittime;		
	}
	public String getUserName() {				
		return username;
	}
		public String getVisitIP() {
		return visitip;
	}
	public String getVisitTime() {
		return visittime;
	}
}
