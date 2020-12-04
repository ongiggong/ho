package com.ho.example.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ho.example.domain.Board;

@Mapper
public interface BoardMapper {
	//게시판
	public List<Board> selectBoardList(int pageNum);
	
}
