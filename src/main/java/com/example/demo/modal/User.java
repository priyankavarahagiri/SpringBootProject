package com.example.demo.modal;

public class User 
{
	String name;
	String address;
	int phoneno;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	@Override
	public String toString() {
		return "user [name=" + name + ", address=" + address + ", phoneno=" + phoneno + "]";
	}
	public User(String name, String address, int phoneno) {
		super();
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
	}
	

}
