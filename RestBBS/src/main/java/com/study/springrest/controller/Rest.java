package com.study.springrest.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.springrest.domain.RestVO;
import com.study.springrest.service.RestService;

/**
 * Handles requests for the application home page.
 */
@RestController
@RequestMapping("/rest")
public class Rest {
	
	@Inject
	private RestService service;
	
	private static final Logger logger = LoggerFactory.getLogger(Rest.class);
	
	// /유닛/ 목록
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView list(Locale locale, Model model) {
		
		List<RestVO> rest_list = service.getList();
		
		model.addAttribute("list", rest_list);
		
		return new ModelAndView("/list");
		//ModelAndView aaa = new ModelAndView();
		//aaa.setViewName("list");
		//List<RestVO> rest_list = service.getList();
		//aaa.addObject("list",list);
		//return aaa;
	}
	
	// /유닛/new/ 글쓰기 페이지
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView write() {		
		return new ModelAndView("/write");
	}
	
	// /유닛/ method = post
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView insert(RestVO vo, Model model) {
		
		service.insert(vo);
		
		return new ModelAndView("redirect:/rest/");
	}
	
	// /유닛/번호 삭제
	@RequestMapping(value = "/{board_no}", method = RequestMethod.DELETE)
	public ModelAndView delete(@PathVariable("board_no") Integer board_no) {
		System.out.println("dddddd");
		service.delete(board_no);
		
		return new ModelAndView("redirect:/rest");
	}
	
	// /유닛/글번호 상세
	@RequestMapping(value = "/{board_no}", method = RequestMethod.GET)
	public ModelAndView read(@PathVariable("board_no") Integer board_no) {
		ModelAndView aaa = new ModelAndView();
		
		aaa.setViewName("read");
		RestVO vo = service.get(board_no);
		
		aaa.addObject("list",vo);
		System.out.println(aaa);
		
		return aaa;
		
		
//		RestVO vo = service.get(board_no);
//		
//		model.addAttribute("list", vo);
//		
//		return new ModelAndView("/read");
	}
	
	
}
