package com.bbs.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bbs.board.dto.BbsDto;
import com.bbs.board.service.BbsService;

@RestController
public class BbsRestController {

	@Autowired
	BbsService bbsService;
	
	@PostMapping("/rest/searchList")
	public List<BbsDto> getSearchList(@RequestBody BbsDto dto) throws Exception {
		
		List<BbsDto> list = bbsService.getSearchList(dto);
		return list;
	}

	@GetMapping("/rest/detail/{seq}")
	public BbsDto getDetail(@PathVariable("seq") int seq) throws Exception {
		BbsDto inDto = new BbsDto();
		inDto.setSeq(seq);
		
		BbsDto dto = bbsService.getDetail(inDto);
		return dto;
	}

	@PutMapping("/rest/rev/{seq}")
	public int rev(@RequestBody BbsDto dto) throws Exception {
	
		int nCnt = bbsService.revDoc(dto);
		return nCnt;
	}	
	
}
