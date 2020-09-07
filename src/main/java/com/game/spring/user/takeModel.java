package com.game.spring.user;

public class takeModel {
	private String uid;
	private String ctid;
	
	public takeModel() {}
	public takeModel(String uid, String ctid) {
		super();
		this.uid = uid;
		this.ctid = ctid;
	}

	public String getCtid() {
		return ctid;
	}

	public void setCtid(String ctid) {
		this.ctid = ctid;
	}

	public String getUid() {
		return uid;
	}
	
	
}
