package com.hanye.info.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.hanye.info.service.SeminarService;

@Controller
@RequestMapping("/auth/seminar")
public class SeminarController {
	
	@Autowired
	private SeminarService seminarService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("seminarList", seminarService.findAll());
		return "seminar/list";
	}

}
