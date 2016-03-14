package test.sample.model;

import java.util.Date;

public class Clip {
	private String id;
	private String vid;
	private String ownerName;
	private String thumbUrl;
	private String title;
	private int numOfLike;
	private int playTime;
	private int numOfPlay;
	private Date regDttm;
	
	public Clip(){
		super();
	}
	public Clip(String id, String vid, String ownerName, String thumbUrl, String title, int numOfLike, int playTime, int numOfPlay, Date regDttm){
		super();
		this.id = id;
		this.vid = vid;
		this.ownerName = ownerName;
		this.thumbUrl = thumbUrl;
		this.title = title;
		this.numOfLike = numOfLike;
		this.playTime = playTime;
		this.numOfPlay = numOfPlay;
		this.regDttm = regDttm;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumOfLike() {
		return numOfLike;
	}
	public void setNumOfLike(int numOfLike) {
		this.numOfLike = numOfLike;
	}
	public int getPlayTime() {
		return playTime;
	}
	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}
	public int getNumOfPlay() {
		return numOfPlay;
	}
	public void setNumOfPlay(int numOfPlay) {
		this.numOfPlay = numOfPlay;
	}
	public Date getRegDttm() {
		return regDttm;
	}
	public void setRegDttm(Date regDttm) {
		this.regDttm = regDttm;
	}
}
