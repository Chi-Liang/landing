package com.hanye.info.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hanye.info.service.CopySessionService;
import com.hanye.info.service.CopyWriterService;
import com.hanye.info.vo.CopySessionVo;

@Controller
@RequestMapping("/auth/copysession")
public class CopySessionController {
	
	@Autowired
	private CopySessionService copySessionService;
	
	@Autowired
	private CopyWriterService copywriterService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("copysessionList", copySessionService.findAll());
		return "copysession/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("copyWriterList", copywriterService.findAll());
		model.addAttribute("copysession", new CopySessionVo());
		return "copysession/add";
	}
	
	@PostMapping("/addSubmit")
	public String addSubmit(@ModelAttribute CopySessionVo copySessionVo) {	
		copySessionService.saveCopySession(copySessionVo);
		return "redirect:/auth/copysession/list";
	}
	
	@PostMapping("/delSubmit")
	public String delSubmit(@RequestParam Long seqNo) {
		copySessionService.deleteCopySession(seqNo);
		return "redirect:/auth/copysession/list";
	}
	
}
