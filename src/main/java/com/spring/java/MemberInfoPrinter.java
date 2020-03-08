package com.spring.java;

public class MemberInfoPrinter {
	
	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void printMemberInfoPrinter(String email) {
		Member member=memDao.selectByEmail(email);
		if(member==null) {
			System.out.println("일치 데이터 없음");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	public void setPrinter(MemberPrinter printer) {
		this.printer=printer;
	}
	

}
