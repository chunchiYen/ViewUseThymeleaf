package com.thinkpower.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("藥局Entity")
public class Pharmacy {
	@ApiModelProperty("藥局id")
	public String id;
	@ApiModelProperty("藥局名稱")
	public String name;
	public String phone;
	public String address;
	public String mask_adult;
	public String mask_child;
	public String updated;
	public String county;
	public String town;
	public String cunli;
	
	public Pharmacy(String id,  String name, String phone,  String address,
            String mask_adult,  String mask_child,  String updated,  String county,
            String town,  String cunli){
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.mask_adult = mask_adult;
		this.mask_child = mask_child;
		this.updated = updated;
		this.county = county;
		this.town = town;
		this.cunli = cunli;	
	}
	
	
}
