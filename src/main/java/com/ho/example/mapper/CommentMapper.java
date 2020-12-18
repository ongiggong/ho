package com.ho.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ho.example.domain.Comment;

@Mapper
public interface CommentMapper {

	public List<Comment> getComments(int idx);

	public void commentPost(Comment comment);

	public void commentUp(Comment comment);

	
	

}
