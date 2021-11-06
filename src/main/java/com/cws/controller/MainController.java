package com.cws.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cws.domain.Criteria;
import com.cws.domain.PageMaker;
import com.cws.service.BoardService;

@Controller("mainController")
public class MainController {
	
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value="/main/main.do", method=RequestMethod.GET)	
	public ModelAndView mainPage(Criteria cri,HttpServletRequest request) throws Exception{
		
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		logger.info(cri.toString());
		mav.addObject("board_list", boardService.selectBoard(cri));	
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCount());
		
		
		mav.addObject("notice_list", boardService.allNoticeList());
		mav.addObject("pageMaker", pageMaker);
		return mav;
	}
	

}
