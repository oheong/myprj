package com.ssafy.prj.board.ui;

import com.ssafy.prj.board.dao.BoardDAO;
import com.ssafy.prj.board.vo.Board;

public class UpdateBoardUI extends BaseUI {
	private BoardDAO dao;

	public UpdateBoardUI(BoardDAO dao) {
		this.dao = dao;
	}

	public void service() {
		int no = getInt("수정할 번호 : ");
		String title = getString("제목 : ");
		//String writer = getString("작성자 : ");
		String content = getString("내용 : ");

		Board board = new Board();
		board.setNo(no);
		board.setTitle(title);
		//board.setWriter(writer);
		board.setContent(content);

		dao.updateBoard(board);
		System.out.println("게시글이 수정되었습니다.");
	}
}
