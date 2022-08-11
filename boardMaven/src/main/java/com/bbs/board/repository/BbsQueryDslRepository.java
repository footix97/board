package com.bbs.board.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.board.entity.BbsEntity;
import com.bbs.board.entity.QBbsEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Transactional
@Repository
public class BbsQueryDslRepository {
    @PersistenceContext
    private EntityManager em;
    

    public List<BbsEntity> getList(int startPage, int ppc) {
    	BbsEntity bbsEntity = new BbsEntity();
    	em.persist(bbsEntity);
    	QBbsEntity qBbsEntity = new QBbsEntity("h");
    	
        JPAQueryFactory query = new JPAQueryFactory(em); //
        
        List<BbsEntity> list = query.selectFrom(qBbsEntity).fetch();

        return list;
    }  

}
