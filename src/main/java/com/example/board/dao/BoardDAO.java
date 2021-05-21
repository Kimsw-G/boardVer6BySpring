package com.example.board.dao;

import com.example.board.model.BoardVO;

import java.util.List;

public interface BoardDAO {

    List<BoardVO> selectBoardList(int pageKey);
    int getPageCnt();
}
