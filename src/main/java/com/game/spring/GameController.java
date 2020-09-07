package com.game.spring;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.game.spring.entity.ShopList;
import com.game.spring.model.BackMessage;
import com.game.spring.service.GameService;
import com.game.spring.user.BuyModel;
import com.game.spring.user.User;
import com.game.spring.user.takeModel;
import com.game.spring.vo.PersonResultVO;
import com.game.spring.vo.PersonVO;
import com.game.spring.vo.ShopListVO;


/**
*
* @author Administrator
*/
@RestController
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/getAllMapSpot", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BackMessage getAllMapSpot() {
		return gameService.getAllMapSpot();
	}
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/getAllSpot", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BackMessage getAllSpot() {
		return gameService.getAllSpot();
	}
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/putChest", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BackMessage putChest() {
		return gameService.putChest();
	}
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/putShop", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BackMessage putShop() {
		return gameService.putShop();
	}
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/getPlayerInf", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BackMessage getPlayerInf(@RequestBody User user) {
		System.out.println(user.getUid());
		return gameService.getPlayerInf(user);
	}
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/Buy", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BackMessage Buy(@RequestBody BuyModel buyModel) {
		return gameService.Buy(buyModel);
	}
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/takeChest", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BackMessage takeChest(@RequestBody takeModel takeM) {
		return gameService.takeChest(takeM);
	}
	
	@CrossOrigin(origins = "*")
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BackMessage test() {
		return gameService.test();
	}
	
}


