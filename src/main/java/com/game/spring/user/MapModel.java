package com.game.spring.user;

import java.util.List;

import com.game.spring.entity.Postoffice;
import com.game.spring.entity.Seven;

public class MapModel {
	private List<Postoffice> postoffices;
	private List<Seven> sevens;
	
	
	public MapModel() {}
	public MapModel(List<Postoffice> postoffices, List<Seven> sevens) {
		super();
		this.postoffices = postoffices;
		this.sevens = sevens;
	}
	
	public List<Postoffice> getPostoffices() {
		return postoffices;
	}
	public void setPostoffices(List<Postoffice> postoffices) {
		this.postoffices = postoffices;
	}
	public List<Seven> getSevens() {
		return sevens;
	}
	public void setSevens(List<Seven> sevens) {
		this.sevens = sevens;
	}
	
}
