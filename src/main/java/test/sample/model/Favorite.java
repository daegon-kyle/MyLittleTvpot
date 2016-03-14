package test.sample.model;

public class Favorite {
	private String id;
	private String user_id;
	private String clip_id;
	
	public Favorite(){
		super();
	}
	public Favorite(String user_id, String clip_id){
		super();
		this.user_id = user_id;
		this.clip_id = clip_id;
	}
	public Favorite(String id, String user_id, String clip_id){
		super();
		this.id = id;
		this.user_id = user_id;
		this.clip_id = clip_id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getClip_id() {
		return clip_id;
	}
	public void setClip_id(String clip_id) {
		this.clip_id = clip_id;
	}
}