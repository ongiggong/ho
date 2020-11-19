package com.ho.example.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ho.example.domain.Board;
import com.ho.example.domain.User;
import com.ho.example.domain.Pagination;
import com.ho.example.service.BoardService;
import com.ho.example.service.UserService;




@org.springframework.stereotype.Controller

public class Controller {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	


	@RequestMapping("/")
	public String home(Model model) {
		logger.debug("debug"); 
		logger.info("info"); 
		logger.error("error");
		
		return"/index";
	}

	@RequestMapping("/beforeSignUp") 
	public String beforeSignUp() {
		return "/signup";
	}
	
	@RequestMapping("/signup")
	public String signup(User user) {
		
	  if((user.getUsername()).equals("")) { 
		  return "/signupfail";  
	  }	else if((user.getPassword()).equals("")) {
		  return "/signupfail"; 
	  } else if((user.getuName()).equals("")) { 
	      return "/signupfail"; 
	  } else if((user.getuAge()).equals("")) { 
	  	  return "/signupfail";
	  } else if((user.getuEmail()).equals("")) {
	  	  return "/signupfail"; 
	  } else if((user.getuPhone1()).equals("")) { 
		  return "/signupfail"; 
	  } else if((user.getuPhone2()).equals("")) {
	  	  return "/signupfail"; 
	  } else if((user.getuPhone3()).equals("")) { 
	 	  return "/signupfail"; }
		 
		
		
	  //비밀번호 암호화
	  String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
	  
	  //유저 데이터 세팅
	  user.setPassword(encodedPassword);
	  user.setAccountNonExpired(true);
	  user.setEnabled(true);
	  user.setAccountNonLocked(true);
	  user.setCredentialsNonExpired(true);
	  user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_USER"));   
	  
	  
	  //유저 생성
	  userservice.createUser(user);
		
	  //유저 권한 생성
	  userservice.createAuthorities(user);
		
	  
	  return "/signupsuccess";
		 
	}
	

	@RequestMapping(value="/login")
	public String beforeLogin(Model model) {
		return "/login";
	}
	
	@RequestMapping(value="/loginfail")
	public String loginFail(Model model) {
		return "/loginfail";
	   }
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/admin")
	public String admin(Model model) {
		return "/admin";
	}
	   
	@Secured({"ROLE_USER"})
	@RequestMapping(value="user/info/{username}")
	public String userInfo(Model model, @PathVariable String username) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = authentication.getName();

		//유저 정보 가져오기
		if(userId.equals(username)) {
		User list = userservice.userInfo(username);
		model.addAttribute("list", list);
		} else
			return "/infofail";	
			
		
		return "/user_info";
	   }

	@RequestMapping(value="/update")
	public String updateInfo(User user) {
		 
		
		//유저 정보 업데이트
	    userservice.updateUser(user);
	   
	  
	    return "/infoupSuccess";
	}
	
	
	@RequestMapping(value="/changePw/{username}") 
	public String changePw(Model model, @PathVariable String username, Principal principal) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = authentication.getName();

		//세션 아이디와 비교 후 비밀번호 변경 페이지로 넘김
		if(userId.equals(username)) {
		User list = userservice.userInfo(username);
		model.addAttribute("list", list);
		} else
			return "/infofail";
		
	 
	 return "/changePw";
	  
	 }
	
	@RequestMapping(value="/board")
	public String board(Model model){
//	count = service.get
//	Pagination pagination = new Pagination(3, count);
	List<Board> list = boardservice.selectBoardList();
	model.addAttribute("list", list);
	return "/board";
	
	}

	

	
	 
	@RequestMapping(value="/pwUpdate")
	public String pwUpdate(User user) {
		
		//비밀번호 변경
		String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.getUsername();
		userservice.pwUpdate(user);
				
		return "/changepwSuccess";
	}
	 
	@RequestMapping(value="/userDelete")
	public String userDelete(User user) {
		
		userservice.userDelete(user);
		return "/userDelsuccess";
	
		
	}
	
	
	@RequestMapping(value="/denied")
	public String denied(Model model) {
		return "/denied";
	   }
	
	
}
