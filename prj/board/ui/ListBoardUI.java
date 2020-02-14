package com.ssafy.prj.board.ui;

import com.ssafy.prj.board.dao.BoardDAO;
import com.ssafy.prj.board.vo.Board;
import com.ssafy.prj.util.List;
import com.ssafy.prj.util.PrintUtil;

public class ListBoardUI extends BaseUI {
	private BoardDAO dao;

	public ListBoardUI(BoardDAO dao) {
		// 생성자
		this.dao = dao;
	}

	public void service() {
		List list = dao.selectBoard();
		System.out.println("전체 게시글 : " + list.size() + "개");
		PrintUtil.print();
		for (int i = list.size() - 1; 0 <= i; i--) {
			Board board = (Board) list.get(i);
			System.out.printf("%d\t%s\t%s\t%d\n", board.getNo(), board.getTitle(), board.getWriter(),
					board.getViewCnt());
		}
		if (list.isEmpty()) {
			System.out.println("게시글이 존재하지 않습니다.");
		}
		PrintUtil.print();
	}
}
