package com.game.spring.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class ChestListVO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	private String spotid;

	private Integer chestsize;

	private Integer chestlevel;

	private Date taketime;

	private Integer takeby;

	
	
	
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

	public Date getTaketime() {
		return taketime;
	}

	public void setTaketime(Date taketime) {
		this.taketime = taketime;
	}

	public Integer getTakeby() {
		return takeby;
	}

	public void setTakeby(Integer takeby) {
		this.takeby = takeby;
	}
	
	
	
}
