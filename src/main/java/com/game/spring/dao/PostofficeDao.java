package com.game.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.game.spring.entity.Postoffice;

public interface PostofficeDao extends JpaRepository<Postoffice, Long> {

	
	public Postoffice findByNameAndAddress(String Name, String Address);
	public List<Postoffice> findByName(String Name);
	public Postoffice findByPostalCode(String PostalCode);
	
	@Transactional
	@Modifying 
	@Query(value = "update Postoffice p set p.name=? where p.postalCode=? ", nativeQuery = true)  	 
	public void updateOne1(List<Postoffice> p);
}
