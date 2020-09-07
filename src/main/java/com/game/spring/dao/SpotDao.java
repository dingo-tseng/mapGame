package com.game.spring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.spring.entity.Spot;

@Repository
public interface SpotDao extends JpaRepository<Spot, Long> {

	public Spot findBySid(String Sid);
	public List<Spot> findByType(String Type);
}
