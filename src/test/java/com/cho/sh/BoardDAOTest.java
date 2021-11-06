package com.cho.sh;

import java.util.List;

import org.junit.Test;

import com.cws.dao.BoardDAO;
import com.cws.dao.BoardDAOImpl;
import com.cws.domain.BoardVO;
import com.cws.domain.Criteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoardDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	@Test
	public void testListPage() throws Exception{
		
		
		Criteria cri = new Criteria();
		
		BoardDAO dao = new BoardDAOImpl();
		//List<BoardVO> list = dao.selectBoard(cri);
//		for(BoardVO boardVO: list) {
//			logger.info(boardVO.getboard_num() + ":" + boardVO.getTitle());
//		}
	}
}
