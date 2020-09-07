package com.game.spring.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class ItemModel{

	
    private Integer iid;
    private Integer quantity;
    private String name;
    private String content;
    private Integer payment;
    
    public ItemModel(){}
	public ItemModel(Integer iid, Integer quantity, String name, String content, Integer payment) {
		super();
		this.iid = iid;
		this.quantity = quantity;
		this.name = name;
		this.content = content;
		this.payment = payment;
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
	public Integer getIid() {
		return iid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
    
    
	
}
