package cn.dowalker.bean;

public class AddressItem {
	private Address address;
	private String username;
	private String phone;
	public AddressItem() {
		super();
	}
	public AddressItem(Address address, String username, String phone) {
		super();
		this.address = address;
		this.username = username;
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "AddressItem [address=" + address + ", username=" + username + ", phone=" + phone + "]";
	}
	
	

}
