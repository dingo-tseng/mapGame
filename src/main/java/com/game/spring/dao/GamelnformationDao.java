package com.game.spring.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.game.spring.entity.Gamelnformation;
import com.game.spring.entity.Person;

@Repository
public interface GamelnformationDao extends JpaRepository<Gamelnformation, Long> {

	public Gamelnformation findByGiid(Integer Giid);
	
	//
    /*@Query(value = "select * from gamelnformation where id = ?1", nativeQuery=true)
    List<Gamelnformation> queryByIdTest(Long id);*/
	
	
	/*List<Gamelnformation> findAllByLogouttimeTimeBetween(
		      Date publicationTimeStart,
		      Date publicationTimeEnd);*/
	
}
