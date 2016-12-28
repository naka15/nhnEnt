package com.twoyears.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.twoyears.model.boardMainViewServiceInterface;
import com.twoyears.model.dto.boardMainViewDTO;

@Controller
public class boardMainController {

	@Autowired
	boardMainViewServiceInterface boardMservice;

	@RequestMapping("boardMain.do")
	public ModelAndView getNoticelist() {
		ModelAndView mv = new ModelAndView();
		List<boardMainViewDTO> boardMmainlist = boardMservice.selectByLastdate();
		mv.addObject("boardMmainlist", boardMmainlist);
		System.out.println(boardMmainlist);
		mv.setViewName("boardMain");
		return mv;
	}
}
