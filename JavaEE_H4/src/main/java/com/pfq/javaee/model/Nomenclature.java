package com.pfq.javaee.model;

public class Nomenclature {
	private String name;
	private String img_path;
	private String text;
	boolean productis;
	private int old_cost;
	private int cost;

	private Nomenclature() {
	}

	public String getName() {
		return name;
	}

	public String getImg_path() {
		return img_path;
	}

	public String getText() {
		return text;
	}

	public boolean isProductis() {
		return productis;
	}

	public int getOld_cost() {
		return old_cost;
	}

	public int getCost() {
		return cost;
	}

	public static Builder newBuilder() {
		return new Nomenclature().new Builder();
	}

	public class Builder {

		private Builder() {
		}

		public Builder setCost(int cost) {
			Nomenclature.this.cost = cost;
			return this;
		}

		public Builder setOld_cost(int old_cost) {
			Nomenclature.this.old_cost = old_cost;
			return this;
		}

		public Builder setProductis(boolean productis) {
			Nomenclature.this.productis = productis;
			return this;
		}

		public Builder setText(String text) {
			Nomenclature.this.text = text;
			return this;
		}

		public Builder setImg_path(String img_path) {
			Nomenclature.this.img_path = img_path;
			return this;
		}

		public Builder setName(String name) {
			Nomenclature.this.name = name;
			return this;
		}

		public Nomenclature build() {
			return Nomenclature.this;
		}
	}
}
