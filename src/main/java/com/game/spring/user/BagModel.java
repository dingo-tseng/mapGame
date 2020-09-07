package com.game.spring.user;

import java.util.ArrayList;
import java.util.List;

public class BagModel{

	private Integer bid;
	private Integer size;
	private List<ItemModel> items;
	
	public BagModel() {}
	public BagModel(Integer bid, Integer size, List<ItemModel> items) {
		super();
		this.bid = bid;
		this.size = size;
		this.items = items;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public List<ItemModel> getItems() {
		return items;
	}
	public void setItems(List<ItemModel> items) {
		this.items = items;
	}
	public Integer getBid() {
		return bid;
	}
	
	
	
}
