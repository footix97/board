package com.bbs.board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bbs.board.dto.BbsDto;
import com.bbs.board.service.BbsService;

@SpringBootTest
@AutoConfigureMockMvc
class BoardMavenApplicationTests {

	@Autowired
	BbsService bbsService;

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@Order(1)
	void testBoardList() {
		int seq = 12;
		BbsDto inDto = new BbsDto();
		inDto.setSeq(seq);
		
		BbsDto dto = bbsService.getDetail(inDto);
		
		assertEquals(seq, dto.getSeq());
	}
	
	@Test
	@Order(2)
	void testList() throws Exception {
		this.mockMvc.perform(get("/jpa/list")
				.contentType(MediaType.TEXT_HTML))
				.andExpect(status().isOk())
				.andDo(print());
	}


}
