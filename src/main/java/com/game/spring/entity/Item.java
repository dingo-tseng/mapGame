package com.game.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "iid")
    private Integer iid;
	@Column(name = "name")
    private String name;
	@Column(name = "content")
    private String content;
	@Column(name = "payment")
    private Integer payment;
	@Column(name = "weight")
    private Integer weight;
	@Column(name = "exp")
    private Integer exp;	
	@Column(name = "sd")
    private Integer sd;
	@Column(name = "itemlevel")
    private Integer itemlevel;
	
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getExp() {
		return exp;
	}
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	public Integer getSd() {
		return sd;
	}
	public void setSd(Integer sd) {
		this.sd = sd;
	}
	public Integer getItemlevel() {
		return itemlevel;
	}
	public void setItemlevel(Integer itemlevel) {
		this.itemlevel = itemlevel;
	}
	
}
