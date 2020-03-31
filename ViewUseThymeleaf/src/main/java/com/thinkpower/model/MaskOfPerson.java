package com.thinkpower.model;

public class MaskOfPerson {
	public String idno ;
	public String password;
	public String name;
	public String cellPhone;
	public String lastPurchaseTime;
	public String lastPurchaseCVS;
	
	public String prePurchaseTime;
	public String prePurchaseCVS;
	
	
	public MaskOfPerson(String idno , String password , String name , String cellPhone ,
				String lastPurchaseTime , String lastPuchaseCVS , String prePurchaseTime , String prePuchaseCVS) {
		super();
		this.idno = idno;
		this.password = password;
		this.name = name;
		this.cellPhone = cellPhone;
		this.lastPurchaseTime = lastPurchaseTime;
		this.lastPurchaseCVS = lastPuchaseCVS;		
		this.prePurchaseTime = prePurchaseTime;
		this.prePurchaseCVS = prePuchaseCVS;
	}
	public MaskOfPerson(String idno , String password , String name , String cellPhone ,
			String lastPurchaseTime , String lastPuchaseCVS) {
	super();
	this.idno = idno;
	this.password = password;
	this.name = name;
	this.cellPhone = cellPhone;
	this.lastPurchaseTime = lastPurchaseTime;
	this.lastPurchaseCVS = lastPuchaseCVS;
	}
	public void setPrePurchaseInfo(String prePurchaseTime , String prePurchaseCVS) {
		this.prePurchaseTime = prePurchaseTime;
		this.prePurchaseCVS = prePurchaseCVS;
		
	}
	public static MaskOfPerson getInstance(MaskOfPerson maskOfPerson) {
		MaskOfPerson m = new MaskOfPerson(maskOfPerson.idno ,maskOfPerson.password, maskOfPerson.name
				,maskOfPerson.cellPhone, maskOfPerson.lastPurchaseTime, maskOfPerson.lastPurchaseCVS
				,maskOfPerson.prePurchaseTime , maskOfPerson.prePurchaseCVS);	
		return m;
	}
}
