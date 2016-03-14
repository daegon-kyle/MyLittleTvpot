package test.sample.model;

import java.util.Date;

public class Comment {
	private String id;
	private String clip_id;
	private String user_id;
	private String user_nickname;
	private String user_profile_image;
	private String content;
	private Date regDttm;
	private int availability;
	
	public Comment(){
		super();
	}
	public Comment(String clip_id, String user_id, String user_nickname, String user_profile_image, String content, Date regDttm) {
		super();
		this.clip_id = clip_id;
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_profile_image = user_profile_image;
		this.content = content;
		this.regDttm = regDttm;
	}
	public Comment(String id, String clip_id, String user_id, String user_nickname, String user_profile_image, String content, Date regDttm, int availability) {
		super();
		this.id = id;
		this.clip_id = clip_id;
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_profile_image = user_profile_image;
		this.content = content;
		this.regDttm = regDttm;
		this.availability = availability;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClip_id() {
		return clip_id;
	}
	public void setClip_id(String clip_id) {
		this.clip_id = clip_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_profile_image() {
		return user_profile_image;
	}
	public void setUser_profile_image(String user_profile_image) {
		this.user_profile_image = user_profile_image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDttm() {
		return regDttm;
	}
	public void setRegDttm(Date regDttm) {
		this.regDttm = regDttm;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
}
