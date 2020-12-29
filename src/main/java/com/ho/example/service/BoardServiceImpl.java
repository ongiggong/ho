package com.ho.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ho.example.domain.Board;
import com.ho.example.domain.Pagination;
import com.ho.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardmapper;
	@Override
	public List<Board> selectBoardList(Pagination pageParam) {
		int pageNum = ((pageParam.getPage())-1)*3;
		return boardmapper.selectBoardList(pageNum);
	}
	
	@Override
   public int totalCount() {
		   return boardmapper.totalCount();
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