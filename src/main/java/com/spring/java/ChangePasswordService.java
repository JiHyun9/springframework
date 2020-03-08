package com.spring.java;

public class ChangePasswordService {
	private MemberDao memberDao;
	
	//Injection
	public void setMeberDao(MemberDao memberDao) {
		this.memberDao=memberDao;
	}
	public void changePasswordService(String email, String oldPwd, String newPwd) {
		Member member=memberDao.selectByEmail(email);
		if(member==null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memberDao.update(member);
	}
}
