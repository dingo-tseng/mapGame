package com.game.spring.serive.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.game.spring.dao.*;
import com.game.spring.entity.*;
import com.game.spring.mail.*;
import com.game.spring.model.BackMessage;
import com.game.spring.vo.*;
import com.game.spring.service.GameService;
import com.game.spring.user.BuyModel;
import com.game.spring.user.ChestListModel;
import com.game.spring.user.ChestScaleModel;
import com.game.spring.user.ItemModel;
import com.game.spring.user.MapModel;
import com.game.spring.user.SpotModel;
import com.game.spring.user.User;
import com.game.spring.user.takeModel;



@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private PersonDao personDao;
	@Autowired
	private PostofficeDao postofficeDao;
	@Autowired
	private ShopListDao shopListDao;
	@Autowired
	private BagListDao bagListDao;
	@Autowired
	private BagDao bagDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private GamelnformationDao gamelnformationDao;
	@Autowired
	private SpotDao spotDao;
	@Autowired
	private ChestListDao chestListDao;
	@Autowired
	private SevenDao sevenDao;

	
	
	
	// 找所有帳號
	@Transactional(readOnly = true)
	@Override
	public List<PersonVO> getAllPerson() {

		List<PersonVO> resultList = new ArrayList<PersonVO>();
		List<Person> personList = personDao.findAll();
		if (personList != null) {
			for (Person p : personList) {
				PersonVO v = new PersonVO();
				v.setUsername(p.getUsername());
				v.setPassword(p.getPassword());
				resultList.add(v);
			}
		}
		return resultList;
	}

	// 登入
	@Transactional(readOnly = true)
	@Override
	public PersonResultVO checkLogin(PersonVO person) {
		PersonResultVO result = new PersonResultVO();
		result.setUsername(person.getUsername());
		Person existedPerson = personDao.findByUsernameAndPassword(person.getUsername(), person.getPassword());
		if (existedPerson != null && existedPerson.getState() == 1) {
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	// 註冊
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PersonResultVO register(Person person) {
		PersonResultVO result = new PersonResultVO();
		result.setUsername(person.getUsername());
		String code = CodeUtil.generateUniqueCode();
		Person existedPerson = personDao.findByUsernameAndPassword(person.getUsername(), person.getPassword());
		if (!person.getEmail().matches("^\\w+@(\\w+\\.)+\\w+$")) {
			result.setStatus(false);
			return result;
		}
		if (existedPerson == null) {
			Person p = new Person();
			p.setUsername(person.getUsername());
			p.setPassword(person.getPassword());
			p.setEmail(person.getEmail());
			p.setState(0);
			p.setCode(code);
			personDao.save(p);
			new Thread(new MailUtil(person.getEmail(), code)).start();
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	// 改密碼
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public PersonResultVO changePassword(PersonVO person) {
		PersonResultVO result = new PersonResultVO();
		result.setUsername(person.getUsername());
		Person existedPerson = personDao.findByUsername(person.getUsername());
		if (existedPerson != null) {
			existedPerson.setPassword(person.getPassword());
			personDao.save(existedPerson);
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	// 檢查名子
	public ResultSet checkUser1(String name) {
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps =conn.prepareStatement("select * from person where username=?");
            ps.setString(1, name); 
            ResultSet rs = ps.executeQuery();
            return rs;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	@Transactional(readOnly = true)
	@Override
	public boolean checkUser(String name) {
		if (checkUser1(name) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(readOnly = true)
	@Override
	public PersonResultVO checkName(PersonVO person) {
		PersonResultVO result = new PersonResultVO();
		result.setUsername(person.getUsername());
		Person existedPerson = personDao.findByUsernameAndEmail(person.getUsername(), person.getEmail());
		if (existedPerson != null) {
			new Thread(new MailUtil(person.getEmail(), existedPerson.getUsername())).start();
			result.setStatus(true);
			return result;
		} else {
			result.setStatus(false);
			return result;
		}
	}

	// 信箱驗證
	public int activeUser1(String code) {
		int num = 0;
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "update person set state=1 where code=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			num = pstmt.executeUpdate();
			DBUtil.close(conn, pstmt, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;

	}

	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public boolean activeUser(String code) {
		System.out.println(code);
		// if(personDao.activeUser(1, code)>0){
		if (activeUser1(code) > 0) {
			return true;
		} else {
			return false;
		}
	}

	/*---------------------------------------*/
	/*點*/
	public BackMessage setAllMapSpot() { //Spot更新資料-商店&郵局
		BackMessage msg=new BackMessage();
		List<Spot> SLists = new ArrayList();
		List<Postoffice> postoffices=postofficeDao.findAll();
		for(Postoffice p:postoffices) {
			Spot spot=new Spot();
			spot.setSid(p.getPostalCode());
			spot.setName(p.getName());
			spot.setType("郵局");
			spot.setLongitude(p.getLongitude());
			spot.setLatitude(p.getLatitude());
			SLists.add(spot);
		}
		
		List<Seven> sevens=sevenDao.findAll();
		for(Seven s:sevens) {
			Spot spot=new Spot();
			spot.setSid(s.getCid());
			spot.setName(s.getName());
			spot.setType("超商");
			spot.setLongitude(s.getLongitude());
			spot.setLatitude(s.getLatitude());
			SLists.add(spot);
		}		
		spotDao.saveAll(SLists);
		msg.setSuccess(true);
		return msg;
	}
	public BackMessage getAllMapSpot() { //取得地圖位置
		BackMessage msg=new BackMessage();
		
		List<Postoffice> postoffices=postofficeDao.findAll();
		List<Seven> sevens=sevenDao.findAll();
		MapModel MM=new MapModel(postoffices,sevens);
		
		msg.setData(MM);
		//測試
		msg.setSuccess(true);
		return msg;
	}
	public BackMessage getAllSpot() {  //地圖寶箱商店點資訊
		BackMessage msg=new BackMessage();
		List<Spot> Spots =spotDao.findAll();
		List<SpotModel> spotMs=new ArrayList();
		for(Spot S:Spots) {
			Integer l=0;
			Integer m=0;
			Integer s=0;
			List<ChestList> Clsit=chestListDao.findBySpotid(S.getSid());
			for(ChestList c:Clsit) {
				if(c.getChestsize()>=5) {
					l++;
				}
				else if(c.getChestsize()<=2) {
					s++;
				}
				else {
					m++;
				} 
			}	
			ChestScaleModel CSM =new ChestScaleModel(l,m,s);
			List<ShopList> Slsit=shopListDao.findByShopid(S.getSid());
			List<ItemModel> items=null;
			if (Slsit.size() != 0) {
				items=new ArrayList();
			}
			
			
			SpotModel spotM =new SpotModel(S.getSid(),S.getName(),S.getType(),S.getLongitude(),S.getLatitude(),CSM,items);
			spotMs.add(spotM);
		}
				msg.setData(spotMs);
				msg.setSuccess(true);
				return msg;
	}
	/*郵局*/

	/*寶物*/
	public BackMessage putChest() { //"郵局"設置寶箱
		BackMessage msg=new BackMessage();
		List<Spot> spots=spotDao.findByType("郵局");
		chestListDao.deleteAll();
		List<ChestList> chestLists=new ArrayList();
		for(Spot s:spots){

			for(ChestList c:ChestScaleVO.ScaleList(s.getSid())) {	
				chestLists.add(c);
			}
		}
		chestListDao.saveAll(chestLists);
		
		
		msg.setSuccess(true);
		return msg;
	}
	public BackMessage takeChest(takeModel takeM) { //完家拿取寶箱

		Integer uid= Integer.parseInt(takeM.getUid()); 
		Integer ctid= Integer.parseInt(takeM.getCtid()); 
		BackMessage msg=new BackMessage();
		Integer bagSize =bagDao.findByBid(uid).getSize();
		Integer NumOfHold=bagListDao.findByBid(uid).size();
		ChestList chestList=chestListDao.findByCtid(ctid);
		if(chestList == null) {
			msg.setError("寶箱已被拿取");
			return msg;
		}
		Integer chestSize=chestList.getChestsize();
		Integer chestLevel=chestList.getChestlevel();
		if((bagSize-NumOfHold)<chestSize) { //空間還足夠
			msg.setError("背包空間不足，無法拿取");
			return msg;
		}
		List<Item> ilist=itemDao.findByItemlevelGreaterThanEqual(chestLevel);


		for(int i=0;i<chestSize;i++) {
			ItemVO dI= cal.dropLvItem(ilist);
			BagList bagList=(BagList)PlayerChangeItem
					(uid,dI.getIid(),dI.getQuantity()).getData();
			bagListDao.save(bagList);
		}

		chestListDao.delete(chestList);
		PlayerUpdataTime(uid);
		User user=new User(uid.toString());
		msg=getPlayerInf(user);
		msg.setSuccess(true);
		return msg;
	}
	//商店
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public BackMessage putShop() {  //"郵局"設置商店
		BackMessage msg=new BackMessage();	
		List<Spot> spots=spotDao.findByType("郵局");
		shopListDao.deleteAll();
		List<ShopList> slist=new ArrayList<ShopList>();
		List<Item> ilist=itemDao.findAll();

		for(Spot p:spots){
			if(cal.Random(1, 10)<=10) {
				List<Integer> I=new ArrayList();//堆疊用
				for(Integer i=0;i<10;i++)
				{

					ItemVO item=cal.dropItem(ilist);
					if(item !=null) {
						if(I.contains(item.getIid())) //重複則刪除
						{
							continue;
						}
						ShopList s =new ShopList();
						s.setShopid(p.getSid());
						s.setIid(item.getIid());
						s.setQuantity(item.getQuantity()*10000);
						slist.add(s);
						
						I.add(item.getIid());
						
					}
					if(cal.Random(1, 10)<=5) {i+=99;}
				}				
			}
		}
		shopListDao.saveAll(slist);
		msg.setSuccess(true);
		return msg;
	}
	public BackMessage ShopChangeItem(String Shopid,Integer iid,Integer quantity) {//商店數量更動
		BackMessage msg=new BackMessage();
		ShopList shopListold=shopListDao.findByShopidAndIid(Shopid, iid);
		if(shopListold==null){
			msg.setError("系統錯誤");
			return msg;
		}
		if(-quantity>=shopListold.getQuantity()){
			msg.setError("商品已被買走 商店數量低於購買數量");
			return msg;
		}
		ShopList shopList=new ShopList();
		shopList.setShoplistid(shopListold.getShoplistid());
		shopList.setShopid(Shopid);
		
		shopList.setIid(iid);
		shopList.setQuantity(shopListold.getQuantity()+quantity);
		//shopListDao.save(shopList);
		msg.setData(shopList);
		msg.setSuccess(true);
		return msg;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public BackMessage Buy(BuyModel buyModel){ //商店購買物品
		Integer uid= Integer.parseInt(buyModel.getUid()); 
		Integer iid= Integer.parseInt(buyModel.getIid()); 
		Integer Q= Integer.parseInt(buyModel.getQuantity()); 
		BackMessage msg=new BackMessage();
		Gamelnformation player=gamelnformationDao.findByGiid(uid);
		Integer NumOfHold=bagListDao.findByBid(uid).size();
		Item item=itemDao.findByIid(iid);
		
		//商店扣除物品
		Integer price=item.getPayment()*Q;
		if(player.getMoney()<price) //錢不夠
		{
			msg.setError("玩家錢不夠");
			return msg;
		
		}
		msg=ShopChangeItem(player.getPosition(),iid,-Q);
		
		if(!msg.isSuccess()) {  //商店庫存不夠
			msg.setError("被買走了QQ");
			return msg;
		}
		ShopList s1=(ShopList)msg.getData();
		msg=PlayerChangeItem(uid,iid,Q);
		if(!msg.isSuccess()) {//玩家空間不夠
			msg.setError("背包空間已滿");
			return msg;
		}
		BagList b1=(BagList)msg.getData();
		player.setMoney(player.getMoney()-price);
					
		shopListDao.save(s1);
		bagListDao.save(b1);
		gamelnformationDao.save(player);
		
		if(msg.isSuccess()){
			User user=new User(uid.toString(),null,null,null);
			msg=getPlayerInf(user);
			msg.setSuccess(true);
		}
		
		return msg;
	}
	/*玩家*/
	public BackMessage getPlayerInf(User user){  //獲取玩家資訊
		System.out.println(user.getUid());
		Integer uid= Integer.parseInt(user.getUid());
		BackMessage msg=new BackMessage();
		Person person=personDao.findByPid(uid);
		Gamelnformation gamelnformation=gamelnformationDao.findByGiid(uid);

	
		Spot spot=null;
		List<ChestList> chestList=null;
		List<ShopList> shopList=null;
		if(gamelnformation != null) {
			spot=spotDao.findBySid(gamelnformation.getPosition()); //取得玩家地點資訊
			chestList=chestListDao.findBySpotid(gamelnformation.getPosition());//取得玩家地點寶箱清單
			shopList=shopListDao.findByShopid(gamelnformation.getPosition());//取得玩家地點商店清單
		}
		//取得商店清單
		Map<Item,Integer> shopitems=new HashMap();	
		for(ShopList sl:shopList){
			Item i=itemDao.findByIid(sl.getIid());
			shopitems.put(i,sl.getQuantity());
		}
		//取得玩家背包清單
		Bag bag =bagDao.findByBid(uid);
		List<BagList> bagLists=bagListDao.findByBid(uid);
		Map<Item,Integer> items=new HashMap();
		for(BagList p:bagLists){
			Item i=itemDao.findByIid(p.getIid());
			items.put(i, p.getQuantity());
		}
		//取得玩家所在地寶箱清單
		List<ChestListModel> CLMs=new ArrayList();
		Integer l=0;
		Integer m=0;
		Integer s=0;
		for(ChestList c:chestList) {
			if(c.getChestsize()>=5) {
				l++;
			}
			else if(c.getChestsize()<=2) {
				s++;
			}
			else {
				m++;
			}
			ChestListModel CLM=new ChestListModel(c.getCtid(),c.getSpotid(),c.getChestsize(),c.getChestlevel());
			CLMs.add(CLM);
		}
		ChestScaleModel CSM=new ChestScaleModel(CLMs,l,m,s);
		
		msg.setData(cal.getPlayerInf(uid,person, gamelnformation, bag, items,spot,CSM,shopitems));
		return msg;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public BackMessage PlayerChangeItem(Integer uid,Integer iid,Integer quantity){//(會檢查背包)
		
		BackMessage msg=new BackMessage();

		Bag bag=bagDao.findByBid(uid);
		if(bag == null)
		{
			msg.setError("未設置背包");
			return msg;
		}
		Integer NumOfHold=bagListDao.findByBid(uid).size();//持有數
		Integer	bagSize=bag.getSize(); //背包大小
		
		BagList bagListold=bagListDao.findByBidAndIid(uid,iid);
		BagList bagList=new BagList();
		if((bagListold != null)&&(bagSize>=NumOfHold)){
			bagList.setBaglistid(bagListold.getBaglistid());
			bagList.setBid(bagListold.getBid());
			bagList.setIid(bagListold.getIid());
			bagList.setQuantity(bagListold.getQuantity()+quantity);
			//bagListDao.save(bagList);
		}	
		else if((bagListold==null)&&(bagSize>NumOfHold)){
			bagList.setBid(uid);
			bagList.setIid(iid);
			bagList.setQuantity(quantity);
			//bagListDao.save(bagList);	
		}
		else {
			msg.setError("背包空間不足");
			return msg;
		}

		msg.setData(bagList);
		msg.setSuccess(true);
		return msg;
	}
	public BackMessage PlayerUpdataTime(Integer uid) {
		Gamelnformation g=gamelnformationDao.findByGiid(uid);
		java.util.Date DATE = new java.util.Date();
		g.setLogouttime(DATE);
		gamelnformationDao.save(g);
		return null;
	}
	

	public BackMessage test(){
		BackMessage msg=new BackMessage();
		User user=new User("2",null,null,null);
		//測試
		//getChest(10);
		//putChest();
		//takeChest(2);
		//msg=getAllSpot();
		//Gamelnformation p4=gamelnformationDao.findByGiid(4);
		//Gamelnformation p5=gamelnformationDao.findByGiid(5);
		//p4.setHp(15);
		//gamelnformationDao.save(p4);
		//Date a=p5.getLogouttime()-p4.getLogouttime();
		//msg.setData(a);

		msg=getPlayerInf(user);
		//takeModel tm=new takeModel("2","1000");
	
		//msg=takeChest(tm);
		//測試

		return msg;
		
		//cw type
	}
	
}
