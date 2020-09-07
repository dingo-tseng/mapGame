package com.game.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ChestList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ctid;
	@Column(name = "spotid")
	private String spotid;
	@Column(name = "chestsize")
	private Integer chestsize;
	@Column(name = "chestlevel")
	private Integer chestlevel;
	@Column(name = "taketime")
	private Date taketime;
	@Column(name = "takeby")
	private Integer takeby;
	
	public Integer getCtid() {
		return ctid;
	}
	public void setCtid(Integer ctid) {
		this.ctid = ctid;
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
