package com.hanye.info.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.hanye.info.service.CopyWriterService;
import com.hanye.info.vo.CopyWriterVo;

@Controller
@RequestMapping("/auth/copywriter")
public class CopyWriterController {
	
	@Autowired
	private CopyWriterService copywriterService;
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("copywriterList", copywriterService.findAll());
		return "copywriter/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("copywriter", new CopyWriterVo(copywriterService.getMaxSeqNo(),""));
		return "copywriter/add";
	}
	
	@PostMapping("/addSubmit")
	public String addSubmit(@ModelAttribute CopyWriterVo copywriterVo) {	
		copywriterService.saveCopywriter(copywriterVo);
		return "redirect:/auth/copywriter/list";
	}
	
	@PostMapping("/delSubmit")
	public String delSubmit(@RequestParam Long seqNo) {
		copywriterService.deleteCopywriter(seqNo);
		return "redirect:/auth/copywriter/list";
	}
	
}
