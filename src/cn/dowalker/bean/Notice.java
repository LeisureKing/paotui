package cn.dowalker.bean;

import java.util.Date;

public class Notice {
	private String id;
	private String uid;
	private String description;
	private String image;
	private Date time;
	public Notice() {
		super();
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", uid=" + uid + ", description=" + description + ", image=" + image + ", time="
				+ time + "]";
	}

	public Notice(String id, String uid, String description, String image, Date time) {
		super();
		this.id = id;
		this.uid = uid;
		this.description = description;
		this.image = image;
		this.time = time;
	}
	
	
	
	
}
