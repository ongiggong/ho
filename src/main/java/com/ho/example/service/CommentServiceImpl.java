package com.ho.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ho.example.domain.Comment;
import com.ho.example.mapper.CommentMapper;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService {
	
	@Autowired CommentMapper commentmapper;
	@Override
	public List<Comment> getComments(int idx) {
		
		return commentmapper.getComments(idx);
	}
	
	@Override
	public void commentPost(Comment comment) {
		commentmapper.commentPost(comment);
	}
	
	@Override
	public void commentUp(Comment comment) {
		 commentmapper.commentUp(comment);
	}
	
	@Override
	public void commentDel(int idx) {
		commentmapper.commentDel(idx);
	}
	
	
	
}
