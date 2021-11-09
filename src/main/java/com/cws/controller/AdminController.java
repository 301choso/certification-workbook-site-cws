package com.cws.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cws.domain.MemberVO;
import com.cws.domain.NoticeVO;
import com.cws.service.AdminService;

@Controller("adminController")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/adminMemberPage.do" )
	public ModelAndView goAdminPage(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		List<MemberVO> memberList= adminService.adminMemberList();
		mav.addObject("list",memberList);
		
		return mav;
	}
	
	@RequestMapping(value = "/adminNoticePage.do")
	public ModelAndView goNoticePage(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		String viewName = (String)request.getAttribute("viewName");
		mav.setViewName(viewName);
		
		List<NoticeVO> noticeList= adminService.adminNoticeList();
		mav.addObject("list",noticeList);
		
		return mav;
	}
	
	@RequestMapping(value = "/goAddNoticeForm.do")
	public ModelAndView goAddNoticeForm(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));
		
		return mav;
	}
	
	@RequestMapping(value = "/addNotice.do")
	public String addNotice(@RequestParam("notice_title") String notice_title,
							@RequestParam("notice_content") String notice_content,
							HttpServletRequest request) throws Exception { 
		
		Map<String,String> noticeMap = new HashMap<>();
		noticeMap.put("notice_title", notice_title);
		noticeMap.put("notice_content", notice_content.replaceAll("\r\n", "<br>"));
		
		adminService.addNotice(noticeMap);
		return "redirect:/admin/noticePage.do";
	}
	
	@RequestMapping(value = "/viewNotice.do")
	public ModelAndView viewNotice(int notice_num, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));
		
		mav.addObject("list",adminService.selectNoticeTitle(notice_num));
		return mav;
	}
	
	@RequestMapping(value = "/goEditNoticeForm.do")
	public ModelAndView goEditNoticeForm(int notice_num, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));
		mav.addObject("list",adminService.selectNoticeTitle(notice_num));
		return mav;
	}
	
	@RequestMapping(value = "/updateNotice.do")
	public String updateNotice(@RequestParam("notice_num") int notice_num,
							@RequestParam("notice_title") String notice_title,
							@RequestParam("notice_content") String notice_content,
							HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));
		
		Map<String,Object> noticeMap = new HashMap<>();
		noticeMap.put("notice_title", notice_title);
		noticeMap.put("notice_content", notice_content.replaceAll("\r\n", "<br>"));
		noticeMap.put("notice_num", notice_num);
		
		adminService.updateNotice(noticeMap);
		
		return "redirect:/admin/adminNoticePage.do";
	}
	
	@RequestMapping(value = "/deleteNotice.do")
	public String deleteNoitce(int notice_num) throws Exception {
		adminService.deleteNotice(notice_num);
		return "redirect:/admin/adminNoticePage.do";
	}
	
	@RequestMapping(value = "/goEditMemberForm.do")
	public ModelAndView goEditMemberForm(int member_num,HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));	
		mav.addObject("list", adminService.selectMemberNum(member_num));
		return mav;
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
		
		adminService.updateMember(memberMap);
		
		return "redirect:/admin/adminMemberPage.do";
	}
}
