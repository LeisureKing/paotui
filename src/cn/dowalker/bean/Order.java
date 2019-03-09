package cn.dowalker.bean;

import java.util.Date;

public class Order {
	private String id;
	private String title;
	private String content;
	private Date expecttime;
	private Date time;
	private int state;
	private float price;
	private String launchid;
	private String reciveid;
	private String addressid;
	
	
	
	
	public Order(String id, String title, String content, Date expecttime, Date time, int state, float price,
			String launchid, String reciveid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.expecttime = expecttime;
		this.time = time;
		this.state = state;
		this.price = price;
		this.launchid = launchid;
		this.reciveid = reciveid;
	}
	public Order() {
	}
	
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getExpecttime() {
		return expecttime;
	}
	public void setExpecttime(Date expecttime) {
		this.expecttime = expecttime;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getLaunchid() {
		return launchid;
	}
	public void setLaunchid(String launchid) {
		this.launchid = launchid;
	}
	public String getReciveid() {
		return reciveid;
	}
	public void setReciveid(String reciveid) {
		this.reciveid = reciveid;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", title=" + title + ", content=" + content + ", expecttime=" + expecttime
				+ ", time=" + time + ", state=" + state + ", price=" + price + ", launchid=" + launchid + ", reciveid="
				+ reciveid + "]";
	}
	
	
	
	
	
}
