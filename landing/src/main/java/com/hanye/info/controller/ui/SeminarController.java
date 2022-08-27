package com.hanye.info.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hanye.info.service.SeminarService;
import com.hanye.info.vo.SeminarInfoVo;

@Controller
@RequestMapping("/auth/seminar")
public class SeminarController {

	@Autowired
	private SeminarService seminarService;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam String groupName, @RequestParam String sessionPlace,
			@RequestParam String sessionTime) {
		SeminarInfoVo seminarInfoVo = seminarService.findAll(groupName,sessionPlace,sessionTime);
		model.addAttribute("seminarList", seminarInfoVo.getSeminarVoList());
		model.addAttribute("groupNameList", seminarInfoVo.getGroupNameList());
		model.addAttribute("sessionPlaceList", seminarInfoVo.getSessionPlaceList());
		model.addAttribute("sessionTimeList", seminarInfoVo.getSessionTimeList());
		model.addAttribute("seminarInfo", seminarInfoVo.getSeminarVo());
		return "seminar/list";
	}

}
