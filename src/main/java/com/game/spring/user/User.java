package com.game.spring.user;

public class User {
	
	private String uid;
	private PersonModel person;
	private GamelnformationModel gamelnformation;
	private BagModel bag;
	
	public User() {}
	public User(String uid) {
		super();
		this.uid = uid;
	}
	public User(String uid, PersonModel person, GamelnformationModel gamelnformation, BagModel bag) {
		super();
		this.uid = uid;
		this.person = person;
		this.gamelnformation = gamelnformation;
		this.bag = bag;
	}
	
	public PersonModel getPerson() {
		return person;
	}
	public void setPerson(PersonModel person) {
		this.person = person;
	}
	public GamelnformationModel getGamelnformation() {
		return gamelnformation;
	}
	public void setGamelnformation(GamelnformationModel gamelnformation) {
		this.gamelnformation = gamelnformation;
	}
	public BagModel getBag() {
		return bag;
	}
	public void setBag(BagModel bag) {
		this.bag = bag;
	}
	public String getUid() {
		return uid;
	}
	
}
