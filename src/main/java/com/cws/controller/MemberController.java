package com.cws.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.HtmlEmail;
import org.apache.ibatis.io.Resources;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.spring31.properties.EncryptablePropertiesPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
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
				String message = "????????? ???????????????.";
				mav.addObject("message",message);
				mav.setViewName("/member/loginForm");
			} else {
				session.setAttribute("isLogOn", true);
				mav.setViewName("redirect:/main/main.do");
			}
			
		} else {
			String message = "???????????? ??????????????? ????????????. ?????? ?????????????????????";
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
		
		return "redirect:/main/main.do"; 
	}
	
	@RequestMapping(value = "/goLoginSearchForm.do")
	public ModelAndView goLoginSearchForm(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName((String)request.getAttribute("viewName"));	
		return mav;
	}
	
	@RequestMapping(value = "/loginSearch.do") //???????????? ??????????????? ???????????? ?????????, ?????????????????????
	public ModelAndView LoginSearch(@RequestParam("member_email1") String member_email1,
									@RequestParam("member_email2") String member_email2,
									HttpServletResponse response, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		response.setContentType("text/html; charset=utf-8");
		mav.setViewName((String)request.getAttribute("viewName"));	
		
		String member_email = member_email1 + "@" + member_email2;
		int email_yn = memberService.selectMemberEmail(member_email);	
		
		if(email_yn > 0) {
			String pw = "@";
			for(int i=0; i<10; i++) {
				pw += (char) ((Math.random() * 26) +97) ;
			}
			
			//update??? ??????
			sendEmail(pw, member_email, "findpw");
			String message = "??????????????? ???????????? ??????????????????. ??????????????????.";
			mav.addObject("message",message);
		}
		else{
			//???????????? ???????????? ????????????.
			String message = "???????????? ???????????? ????????????.";
			mav.addObject("message",message);
		}
			
		return mav;	
	}
	
	@Value("#{smtpIdPw['mail.hostSMTPid']}")
	private String hostSMTPid;
	
	@Value("#{smtpIdPw['mail.hostSMTPpw']}")
	private String hostSMTPpw;
	
	public void sendEmail(String pw, String member_email, String div) {
	
	    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();  
        encryptor.setAlgorithm("PBEWITHMD5ANDTRIPLEDES");  
        encryptor.setPassword("cwsPw");  
        String hostSMTPpwd = encryptor.decrypt(hostSMTPpw);

		System.out.println("hostSMTPid="+hostSMTPid);
		System.out.println("hostSMTPpw="+hostSMTPpwd);
		
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com";
		
		String fromEmail = "jsnn5279@naver.com";
		String fromName = "????????????";
		String subject = "";
		String msg = "";
	
		if(div.equals("findpw")) {
			
			subject = "???????????? ?????? ?????????????????????.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += "?????????????????? ?????????. ??????????????? ???????????? ???????????????.</h3>";
			msg += "<p>?????? ???????????? : ";
			msg += pw + "</p></div>";
		}
		
		String mail = member_email;
		try {
			HtmlEmail email = new HtmlEmail();
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(587);
			
			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail, charSet);
			email.setFrom(fromEmail, fromName, charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
			
		} catch (Exception e) {
			System.out.println("???????????? ?????? : " + e);
		}
		
		
	}
}
