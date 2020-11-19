package com.ho.example.service;

import java.util.List;
import com.ho.example.domain.Board;


public interface BoardService {
	public List<Board> selectBoardList();

	public static BoardServiceImpl getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getContentsCount();
	


}
