package com.hanye.info.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hanye.info.service.MailJobService;
import com.hanye.info.service.SeminarService;
import com.hanye.info.vo.ReturnVo;
import com.hanye.info.vo.SeminarVo;


@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private MailJobService mailJobService;
	
	@Autowired
	private SeminarService seminarService;
	
	@PostMapping("/sendmail")
	public ReturnVo SendMailStart() {
		return mailJobService.startMailJob();
	}
	
	@PostMapping("/seminar")
	public ReturnVo SeminarStart(@RequestBody SeminarVo seminarVo) {
		 seminarService.saveSeminar(seminarVo);
		 return new ReturnVo("success","");
	}
	
}
