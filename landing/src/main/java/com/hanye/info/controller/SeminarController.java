package com.hanye.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanye.info.model.mongo.MongoSequence;
import com.hanye.info.service.SeminarService;
import com.hanye.info.vo.SeminarVo;

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
	
	@GetMapping("/add")
	public String add(Model model) {
		SeminarVo seminary = new SeminarVo();
		model.addAttribute("seminar", seminary);
		
		return "seminar/add";
	}
	
	@PostMapping("/addSubmit")
	public String addSubmit(@ModelAttribute SeminarVo seminarVo) {	
		seminarService.saveSeminar(seminarVo);
		return "redirect:/auth/seminar/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam Long seqNo, Model model) {
		model.addAttribute("seminar", seminarService.findSeminar(seqNo));
		return "seminar/edit";
	}
	
	@PostMapping("/editSubmit")
	public String editSubmit(@ModelAttribute SeminarVo seminarVo) {	
		seminarService.updateSeminar(seminarVo);
		return "redirect:/auth/seminar/list";
	}
	
	@PostMapping("/delSubmit")
	public String delSubmit(@RequestParam Long seqNo) {
		seminarService.deleteSeminar(seqNo);
		return "redirect:/auth/seminar/list";
	}
}
