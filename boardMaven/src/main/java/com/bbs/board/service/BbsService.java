package com.bbs.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.board.dao.BbsDao;
import com.bbs.board.dto.BbsDto;

@Service
public class BbsService {
	@Autowired
	BbsDao bbsDao;
	public List<BbsDto> getList(long nPage) {
		BbsDto inDto = new BbsDto();
		inDto.setPage(nPage);
		
		return bbsDao.getList(inDto);
	}
	
	public int addDoc(BbsDto dto) {
		return bbsDao.addDoc(dto);
	}
	
	public List<BbsDto> getSearchList(BbsDto dto) {
		return bbsDao.getSearchList(dto);
	}
	
	public BbsDto getDetail(BbsDto dto) {
		return bbsDao.getDetail(dto);
	}
	
	public int revDoc(BbsDto dto) {
		return bbsDao.revDoc(dto);
	}
	
	public BbsDto getFileInfo(BbsDto dto) {
		return bbsDao.getFileInfo(dto);
	}
	
}
