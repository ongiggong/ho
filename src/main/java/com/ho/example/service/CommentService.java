package com.ho.example.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ho.example.domain.Board;
import com.ho.example.domain.User;
import com.ho.example.domain.Comment;


public interface CommentService {

	public List<Comment> getComments(int idx);

	
	public void commentPost(Comment comment);


	public void commentUp(Comment comment);


	

}
