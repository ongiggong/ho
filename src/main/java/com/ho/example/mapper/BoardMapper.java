package com.ho.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ho.example.domain.Board;

@Mapper
public interface BoardMapper {
	//게시판
	public List<Board> selectBoardList(int pageNum);
	
	//총 게시글 수
	public int totalCount();

	// 게시글 올리기
	public void boardPost(Board board);

	// 게시글 가져오기
	public Board getContent(int idx);

	//게시글 수정하기
	public void contentUp(Board board);

	//게시글 삭제하기
	public void contentDel(int idx);

}
