package com.bbs.board.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bbs.board.entity.BbsEntity;
import com.bbs.board.service.BbsJpaService;

@Controller
public class BbsJpaController {
	@Autowired
	BbsJpaService bbsJpaService;

	@Value("${fileupload.path}")
	private String uploadpath;
	
	
	@GetMapping("/dsl/list")
	public ModelAndView getListDsl() {
		List<BbsEntity> list = bbsJpaService.getListDsl(1,3);
		return new ModelAndView("bbsListJpa", "list", list);
	}	
		
	
	@GetMapping("/jpa/list")
	public ModelAndView getList() {
		List<BbsEntity> list = bbsJpaService.getList();
		return new ModelAndView("bbsListJpa", "list", list);
	}
	
	@GetMapping("/jpa/detail/{seq}")
	public ModelAndView detail(@PathVariable("seq") int seq) {
		BbsEntity bbsEntity = bbsJpaService.getDetail(seq);
		return new ModelAndView("detailJpa", "info", bbsEntity);
	}
	@GetMapping("/jpa/add")
	public String add() throws Exception {
		return "add";
	}

	@PostMapping("/jpa/add")
	public String add(BbsEntity bbsEntity, @RequestParam("attach") MultipartFile attach) throws Exception {
		
		String uuid = UUID.randomUUID().toString(); 
		String filePath = uploadpath + "\\" + uuid;
		try(BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)))) {
			stream.write(attach.getBytes());
			bbsEntity.setFileuuid(uuid);
			bbsEntity.setFilename(attach.getOriginalFilename());
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
			
		bbsJpaService.add(bbsEntity);

		return "bbsListJpa";
	}

	@GetMapping("/jpa")
	public ModelAndView getList2() {
		List<BbsEntity> list = bbsJpaService.getList(1, 3);
		return new ModelAndView("bbsListJpa", "list", list);
	}


}
