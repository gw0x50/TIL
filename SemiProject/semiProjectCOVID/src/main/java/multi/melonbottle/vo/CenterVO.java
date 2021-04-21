package multi.melonbottle.vo;

import org.springframework.stereotype.Component;

@Component
public class CenterVO {
	String name, address, phone, weekdays, saturday, sunday;

	public CenterVO() {
	}

	public CenterVO(String name, String address, String phone, String weekdays, String saturday, String sunday) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.weekdays = weekdays;
		this.saturday = saturday;
		this.sunday = sunday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	@Override
	public String toString() {
		return "MapVO [name=" + name + ", address=" + address + ", phone=" + phone + ", weekdays=" + weekdays + ", saturday=" + saturday + ", sunday="
				+ sunday + "]";
	}

}
