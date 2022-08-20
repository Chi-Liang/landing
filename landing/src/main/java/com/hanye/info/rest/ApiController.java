package com.hanye.info.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hanye.info.service.MailJobService;
import com.hanye.info.service.SeminarService;
import com.hanye.info.vo.ReturnVo;
import com.hanye.info.vo.SeminarVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@Api(value = "接口操作", tags = "接口操作")
public class ApiController {
	
	@Autowired
	private MailJobService mailJobService;
	
	@Autowired
	private SeminarService seminarService;
	
	@ApiOperation("寄信")
	@PostMapping("/sendmail")
	public ReturnVo SendMailStart() {
		return mailJobService.startMailJob();
	}
	
	@ApiOperation("研討會報名")
	@PostMapping("/seminar")
	public ReturnVo SeminarStart(@RequestBody SeminarVo seminarVo) {
		 seminarService.saveSeminar(seminarVo);
		 return new ReturnVo("success","");
	}
	
}
