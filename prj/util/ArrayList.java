package com.ssafy.prj.util;

import java.util.Arrays;

import com.ssafy.prj.board.vo.Board;

public class ArrayList extends List {
	private Object[] list = new Object[2];
	private int pos = 0;

	// 데이터 꺼내기
	public Object get(int index) {
		return list[index];
	}

	// 데이터 추가
	public void add(Object obj) {
		add(pos, obj);
	}

	public void add(int index, Object obj) {
		if (list.length == pos + index) {
			list = Arrays.copyOf(list, pos * 2);
		}
		int moveCnt = pos - index;
		if (moveCnt > 0) {
			System.arraycopy(list, index, list, index + 1, moveCnt);
		}
		list[index] = obj;
		pos++;
	}

	public void clear() {
		for (int i = 0; i < pos; i++) {
			list[i] = null;
		}
		pos = 0;
	}

	// [...,...,...]
	public String toString() {
		if (pos == 0)
			return "[]";
		String result = "[" + list[0];
		for (int i = 1; i < pos; i++) {
			result += ", " + list[i];
		}
		result += "]";
		return String.format("[%s,%s,%s,%s,%s]");
	}

	// 크기
	public int size() {
		return pos;
	}

	// 데이터 삭제
	// equals 재정의 해서 처리
//	public Object /* void */ remove(int index) {// public void remove (Object obj)
//		Object prevObj = list[index];
//		int moveCnt = pos - (index + 1);
//		if (moveCnt > 0) {
//			System.arraycopy(list, index + 1, list, index, moveCnt);
//		}
//		list[--pos] = null;
//		return prevObj;
//	}

	// 데이터 존재 여부
	public boolean isEmpty() {
		return pos == 0; // 와 이거멍미
	}
}
