package com.cws.service;

import java.util.List;
import java.util.Map;

import com.cws.domain.BoardVO;
import com.cws.domain.MypageVO;


public interface MyPageService {

	public void insertMypage(MypageVO mypageVO) throws Exception;

	public List<MypageVO> selectMypage() throws Exception;

	public void deleteMypage(int mypage_num) throws Exception;

	public boolean findMypageList(MypageVO mypageVO) throws Exception;

	public List<BoardVO> selectMyBoard(int member_num) throws Exception;
	
}
