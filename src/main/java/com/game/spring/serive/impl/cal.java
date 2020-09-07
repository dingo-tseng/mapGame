package com.game.spring.serive.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.game.spring.entity.*;
import com.game.spring.user.*;
import com.game.spring.vo.ItemVO;

public class cal {
	

	static public User getPlayerInf(Integer uid,Person person,Gamelnformation gamelnformation,Bag bag, Map<Item,Integer> items,Spot spot,ChestScaleModel CSM,Map<Item,Integer> shopitems) {
		//背包
		List<ItemModel> itemMs=new ArrayList();
		if(items != null){
			for(Entry<Item,Integer> e:items.entrySet())
			{
				ItemModel itemM =new ItemModel(e.getKey().getIid(),e.getValue(),e.getKey().getName(),e.getKey().getContent(),e.getKey().getPayment());
				itemMs.add(itemM);
			}
		}
		BagModel bagM=null;
		if(bag != null){
			bagM=new BagModel(bag.getBid(),bag.getSize(),itemMs);
		}
		//遊戲資訊
		List<ItemModel> shopItemMs=new ArrayList();
		if(shopitems != null){
			for(Entry<Item,Integer> e:shopitems.entrySet())
			{
				ItemModel shopitemM =new ItemModel(e.getKey().getIid(),e.getValue(),e.getKey().getName(),e.getKey().getContent(),e.getKey().getPayment());
				shopItemMs.add(shopitemM);
			}
		}
		SpotModel spotM=null;
		if(spot != null) {
			spotM=new SpotModel(spot.getSid(),spot.getName(),spot.getType(),spot.getLongitude(),spot.getLatitude(),CSM,shopItemMs);
		}
		GamelnformationModel GamelnfM=null;
		if(gamelnformation != null) {
				GamelnfM= new GamelnformationModel(gamelnformation.getGiid(),gamelnformation.getNickname(),gamelnformation.getLevel(),gamelnformation.getHp(),gamelnformation.getMoney(),gamelnformation.getMoveMoney(),spotM,gamelnformation.getLogintime(),gamelnformation.getLogouttime());
		}
		//帳號資訊
		PersonModel personM=null;
		if(person !=null) {
			personM=new PersonModel(person.getPid(),person.getUsername(),person.getPassword(),person.getEmail(),null);
		}
		//使用者
		//User user=new User();
		User user=new User(uid.toString(),personM,GamelnfM,bagM);	

		return user;
	}
	static public ItemVO dropItem(List<Item> ilist) {
		int sum=0;
		ItemVO item=new ItemVO();
		for(Item i : ilist){
			sum+=i.getWeight();
		}
		int x=Random(0,sum);
		for(Item i : ilist){
			if((x-=i.getWeight())<0)
			{	
				Integer q=Normal(i.getExp(), i.getSd());
				item.setName(i.getName());
				item.setIid(i.getIid());
				item.setQuantity(q);
				item.setContent(i.getContent());
				item.setPayment(i.getPayment());
				return item;
			}
		}
		
		return null;
	}
	
	static public ItemVO dropLvItem(List<Item> ilist) {//未完
		int sum=0;
		ItemVO item=new ItemVO();
		for(Item i : ilist){
			sum+=i.getWeight();
		}
		int x=Random(0,sum);
		for(Item i : ilist){
			if((x-=i.getWeight())<0)
			{	
				Integer q=Normal(i.getExp(), i.getSd());
				item.setName(i.getName());
				item.setIid(i.getIid());
				item.setQuantity(q);
				item.setContent(i.getContent());
				item.setPayment(i.getPayment());
				return item;
			}
		}
		
		return null;
	}
	static public Integer Random(Integer i, Integer j) {
	Integer d=(int)(Math.random()*(j-i+1)+i);
	return d;
	}
	static public Integer Normal(Integer E ,Integer S){
		Integer x=(int)(new java.util.Random().nextGaussian()*S+E+0.5);
		if(x<0){
			x=1;
		}
		if(x>E+3*S) {
			x=E+3*S;
		}
		return x;
	}

}
