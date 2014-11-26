package com.hibernate.pog;

public class Person 
{
	private int id;
	private String name;
	private Address permanentAddress;
	private Address currentAddress;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public Address getPermanentAddress() 
	{
		return permanentAddress;
	}
	public void setPermanentAddress(Address permanentAddress) 
	{
		this.permanentAddress = permanentAddress;
	}
	public Address getCurrentAddress() 
	{
		return currentAddress;
	}
	public void setCurrentAddress(Address currentAddress) 
	{
		this.currentAddress = currentAddress;
	}

}
