package com.cws.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cws.dao.AdminDAO;
import com.cws.domain.MemberVO;
import com.cws.domain.NoticeVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO adminDAO;

	@Override
	public List<MemberVO> adminMemberList() throws Exception {
		return adminDAO.adminMemberList();
	}

	@Override
	public List<NoticeVO> adminNoticeList() throws Exception {
		return adminDAO.adminNoticeList();
	}

	@Override
	public void addNotice(Map<String, String> noticeMap) throws Exception {
		adminDAO.addNotice(noticeMap);
	}

	@Override
	public void updateNotice(Map<String, Object> noticeMap) throws Exception {
		adminDAO.updateNotice(noticeMap);
	}

	@Override
	public NoticeVO selectNoticeTitle(int notice_num) throws Exception {
		return adminDAO.selectNoticeTitle(notice_num);
	}

	@Override
	public void deleteNotice(int notice_num) throws Exception {
		adminDAO.deleteNotice(notice_num);
	}

	@Override
	public MemberVO selectMemberNum(int member_num) throws Exception {
		return adminDAO.selectMemberNum(member_num);
	}

	@Override
	public void updateMember(Map<String, Object> memberMap) throws Exception {
		adminDAO.updateMember(memberMap);
	}
}
