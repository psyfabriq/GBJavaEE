package com.pfq.javaee.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class AdminController {
	private String hello = "HELLO !!!";

	public String getHello() {
		return hello;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}
	
	public void test() {
		System.out.println("TEST !!!!!!!");
	}
}
