package com.ho.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import com.ho.example.domain.User;




@Mapper
public interface UserMapper {
	   //유저읽기
	   public User readUser(String username);
	   
	   //유저생성
	   public void createUser(User user);

	   //권한 읽기
	   public List<GrantedAuthority> readAuthorities(String username);

	   //권한 생성
	   public void createAuthority(User user);
	   
	   //유저정보 가져오기
	   public User userInfo(String username);
	   
	   //유저정보 수정하기
	   public void updateUser(User user);
	   
	   //비밀번호 수정하기
	   public void pwUpdate(User user);
	   
	   //회원 탈퇴하기
	   public void userDelete(User user);

	   //회원 목록 가져오기
	   public List<User> selectUserList();

	   //운영자 권한 부여하기
	   public User createAuthority(String user);
	   
	   //전체 회원 수 구하기
	   public int userCount();
	  
}
