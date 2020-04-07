package com.thinkpower.model;

import java.util.Map;

public class Pharmacy {
	private String city;
	private Map<String , Integer>  pharmacyMap ;
	public Pharmacy(String city , Map<String,Integer> pharmacyMap) {
		this.city = city;
		this.pharmacyMap = pharmacyMap;
	}
	
	public String getCity() {		
		return city;
	}
	public Map<String,Integer> getPharmacyMap(){		
		return pharmacyMap;
	}
	
}
