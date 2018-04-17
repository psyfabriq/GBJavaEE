package com.pfq.javaee.service;

import java.util.ArrayList;
import java.util.List;

import com.pfq.javaee.model.Nomenclature;

public class CatalogService {
	private final String res = "./resources/img/";
	
	public List<Nomenclature> getListProducts() {
		List<Nomenclature> list = new ArrayList<>();
		
		list.add(Nomenclature.newBuilder()
				.setName("Хлорофитум")
				.setImg_path(res+"1.jpg")
				.setCost(650)
				.setOld_cost(720)
				.setProductis(true)
				.setText("Одно из самых неприхотливых комнатных растений, отлично очищающее воздух в помещении")
				.build());
		list.add(Nomenclature.newBuilder()
				.setName("Хлорофитум")
				.setImg_path(res+"2.jpg")
				.setCost(650)
				.setOld_cost(720)
				.setProductis(true)
				.setText("Одно из самых неприхотливых комнатных растений, отлично очищающее воздух в помещении")
				.build());
		list.add(Nomenclature.newBuilder()
				.setName("Хлорофитум")
				.setImg_path(res+"3.jpg")
				.setCost(650)
				.setOld_cost(720)
				.setProductis(true)
				.setText("Одно из самых неприхотливых комнатных растений, отлично очищающее воздух в помещении")
				.build());
		list.add(Nomenclature.newBuilder()
				.setName("Хлорофитум")
				.setImg_path(res+"4.jpg")
				.setCost(650)
				.setOld_cost(720)
				.setProductis(true)
				.setText("Одно из самых неприхотливых комнатных растений, отлично очищающее воздух в помещении")
				.build());
		list.add(Nomenclature.newBuilder()
				.setName("Хлорофитум")
				.setImg_path(res+"5.jpg")
				.setCost(650)
				.setOld_cost(720)
				.setProductis(true)
				.setText("Одно из самых неприхотливых комнатных растений, отлично очищающее воздух в помещении")
				.build());
		list.add(Nomenclature.newBuilder()
				.setName("Хлорофитум")
				.setImg_path(res+"6.jpg")
				.setCost(650)
				.setOld_cost(720)
				.setProductis(true)
				.setText("Одно из самых неприхотливых комнатных растений, отлично очищающее воздух в помещении")
				.build());
		list.add(Nomenclature.newBuilder()
				.setName("Хлорофитум")
				.setImg_path(res+"7.jpg")
				.setCost(650)
				.setOld_cost(720)
				.setProductis(true)
				.setText("Одно из самых неприхотливых комнатных растений, отлично очищающее воздух в помещении")
				.build());
		list.add(Nomenclature.newBuilder()
				.setName("Хлорофитум")
				.setImg_path(res+"8.jpg")
				.setCost(650)
				.setOld_cost(720)
				.setProductis(true)
				.setText("Одно из самых неприхотливых комнатных растений, отлично очищающее воздух в помещении")
				.build());
		return list;
	}
}
