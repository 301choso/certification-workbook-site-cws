package com.cws.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cws.domain.MemberVO;
import com.cws.domain.MypageVO;
import com.cws.service.MyPageService;

@Controller("mypageController")
@RequestMapping("/mypage")
public class MyPageController {
	
	@Autowired
	private MyPageService myPageService;
	
	@Autowired
	private MypageVO mypageVO;
	
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping("/myPageMain.do")
	public ModelAndView myPageMain(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		HttpSession session = request.getSession();
		memberVO=(MemberVO)session.getAttribute("memberInfo");
		int member_num = memberVO.getMember_num();
		mav.addObject("qlist", myPageService.selectMypage());
		mav.addObject("blist", myPageService.selectMyBoard(member_num));
		return mav;
	}

	@RequestMapping(value="/addMypage.do", method=RequestMethod.POST, produces="application/text; charset=utf-8")
	public @ResponseBody String addMypage(@RequestParam("board_num") int board_num,
							HttpServletRequest request,HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		memberVO=(MemberVO)session.getAttribute("memberInfo");
		int member_num = memberVO.getMember_num();
		
		mypageVO.setMember_num(member_num);
		mypageVO.setBoard_num(board_num);
		
		boolean isAlreadyExisted = myPageService.findMypageList(mypageVO);
		if(isAlreadyExisted) {
			return "already_existed";
		}else {
			myPageService.insertMypage(mypageVO);
			return "add_success";
		}
		
	}
	
	@RequestMapping(value="/deleteMypage")
	public String deleteMypage(@RequestParam("mypage_num") int mypage_num) throws Exception {		

		myPageService.deleteMypage(mypage_num);		
		
		return "redirect:/mypage/myPageMain.do";
	}
			
}
