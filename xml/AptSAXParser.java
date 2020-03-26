package ssafy.hw200326;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class AptSAXParser {
	private List<APT> list;

	public AptSAXParser() {
		try {
			String path = AptSAXParser.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
			// System.out.println(path); // --> 절대 경로가 출력됨
			File file = new File(path + "AptDealHistory.xml");

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			AptSAXHandler handler = new AptSAXHandler();

			parser.parse(file, handler);

			list = handler.getList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void parse(String apt_name) {
		for (APT a : list) {
			if (a.getApt_name().contains(apt_name))
				System.out.println(a.toString());

		}
	}

	public static void main(String[] args) {
		// 아파트 이름 부분 입력시 정확한 아파트 명, 법정동, 거래 금액이 출력되도록
		Scanner sc = new Scanner(System.in);
		System.out.print("찾고싶은 아파트 이름의 단어를 입력하세요 : ");
		String aptname = sc.next();

		AptSAXParser parse = new AptSAXParser();
		parse.parse(aptname);
	}
}
