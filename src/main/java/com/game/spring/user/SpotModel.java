package com.game.spring.user;

import java.util.List;

public class SpotModel {
	
	private String sid;
	private String name;
	private String type;
	private Double longitude;
	private Double latitude;
	private ChestScaleModel chest;
	private List<ItemModel> shopitems;
	
	public SpotModel() {}
	


	public SpotModel(String sid, String name, String type, Double longitude, Double latitude, ChestScaleModel chest,
			List<ItemModel> shopitems) {
		super();
		this.sid = sid;
		this.name = name;
		this.type = type;
		this.longitude = longitude;
		this.latitude = latitude;
		this.chest = chest;
		this.shopitems = shopitems;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public ChestScaleModel getChest() {
		return chest;
	}

	public void setChest(ChestScaleModel chest) {
		this.chest = chest;
	}

	public List<ItemModel> getShopitems() {
		return shopitems;
	}

	public void setShopitems(List<ItemModel> shopitems) {
		this.shopitems = shopitems;
	}

	public String getSid() {
		return sid;
	}
	
}