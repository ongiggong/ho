package com.ho.example.service;

import java.util.ArrayList;
import java.util.List;
import com.ho.example.domain.Board;
import com.ho.example.domain.Pagination;
import com.ho.example.domain.User;


public interface BoardService {
	
	public List<Board> selectBoardList(Pagination pageParam);

	// 총 게시글 수 구하기
	public int totalCount();

	// 게시글 올리기
	public void boardPost(Board board);

	//게시글 가져오기
	public Board getContent(int idx);

	//게시글 수정하기
	public void contentUp(Board board);

	//게시글 삭제하기
	public void contentDel(int idx);

	

	

	



	

	

	
		
}

