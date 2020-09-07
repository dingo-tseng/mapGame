package com.game.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.spring.entity.ChestList;


@Repository
public interface ChestListDao extends JpaRepository<ChestList, Long> {
	
	List<ChestList> findBySpotidAndChestsize(String spotid, Integer chestsize);
	List<ChestList> findBySpotid(String spotid);
	ChestList findByCtid(Integer Ctid);
	

}
