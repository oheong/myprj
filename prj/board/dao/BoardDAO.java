package com.ssafy.prj.board.dao;

//import java.util.Arrays;

import com.ssafy.prj.board.vo.Board;
import com.ssafy.prj.util.ArrayList;
import com.ssafy.prj.util.List;

public class BoardDAO {
	List list = new ArrayList();
	private int boardNo = 0;

	public List selectBoard() {
		return list;
	}

	public Board selectOneBoard(int no) {
		for (int i = 0; i < list.size(); i++) {
			Board board = (Board) list.get(i);
			if (board.getNo() == no)
				return board;
		}
		return null;
	}

	public void insertBoard(Board board) {

//		if (list.length == pos) {
//			// 용량이 꽉 찼음 - 증가시켜줘야함
//			list = Arrays.copyOf(list, pos * 2); // 한줄로 끝내벌임
//		}
		board.setNo(++boardNo);
//		list[pos++] = board;

		list.add(board);
	}

	public void deleteBoard(int no) { // 작동안함 ㅡㅡ
		// no-1번째 자리의 것을 빼야함
		// no번째부터 pos-1까지 해 줌

//		Board[] temp = new Board[pos - no];
//		System.arraycopy(list, no, temp, 0, pos - no);
//		System.arraycopy(temp, 0, list, no - 1, pos - no);
//		pos--;

		for (int i = 0; i < list.size(); i++) {
			Board board = (Board) list.get(i);
			if (board.getNo() == no) {
				list.remove(i);
				return;
			}
		}
	}

	public void updateBoard(Board board) {

//		int num = board.getNo();
//		num--;
//		list[num].setTitle(board.getTitle());
//		list[num].setContent(board.getContent());

		for (int i = 0; i < list.size(); i++) {
			Board b = (Board) list.get(i);
			if (b.getNo() == board.getNo()) {
				b.setTitle(board.getTitle());
				//b.setWriter(board.getWriter());
				b.setContent(board.getContent());
				return;
			}
		}
	}
}
