package com.ufc.projetoTcc2;

import java.io.Serializable;

public class Photo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private Integer width;
	
	private Integer height;
	
	private Urls urls;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Urls getUrls() {
		return urls;
	}

	public void setUrls(Urls urls) {
		this.urls = urls;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
