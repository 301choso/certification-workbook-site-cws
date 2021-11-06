package com.cws.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cws.domain.MemberVO;
import com.cws.service.MemberService;

@Controller("memberController")
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private MemberVO memberVO;
	
	@RequestMapping(value = "/loginForm.do")
	public ModelAndView gologinForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));		
		return mav;
	}
	
	@RequestMapping(value = "/joinForm.do")
	public ModelAndView gojoinForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));		
		return mav;
	}
	
	@RequestMapping(value = "/login.do")
	public ModelAndView gologin(@RequestParam Map<String, String> loginMap,
								HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));	
		
		memberVO = memberService.loginCheck(loginMap);
		
		if(memberVO != null && memberVO.getMember_id() != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memberInfo", memberVO);
			
			if(memberVO.getMember_member_yn().equals("N")) {
				session.setAttribute("isLogOn",false);
				String message = "탈퇴한 회원입니다.";
				mav.addObject("message",message);
				mav.setViewName("/member/loginForm");
			} else {
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/main/main.do");
			}
			
		} else {
			String message = "아이디나 비밀번호가 틀립니다. 다시 로그인해주세요";
			mav.addObject("message",message);
			mav.setViewName("/member/loginForm");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/logOut.do")
	public String gologout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("memberInfo");
		session.removeAttribute("isLogOn");
		
		return "redirect:/main/main.do";
	}
	
	@RequestMapping(value = "/join.do")
	public ModelAndView gojoin(@RequestParam("member_id") String member_id,
								@RequestParam("member_pw") String member_pw,
								@RequestParam("member_email1") String member_email1,
								@RequestParam("member_email2") String member_email2,
								@RequestParam("member_email_yn") String member_email_yn,
								HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));		
		
		Map<String, String> joinMap = new HashMap<>();
		joinMap.put("member_id",member_id);
		joinMap.put("member_pw",member_pw);
		joinMap.put("member_email",member_email1+"@"+member_email2);
		joinMap.put("member_email_yn",member_email_yn);
		
		memberService.memberJoin(joinMap);
		
		return mav;
	}
	
	@RequestMapping(value = "/goEditMemberForm.do")
	public ModelAndView goEditMemberForm(int member_num,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));	
		mav.addObject("list", memberService.selectMemberNum(member_num));
		return mav;
	}
	
	@RequestMapping(value = "/idCheck.do")
	public ResponseEntity goIdCheck(@RequestParam("member_id") String member_id, HttpServletRequest request) throws Exception {
	ResponseEntity resEntity = null;
		int result =memberService.memberIdCheck(member_id);
		resEntity =new ResponseEntity<Integer>(result, HttpStatus.OK);
		
		return resEntity;
	}
	
	@RequestMapping(value = "/updateMember.do")
	public String updateMember(@RequestParam("member_num") int member_num,
								@RequestParam("member_id") String member_id,
								@RequestParam("member_pw") String member_pw,
								@RequestParam("member_email1") String member_email1,
								@RequestParam("member_email2") String member_email2,
								@RequestParam("member_email_yn") String member_email_yn,
								HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));		
		
		Map<String, Object> memberMap = new HashMap<>();
		memberMap.put("member_num",member_num);
		memberMap.put("member_id",member_id);
		memberMap.put("member_pw",member_pw);
		memberMap.put("member_email",member_email1+"@"+member_email2);
		memberMap.put("member_email_yn",member_email_yn);
		
		memberService.updateMember(memberMap);
		
		return "redirect:/main/main.do"; //마이페이지 메인으로 가기
	}
}
