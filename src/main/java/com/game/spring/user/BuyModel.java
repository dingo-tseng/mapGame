package com.game.spring.user;

public class BuyModel {
	private String uid;
	private String iid;
	private String quantity;
	
	
	public BuyModel() {}
	public BuyModel(String uid, String iid, String quantity) {
		super();
		this.uid = uid;
		this.iid = iid;
		this.quantity = quantity;
	}
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getIid() {
		return iid;
	}
	public void setIid(String iid) {
		this.iid = iid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
	
}
