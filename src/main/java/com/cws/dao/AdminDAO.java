package com.cws.dao;

import java.util.List;
import java.util.Map;

import com.cws.domain.MemberVO;
import com.cws.domain.NoticeVO;

public interface AdminDAO {

	public List<MemberVO> adminMemberList() throws Exception;

	public List<NoticeVO> adminNoticeList() throws Exception;

	public void addNotice(Map<String, String> noticeMap) throws Exception;

	public void updateNotice(Map<String, Object> noticeMap) throws Exception;

	public NoticeVO selectNoticeTitle(int notice_num) throws Exception;

	public void deleteNotice(int notice_num) throws Exception;

	public MemberVO selectMemberNum(int member_num) throws Exception;

	public void updateMember(Map<String, Object> memberMap) throws Exception;

}
