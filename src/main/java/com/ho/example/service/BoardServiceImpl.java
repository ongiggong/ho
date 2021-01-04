package com.ho.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ho.example.domain.Board;
import com.ho.example.domain.Pagination;
import com.ho.example.domain.Search;
import com.ho.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardmapper;
	@Override
	public List<Board> selectBoardList(Pagination pagination) {
		   return boardmapper.selectBoardList(pagination);
	}
	
	@Override
   public int totalCount(Search search) {
		   return boardmapper.totalCount(search);
	}
	
	@Override
	public void boardPost(Board board) {
		boardmapper.boardPost(board);
		
	}
	
	@Override
	public Board getContent(int idx) {
		return boardmapper.getContent(idx);
	}
	
	@Override
	public void contentUp(Board board) {
		boardmapper.contentUp(board);
	}
	
	@Override
	public void contentDel(int idx) {
		boardmapper.contentDel(idx);
	}
	
}