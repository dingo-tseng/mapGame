package com.game.spring.vo;

import java.util.ArrayList;
import java.util.List;

import com.game.spring.entity.ChestList;
import com.game.spring.serive.impl.cal;

public class ChestScaleVO {
	private List<ChestList> chests;

	public ChestScaleVO() {}
	
	static public List<ChestList> ScaleList(String Spotid) {
		Integer scale; 
		Integer L;
		Integer M;
		Integer S;
		scale=cal.Random(1, 100);
		List<ChestList> chests=new ArrayList();
		if(scale>98) {
			L = cal.Random(0,1)>0?0:1;
			M = cal.Normal(4, 1)-1;
			S = cal.Normal(11, 3)-1;
		}
		else if(scale>90) {
			L=0;
			M = cal.Normal(2, 1)-1;
			S =cal.Normal(4, 1)-1;
			
		}
		else if(scale>70) {
			L=0;
			M=0;
			S =cal.Normal(2, 1)-1;
		}
		else {
			L=0;
			M=0;
			S=0;
		}
		for(int i=0;i<L;i++) {
			ChestList chest =new ChestList();
			chest.setChestlevel(RandomLevel());
			chest.setChestsize(5);
			chest.setSpotid(Spotid);
			chests.add(chest);
		}
		for(int i=0;i<M;i++) {
			ChestList chest =new ChestList();
			chest.setChestlevel(RandomLevel());
			chest.setChestsize(3);
			chest.setSpotid(Spotid);
			chests.add(chest);
		}
		for(int i=0;i<S;i++) {
			ChestList chest =new ChestList();
			chest.setChestlevel(RandomLevel());
			chest.setChestsize(2);
			chest.setSpotid(Spotid);
			chests.add(chest);
		}
			return chests;
	}

	static public Integer RandomLevel() {
		int x =cal.Random(1, 100);
		if(x>95) {
			return 3;
		}
		else if(x>70){
			return 2;
		}
		else {
			return 1;
		}
	}
	
	
	public List<ChestList> getChests() {
		return chests;
	}
	public void setChests(List<ChestList> chests) {
		this.chests = chests;
	}
	

	
	
	
	
}
