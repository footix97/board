package com.bbs.board.dto;

public class BbsDto {
	int seq;
	String title;
	String user;
	String detl;
	String fileuuid;
	String filename;
	
	long maxCnt;
	long ppc = 3;
	long page;
	long startPage;
	
	
	
	public long getMaxCnt() {
		return maxCnt;
	}
	public void setMaxCnt(long maxCnt) {
		this.maxCnt = maxCnt;
	}
	public long getPpc() {
		return ppc;
	}
	public void setPpc(long ppc) {
		this.ppc = ppc;
	}
	public long getPage() {
		return page;
	}
	public void setPage(long page) {
		this.page = page;
	}
	public long getStartPage() {
		startPage = (this.page - 1) * this.ppc;
		return startPage;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDetl() {
		return detl;
	}
	public void setDetl(String detl) {
		this.detl = detl;
	}
	public String getFileuuid() {
		return fileuuid;
	}
	public void setFileuuid(String fileuuid) {
		this.fileuuid = fileuuid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
}

