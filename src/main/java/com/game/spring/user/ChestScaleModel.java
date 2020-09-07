package com.game.spring.user;


import java.util.List;


public class ChestScaleModel {
	private List<ChestListModel> chests;
	private Integer l;
	private Integer m;
	private Integer s;
	
	
	public ChestScaleModel() {}
	public ChestScaleModel(Integer l, Integer m, Integer s) {
		super();
		this.l = l;
		this.m = m;
		this.s = s;
	}
	public ChestScaleModel(List<ChestListModel> chests, Integer l, Integer m, Integer s) {
		super();
		this.chests = chests;
		this.l = l;
		this.m = m;
		this.s = s;
	}




	public List<ChestListModel> getChests() {
		return chests;
	}


	public void setChests(List<ChestListModel> chests) {
		this.chests = chests;
	}


	public Integer getL() {
		return l;
	}


	public void setL(Integer l) {
		this.l = l;
	}


	public Integer getM() {
		return m;
	}


	public void setM(Integer m) {
		this.m = m;
	}


	public Integer getS() {
		return s;
	}


	public void setS(Integer s) {
		this.s = s;
	}

	
}