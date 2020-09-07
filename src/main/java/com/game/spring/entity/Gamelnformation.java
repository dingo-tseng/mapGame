package com.game.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class Gamelnformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer giid;
	@Column(name = "nickname")
    private String nickname;
	@Column(name = "level")
    private Integer level;
	@Column(name = "hp")
    private Integer hp;
	@Column(name = "money")
    private Integer money;
	@Column(name = "moveMoney")
    private Integer moveMoney;
	@Column(name = "position")
    private String position;
	@Column(name = "logintime")
	//@CreatedDate //建立時間未完成
    private Date logintime;
	@Column(name = "logouttime")
	//@LastModifiedDate //修改時間未完成
    private Date logouttime;
	
	/*
	修改時自動創建時間
    @LastModifiedDate
	*/
	
	public Integer getGiid() {
		return giid;
	}
	public void setGiid(Integer giid) {
		this.giid = giid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getHp() {
		return hp;
	}
	public void setHp(Integer hp) {
		this.hp = hp;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getMoveMoney() {
		return moveMoney;
	}
	public void setMoveMoney(Integer moveMoney) {
		this.moveMoney = moveMoney;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	public Date getLogouttime() {
		return logouttime;
	}
	public void setLogouttime(Date logouttime) {
		this.logouttime = logouttime;
	}
	
}
