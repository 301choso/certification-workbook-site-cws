package com.cws.service;

import java.util.List;
import java.util.Map;

import com.cws.domain.BoardVO;
import com.cws.domain.Criteria;
import com.cws.domain.NoticeVO;

public interface BoardService {
	
	public List<BoardVO> selectBoard(Criteria cri) throws Exception;

	public void insertBoard(Map<String, Object> boardmap) throws Exception;

	public BoardVO selectBoardTitle(int board_num) throws Exception;

	public void deleteBoard(int board_num) throws Exception;

	public void updateBoard(Map<String, Object> boardmap) throws Exception;

	public int listCount() throws Exception;

	public List<NoticeVO> allNoticeList() throws Exception;


}
