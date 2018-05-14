package com.pfq.entity;

public class Link {
	private Link() {
	}

	private String url;
	private String title;
	
	
	public String getUrl() {
		return url;
	}


	public String getTitle() {
		return title;
	}

	public static Builder newBuilder() {
		return new Link(). new Builder();
	}
	public class Builder {
	

		private Builder() {}

		public Builder setURL(String url) {
			Link.this.url = "/javaee4/"+url;//costil
			return this;
		}

		public Builder setTitle(String title) {
			Link.this.title = title;
			return this;
		}

		public Link build() {
			return Link.this;
		}

	}
}
