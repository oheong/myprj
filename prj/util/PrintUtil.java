package com.ssafy.prj.util;

public class PrintUtil {
	public static void print() {
		print('-', 30);
	}

	public static void print(char ch, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
