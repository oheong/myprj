/*
 * 1. 전체 조회
 * 2. 조회
 * 3. 등록
 * 
 */

package com.ssafy.prj.board;

import com.ssafy.prj.board.ui.BoardUI;

public class Test {
	//main을 실행하는 용도로 쓸 거임
	public static void main(String[] args) {
//		BoardUI ui = new BoardUI();
//		ui.service();
		
		new BoardUI().service(); // 게시판 프로그램 화면 호출
	}

}
