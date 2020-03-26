
import java.util.ArrayList;
import java.util.Arrays;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AptSAXHandler extends DefaultHandler {
	private String money; // 거래금액
	private String builded_year; // 건축년도
	private String year; // 년
	private String dong; // 동네
	private String apt_name; // 아파트 이름
	private String month; // 월
	private String day; // 일
	private String size; // 면적
	private String ground_number; // 지번
	private String ground_code; // 지역코드
	private String floor; // 층
	private String temp;
	private ArrayList<APT> list;
	private APT apt;

	public AptSAXHandler() {
		list = new ArrayList<APT>();
	}

	public ArrayList<APT> getList() {
		return list;
	}

	public void setList(ArrayList<APT> list) {
		this.list = list;
	}

	public void startElement(String uri, String name, String qName, Attributes attr) {
		if (qName.equals("item")) { 
			apt = new APT();
			apt.setApt_name(apt_name);
		}
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		// System.out.println(start + "," + length);
		temp = String.valueOf(ch, start, length);
		// System.out.println(Arrays.toString(ch));
		// System.out.println(temp);
	}

	public void endElement(String namespaceURI, String name, String qName) {
		if (qName.equals("아파트")) // 아파트
			apt.setApt_name(temp);

		if (qName.equals("거래금액")) // 거래 금액
			apt.setMoney(temp);

		if (qName.equals("법정동")) // 동네
			apt.setDong(temp);

		if (qName.equals("건축년도"))
			apt.setBuilded_year(temp);

		if (qName.equals("년"))
			apt.setYear(temp);

		if (qName.equals("월"))
			apt.setMonth(temp);

		if (qName.equals("일"))
			apt.setDay(temp);

		if (qName.equals("전용면적"))
			apt.setSize(temp);

		if (qName.equals("지번"))
			apt.setGround_number(temp);

		if (qName.equals("지역코드"))
			apt.setGround_code(temp);

		if (qName.equals("층"))
			apt.setFloor(temp);

		if (qName.equals("item")) {
			list.add(apt);
			apt = null;
		}
	}
}
