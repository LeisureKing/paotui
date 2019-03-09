package cn.dowalker.bean;

public class OrderItem {
	private Order order;
	private String username;
	private String address;
	
	
	public String getAddress() {
		return address;
	}



	public OrderItem(Order order, String username, String address) {
		super();
		this.order = order;
		this.username = username;
		this.address = address;
	}



	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "OrderItem [order=" + order + ", username=" + username + "]";
	}
	
	
}
