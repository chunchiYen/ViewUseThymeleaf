package com.thinkpower.model;
public class Person {
	public  Person() {};
	public Person(String idno , String name , int age) 
	{
		this.idno = idno;
		this.name = name ;
		this.age = age;		
	}
  
    private String idno;   
    private String name;
    private int age;
    
    public void setIdno(String idno) {
    	this.idno = idno;
    }
    public String getIdno() {
    	return idno;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return name;
    }       
    public void setAge(int age) {
    	this.age = age;
    }
    public int getAge() {
    	return age;
    }
}
