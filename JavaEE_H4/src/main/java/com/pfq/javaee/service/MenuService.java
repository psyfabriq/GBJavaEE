package com.pfq.javaee.service;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
	
	public List<String> getListNavigate() {		
		List<String> list = new ArrayList<>();
		list.add("<a href=\"./\">Главная</a>");
		list.add("<a href=\"./catalog\">Каталог</a>");
		list.add("<a href=\"./order\">Заказ</a>");
		list.add("<a href=\"./cart\">Корзина</a>");
		return list;
	}
	
}
