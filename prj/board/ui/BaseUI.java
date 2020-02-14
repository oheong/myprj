package com.ssafy.prj.board.ui;

import java.util.Scanner;

public class BaseUI {
	private Scanner sc = new Scanner(System.in);
	public void service() { }
	protected int getInt(String msg) {
		return Integer.parseInt(getString(msg));
	}
	protected String getString(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}
