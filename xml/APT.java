
public class APT {
	String money; // 거래금액 o
	String builded_year; // 건축년도
	String year; // 년
	String dong; // 동네 o
	String apt_name; // 아파트 이름 o
	String month; // 월
	String day; // 일
	String size; // 면적
	String ground_number; // 지번
	String ground_code; // 지역코드
	String floor; // 층

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getBuilded_year() {
		return builded_year;
	}

	public void setBuilded_year(String builded_year) {
		this.builded_year = builded_year;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getApt_name() {
		return apt_name;
	}

	public void setApt_name(String apt_name) {
		this.apt_name = apt_name;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getGround_number() {
		return ground_number;
	}

	public void setGround_number(String ground_number) {
		this.ground_number = ground_number;
	}

	public String getGround_code() {
		return ground_code;
	}

	public void setGround_code(String ground_code) {
		this.ground_code = ground_code;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "APT [ 아파트 이름 : " + getApt_name() + ", 법정동 : " + getDong() + ", 거래 금액 : " + getMoney() + "]";
	}
}
