package com.bbs.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.board.entity.BbsEntity;
import com.bbs.board.repository.BbsJpqlRepository;
import com.bbs.board.repository.BbsQueryDslRepository;
import com.bbs.board.repository.BbsRepository;

@Service
public class BbsJpaService {
	@Autowired
	BbsRepository bbsRepository;

	@Autowired
	BbsJpqlRepository bbsJpqlRepository;
	
	@Autowired
	BbsQueryDslRepository bBbsQueryDslRepository;

	public List<BbsEntity> getListDsl(int startPage, int ppc) {
		return bBbsQueryDslRepository.getList(startPage, ppc);
	}	
	
	
	public List<BbsEntity> getList() {
		return bbsRepository.findAllByOrderBySeqDesc();
	}
	
	public BbsEntity getDetail(int seq) {
		Optional<BbsEntity> bbsEntity = bbsRepository.findById(seq);
		if(!bbsEntity.isPresent()) {
			return new BbsEntity();
		}
		
		return bbsEntity.get();
	}
	
	public void add(BbsEntity bbsEntity) {
		bbsRepository.save(bbsEntity);
	}
	
	public List<BbsEntity> getList(int startPage, int ppc) {
		return bbsJpqlRepository.getList(startPage, ppc);
	}

}
