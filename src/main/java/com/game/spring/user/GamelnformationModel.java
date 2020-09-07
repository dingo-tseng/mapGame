package com.game.spring.user;

import java.util.Date;

public class GamelnformationModel{


    private Integer giid;
    private String nickname;
    private Integer level;
    private Integer hp;
    private Integer money;
    private Integer moveMoney;
    private SpotModel position;
    private Date logintime;
    private Date logouttime;
    
    public GamelnformationModel(){}
	public GamelnformationModel(Integer giid, String nickname, Integer level, Integer hp, Integer money,
			Integer moveMoney, SpotModel position, Date logintime, Date logouttime) {
		super();
		this.giid = giid;
		this.nickname = nickname;
		this.level = level;
		this.hp = hp;
		this.money = money;
		this.moveMoney = moveMoney;
		this.position = position;
		this.logintime = logintime;
		this.logouttime = logouttime;
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
	public SpotModel getPosition() {
		return position;
	}
	public void setPosition(SpotModel position) {
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
	public Integer getGiid() {
		return giid;
	}
	
}
