package test.sample.model;

public class User {
	private String id;
	private String nickname;
	private String profile_image;
	
	public User(){
		super();
	}
	public User(String id, String nickname, String profile_image){
		super();
		this.id = id;
		this.nickname = nickname;
		this.profile_image = profile_image;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
}
