package com.ho.example.controller;

import java.io.PrintWriter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ho.example.domain.Board;
import com.ho.example.domain.Comment;
import com.ho.example.domain.User;
import com.ho.example.domain.Pagination;
import com.ho.example.domain.Search;
import com.ho.example.service.BoardService;
import com.ho.example.service.UserService;
import com.ho.example.service.CommentService;



@org.springframework.stereotype.Controller

public class Controller {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired UserService userservice;
	@Autowired BoardService boardservice;
	@Autowired CommentService commentservice;


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
	  user.setAuthorities(AuthorityUtils.createAuthorityList("ROLE_회원"));   
	  
	  
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
		List<User> list = userservice.selectUserList();
		int usercount = userservice.getUserCount();
		model.addAttribute("usercount", usercount);
		model.addAttribute("list", list);
		return "/admin";
	}
	
	
	@RequestMapping(value="/userDetail/{username}")
	public String userDetail(Model model, @PathVariable String username) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userId = authentication.getName();
		
		Collection<GrantedAuthority> user = userservice.getAuthorities(userId);
		
		if(user.toString().contains("ROLE_운영자")) {
		User list = userservice.userInfo(username);
		model.addAttribute("list", list);
		return "/userDetail";
		} else 
			return "/infofail";
		
	}                                         
	
	@RequestMapping(value="/setAuth")
	public String setAuth(User user) {
		user.setUsername(user.getUsername());
		user.setuAuth("ROLE_운영자");
		userservice.createAuthorities(user);
		return "redirect:/admin";
       
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
	
	@RequestMapping(value="/board/{page}/{type}/{keyword}", method=RequestMethod.GET)
	public String boardList(Model model, @PathVariable Optional<Integer> page, @PathVariable String keyword, @PathVariable String type) {
		
		logger.debug("page:"+page);
		/*
		 * int page = pageObj.isPresent() ? pageObj.get() : 1;
		 * 
		 * 
		 * pagination.setPage(page); search.setKeyword(keyword); search.setType(type);
		 * int totalCount = boardservice.totalCount(search); List<Board> list =
		 * boardservice.selectBoardList(pagination); Pagination pag = new
		 * Pagination(page, totalCount); model.addAttribute("list", list);
		 * model.addAttribute("pagination", pag);
		 */
		return "/board";
	
	}
	
	
	
	
	@RequestMapping(value="/board/write")
	public String write(Model model, User user) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user.setUsername(authentication.getName());
		model.addAttribute("session", user);
		
		return "/write";

	}
	
	@RequestMapping(value="/post", method = RequestMethod.POST)
	public String post(Board board) {

		boardservice.boardPost(board);
		return "redirect:/board";
		
	}
	
	@RequestMapping(value="/board/page{page}/content{idx}")
	public String boardContent(Model model, Board board, @PathVariable int page, @PathVariable int idx) {
		
		
		board = boardservice.getContent(idx);
		board.setIdx(idx);
		model.addAttribute("content", board);
		List<Comment> list = commentservice.getComments(idx);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		return "/board-content";
	
	}
	
	@RequestMapping(value="/comment/{ref}", method = RequestMethod.POST)
	public String comment(Board board, Comment comment, @PathVariable int ref) {
		
		commentservice.commentPost(comment);
		return "/comment-success";
	}
	
	@RequestMapping(value="/contentedit/{idx}")
	public String contentEdit(Model model, Board board, @PathVariable int idx) {
		
		
		board = boardservice.getContent(idx);
		board.setIdx(idx);
		model.addAttribute("content", board);
		return "/contentedit";
	}
	
	@RequestMapping(value="/contentUp", method = RequestMethod.POST)
	public String contentUp(Board board) {
		boardservice.contentUp(board);
		return "/conup-success";
	}
	
	@RequestMapping(value="/contentDel/{idx}")
	public String contentDel(Board board, @PathVariable int idx) {
		boardservice.contentDel(idx);
		return "/condel-success";
	}
	
	@RequestMapping(value="/aj-update-comment", method = RequestMethod.POST)
	public String commentUp(Model model, Comment comment) {
		
		commentservice.commentUp(comment);
		List<Comment> list = commentservice.getComments(comment.getC_ref());
		model.addAttribute("list", list);
		return "/commentDiv";
		
	}	
	
	@RequestMapping(value="/commentDel/{idx}")
	public String commentDel(@PathVariable int idx) {
		commentservice.commentDel(idx);
		return "/commentdel-success";
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
