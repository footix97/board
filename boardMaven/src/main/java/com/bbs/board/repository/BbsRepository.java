package com.bbs.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bbs.board.entity.BbsEntity;

public interface BbsRepository extends CrudRepository<BbsEntity, Integer> {
	List<BbsEntity> findAllByOrderBySeqDesc();
	
	@Query(nativeQuery = true, value="SELECT seq, title, user, detl from tb_bbs where limit :startPage, :ppc")
	List<BbsEntity> findPageData(@Param("startPage") int startPage, @Param("ppc") int ppc);
}
