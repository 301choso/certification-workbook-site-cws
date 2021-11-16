package com.cws.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cws.domain.BoardVO;
import com.cws.domain.Criteria;
import com.cws.domain.MemberVO;
import com.cws.domain.NoticeVO;
import com.cws.domain.PageMaker;
import com.cws.service.BoardService;

@Controller("boardController")
@RequestMapping(value="/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardVO boardVO;
	
	ModelAndView mav=new ModelAndView();
	
	@RequestMapping(value="/goAddBoardForm.do", method = RequestMethod.GET)
	public ModelAndView goinputForm(HttpServletRequest request){	
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		return mav;
	}
	
	@RequestMapping(value="/qListBoard.do", method = RequestMethod.GET)
	public ModelAndView printListBoard(Criteria cri,HttpServletRequest request) throws Exception{				
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);
	
		mav.addObject("list", boardService.selectBoard(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCount()); 
			
		mav.addObject("pageMaker", pageMaker);
		mav.setViewName((String)request.getAttribute("viewName"));
		return mav;
	}
	
	@RequestMapping(value="/addBoard.do", method = RequestMethod.POST)
	public String addBoard(@RequestParam("board_title") String board_title,
							@RequestParam("board_content") String board_content,
							@RequestParam("board_answer") String board_answer,
							@RequestParam("board_category") String board_category,
							@RequestParam("member_num") int member_num,
							HttpServletRequest request) throws Exception{
		
		Map<String,Object> boardmap = new HashMap<String, Object>();
		
		System.out.println(board_title+""+board_content+""+board_answer+""+board_category+""+member_num);
		boardmap.put("board_title",board_title);
		boardmap.put("board_content",board_content.replaceAll("\r\n", "<br>"));
		boardmap.put("board_answer",board_answer.replaceAll("\r\n", "<br>"));
		boardmap.put("board_category",board_category);
		boardmap.put("member_num",member_num);
		boardService.insertBoard(boardmap);
		
		return "redirect:/board/qListBoard.do";
	}
	
	@RequestMapping(value="/viewBoard.do", method = RequestMethod.GET)
	public ModelAndView viewBoard(int board_num,HttpServletRequest request) throws Exception{	
		ModelAndView mav = new ModelAndView();		
		mav.setViewName((String)request.getAttribute("viewName"));
		mav.addObject("list", boardService.selectBoardTitle(board_num));
		
		return mav;
	}
		
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(int board_num,Model model) throws Exception{	
		 boardService.deleteBoard(board_num);
		return "redirect:/main/main.do";
	}
	
	@RequestMapping(value="/goEditBoardForm.do")
	public ModelAndView editBoardForm(int board_num,HttpServletRequest request, HttpServletResponse response) throws Exception{	
		ModelAndView mav = new ModelAndView();		
		mav.setViewName((String)request.getAttribute("viewName"));
		
		boardVO = boardService.selectBoardTitle(board_num);
		mav.addObject("list", boardVO);
		mav.addObject("board_content",boardVO.getBoard_content().replaceAll("<br>", "\r\n"));
		mav.addObject("board_answer",boardVO.getBoard_answer().replaceAll("<br>", "\r\n"));
		return mav;
	}
	
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@RequestParam("board_num") int board_num,
							@RequestParam("board_title") String board_title,
							@RequestParam("board_content") String board_content,
							@RequestParam("board_answer") String board_answer,
							@RequestParam("member_num") int member_num) throws Exception{

		Map<String,Object> boardmap = new HashMap<String, Object>();
		
		boardmap.put("board_title",board_title);
		boardmap.put("board_content",board_content.replaceAll("\r\n", "<br>"));
		boardmap.put("board_answer",board_answer.replaceAll("\r\n", "<br>"));
		boardmap.put("member_num",member_num);
		boardmap.put("board_num",board_num);
		
		boardService.updateBoard(boardmap);
		return "redirect:/main/main.do";
	}
	
	@RequestMapping(value = "/noticeList.do")
	public ModelAndView noticeList(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));		
		
		List<NoticeVO> noticeList = boardService.allNoticeList();
		mav.addObject("list", noticeList);
		return mav;
	}
	
	@RequestMapping(value = "/noticeView.do")
	public ModelAndView NoticeView(int notice_num,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));		
		
		mav.addObject("list", boardService.selectNoticeView(notice_num));
		return mav;
	}
}
