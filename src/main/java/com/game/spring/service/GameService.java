package com.game.spring.service;

import java.util.List;

import com.game.spring.entity.*;
import com.game.spring.model.BackMessage;
import com.game.spring.user.BuyModel;
import com.game.spring.user.User;
import com.game.spring.user.takeModel;
import com.game.spring.vo.*;

public interface GameService {

	public List<PersonVO> getAllPerson();

	public PersonResultVO checkLogin(PersonVO p);

	public PersonResultVO register(Person p);
	
	public PersonResultVO checkName(PersonVO p);
	
	public PersonResultVO changePassword(PersonVO p);
	
	public boolean activeUser(String code);
	
	public boolean checkUser(String name);
	
	/*----------------------------------------*/
	/*�I*/
	public BackMessage setAllMapSpot();
	public BackMessage getAllMapSpot();
	public BackMessage getAllSpot();
	/*�l��*/

	
	/*�_�c*/
	public BackMessage Buy(BuyModel buyModel);
	public BackMessage putChest();
	public BackMessage takeChest(takeModel takeM);
	/*�ө�*/
	public BackMessage putShop();
	public BackMessage ShopChangeItem(String Shopid,Integer iid,Integer quantity);
	/*���a*/
	public BackMessage getPlayerInf(User user);
	public BackMessage PlayerChangeItem(Integer uid,Integer iid,Integer quantity);
	public BackMessage PlayerUpdataTime(Integer uid);
	
	public BackMessage test();
	
}
