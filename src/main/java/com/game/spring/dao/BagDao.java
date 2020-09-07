package com.game.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.spring.entity.Bag;


@Repository
public interface BagDao extends JpaRepository<Bag, Long> {
	
	public Bag findByBid(Integer Bid);
	//public ??? findBy???(Integer ???);
	
	
}
