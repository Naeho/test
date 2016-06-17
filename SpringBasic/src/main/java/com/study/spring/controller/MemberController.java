package com.study.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.spring.domain.MemberVO;
import com.study.spring.service.MemberService;


@Controller
public class MemberController {
	
	@Inject
	private MemberService service;	
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member(Locale locale, Model model) {
			
		List<MemberVO> member_list = service.getList();
		
		model.addAttribute("list", member_list);
		
		return "member_list";
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String memberInsert(MemberVO vo, Model model) {
		
		service.insertMember(vo);
	
		return "redirect:/member";
	}
	
	@RequestMapping(value = "/memberWrite", method = RequestMethod.GET)
	public void memberWrite() {
			
	}
	
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(MemberVO vo, Model model) {
		
		service.update(vo);
	
		return "redirect:/member";
	}	
	
	@RequestMapping(value = "/memberUpdate/*", method = RequestMethod.GET)
	public void memberModify() {
		
		
	}
	
	@RequestMapping(value = "/memberDelete", method = RequestMethod.POST)
	public String memberDelete(@RequestParam("user_id") String user_id, Model model) {
		System.out.println(user_id);
		service.delete(user_id);
	
		return "redirect:/member";
	}

	
}
