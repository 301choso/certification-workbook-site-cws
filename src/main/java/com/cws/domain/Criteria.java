package com.cws.domain;

public class Criteria {
	
	private int page;	//?˜„?¬ ?˜?´ì§? ë²ˆí˜¸
	private int perPageNum;	//?•œ ?˜?´ì§??— ì¶œë ¥?•  ê°œìˆ˜
	private int rowStart;	//?‹œ?‘?˜?´ì§? ë²ˆí˜¸
	private int rowEnd;		//??˜?´ì§? ë²ˆí˜¸. ?‹œ?‘?˜?´ì§?ë²ˆí˜¸?—?„œ ëª‡ê°œ ë³´ì—¬ì¤„ì? ê²°ì •
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum) + 1;
		return rowStart;
	}
	
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart + ", rowEnd=" + rowEnd
				+ "]";
	}
}
