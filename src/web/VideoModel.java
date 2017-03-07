package web;

import java.util.ArrayList;
import java.util.List;

import metier.Utilisateur;
import metier.Video;

public class VideoModel {
	private String motCle;
	private List<Video> videos = new ArrayList<Video>();
	
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
	

}
