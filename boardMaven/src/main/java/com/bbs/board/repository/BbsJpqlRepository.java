package com.bbs.board.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bbs.board.entity.BbsEntity;

@Repository
public class BbsJpqlRepository {
    @PersistenceContext
    private EntityManager em;
    
    public List<BbsEntity> getList(int startPage, int ppc) {

        List<BbsEntity> list = em
                .createQuery("SELECT m FROM BbsEntity m ORDER BY m.seq DESC", BbsEntity.class)  //필드명을 하나하나 열거하면 에러발생
                .setFirstResult(startPage - 1)
                .setMaxResults(ppc)
                .getResultList();

        return list;
    }    
}


