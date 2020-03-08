package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.java.ChangePasswordService;
import com.spring.java.MemberDao;
import com.spring.java.MemberInfoPrinter;
import com.spring.java.MemberListPrinter;
import com.spring.java.MemberPrinter;
import com.spring.java.MemberRegisterService;
import com.spring.java.VersionPrinter;

@Configuration //Spring 설정 Class
public class AppCtx {

	@Bean //한 개의 빈 객체 생성
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
	
	@Bean
	public ChangePasswordService changePwsSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMeberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
	@Bean //1) 생성자로 DI
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter(memberDao(), memberPrinter());
	}
	@Bean //2) Setter 메소드로 DI
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(memberPrinter());
		return infoPrinter;
	}
	@Bean 
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
