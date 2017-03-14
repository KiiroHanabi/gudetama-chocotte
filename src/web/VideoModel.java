package web;

import java.util.ArrayList;
import java.util.List;

import metier.Utilisateur;
import metier.Video;

public class VideoModel {
	private String motCle;
	private Video video = new Video();
	private List<Video> videos = new ArrayList<Video>();
	private String errors;
	private String mode = "ajout";
	
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	

}
