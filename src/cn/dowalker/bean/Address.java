package cn.dowalker.bean;

public class Address {
	private String id;
	private String uid;
	private String username;
	private String phone;
	private String address;
	
	public Address() {
		super();
	}
	
	public Address(String id, String uid, String phone, String address) {
		super();
		this.id = id;
		this.uid = uid;
		this.phone = phone;
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

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", uid=" + uid + ", address=" + address + "]";
	}
	
	
}
