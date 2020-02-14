package com.ssafy.prj.board.ui;

import com.ssafy.prj.board.dao.BoardDAO;
import com.ssafy.prj.board.vo.Board;
import com.ssafy.prj.util.PrintUtil;

public class DetailBoardUI extends BaseUI{
	private BoardDAO dao;

	public DetailBoardUI(BoardDAO dao) {
		this.dao = dao;
	}

	public void service() {
		int no = getInt("조회할 번호 : ");
		Board board = dao.selectOneBoard(no);
		if (board == null) {
			System.out.println(no + "번 게시글이 존재하지 않습니다.");
			return;
		}
		PrintUtil.print();
		System.out.println("번호 : " + no);
		System.out.println("제목 : " + board.getTitle());
		System.out.println("작성자 : " + board.getWriter());
		System.out.println("내용 : " + board.getContent());
		System.out.println("조회수 : " + board.getViewCnt());
		PrintUtil.print();
	}
}
