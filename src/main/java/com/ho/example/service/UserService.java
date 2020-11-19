package com.ho.example.service;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.ho.example.domain.User;




public interface UserService extends UserDetailsService{

	//유저읽기
	public User readUser(String username);
	      
	//유저생성
	public void createUser(User user);
	
	//권한 생성
	public void createAuthorities(User user);
	   
	//시큐리티 권한 얻기
	Collection<GrantedAuthority> getAuthorities(String username);
	
	//유저정보 가져오기
	public User userInfo(String username);

	//유저정보 수정하기
	public void updateUser(User user);

	//비밀번호 수정하기
	public void pwUpdate(User user);
	
	//회원 탈퇴하기
	public void userDelete(User user);

	
}
