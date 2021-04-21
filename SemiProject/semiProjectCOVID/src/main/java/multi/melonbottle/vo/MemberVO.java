package multi.melonbottle.vo;

import org.springframework.stereotype.Component;

@Component
public class MemberVO {
	private String id, password, name, phone, email, address, detailAddress;
	int lv;

	public MemberVO() {
	}

	public MemberVO(String id, String password, String name, String phone, String email, String address, String detailAddress, int lv) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.detailAddress = detailAddress;
		this.lv = lv;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ ", detailAddress=" + detailAddress + ", lv=" + lv + "]";
	}

}
