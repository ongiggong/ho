package com.ho.example.service;

import java.util.ArrayList;
import java.util.List;
import com.ho.example.domain.Board;
import com.ho.example.domain.User;


public interface BoardService {
	
	public List<Board> selectBoardList(int page);

	
		
}

