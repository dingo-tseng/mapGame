package com.game.spring.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class ChestListModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer ctid;
	
	private String spotid;

	private Integer chestsize;

	private Integer chestlevel;


	
	
	public ChestListModel() {}
	public ChestListModel(Integer ctid, String spotid, Integer chestsize, Integer chestlevel) {
		super();
		this.ctid = ctid;
		this.spotid = spotid;
		this.chestsize = chestsize;
		this.chestlevel = chestlevel;

	}

	public Integer getCtid() {
		return ctid;
	}

	public String getSpotid() {
		return spotid;
	}

	public void setSpotid(String spotid) {
		this.spotid = spotid;
	}

	public Integer getChestsize() {
		return chestsize;
	}

	public void setChestsize(Integer chestsize) {
		this.chestsize = chestsize;
	}

	public Integer getChestlevel() {
		return chestlevel;
	}

	public void setChestlevel(Integer chestlevel) {
		this.chestlevel = chestlevel;
	}
}