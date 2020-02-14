package com.ssafy.prj.board.ui;

import com.ssafy.prj.board.dao.BoardDAO;
import com.ssafy.prj.board.vo.Board;

public class WriteBoardUI extends BaseUI {
	private BoardDAO dao;

	public WriteBoardUI(BoardDAO dao) {
		this.dao = dao;
	}

	public void service() {
		Board board = new Board();
		board.setTitle(getString("제목 : "));
		board.setWriter(getString("작성자 : "));
		board.setContent(getString("내용 : "));

		dao.insertBoard(board);

		System.out.println("게시글이 등록되었습니다.");
	}
}
