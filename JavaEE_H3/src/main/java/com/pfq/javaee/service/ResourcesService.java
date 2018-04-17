package com.pfq.javaee.service;

import java.util.ArrayList;
import java.util.List;

public class ResourcesService {
	
	private final String res = "./resources/";

	public List<String> getListCSS() {
		List<String> list = new ArrayList<>();	
		list.add(res+"css/bootstrap.min.css");
		list.add(res+"css/justified-nav.css");
		list.add(res+"css/style.css");
		return list;
	}

	public List<String> getListJS() {
		List<String> list = new ArrayList<>();
		list.add(res+"js/jquery.min.js");
		list.add(res+"js/bootstrap.min.js");
		return list;
	}

}
