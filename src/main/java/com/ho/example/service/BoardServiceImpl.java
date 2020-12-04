package com.ho.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ho.example.domain.Board;
import com.ho.example.mapper.BoardMapper;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardmapper;
	@Override
	public List<Board> selectBoardList(int page) {
		int pageNum = (page-1)*3;
		return boardmapper.selectBoardList(pageNum);
	}
	

}
