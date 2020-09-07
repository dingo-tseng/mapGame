package com.game.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.spring.entity.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {

	public Item findByIid(Integer Iid);
	public List<Item> findByItemlevelGreaterThanEqual(Integer Level);

}
