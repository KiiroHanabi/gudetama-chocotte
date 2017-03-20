package metier;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Video implements Serializable {
	private int idVideo;
	private String titreVideo;
	private Date dateVideo;
	private String urlVideo;
	private Time dureeVideo;
	private int idTraduction;
	private String pageJsp;

	public Video() {
		super();
	}
	
	public Video(int idVideo, String titreVideo, Date dateVideo, String urlVideo, Time dureeVideo, int idTraduction, String pageJsp) {
		super();
		this.idVideo = idVideo;
		this.titreVideo = titreVideo;
		this.dateVideo = dateVideo;
		this.urlVideo = urlVideo;
		this.dureeVideo = dureeVideo;
		this.idTraduction = idTraduction;
		this.pageJsp = pageJsp;
	}

	public int getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(int idVideo) {
		this.idVideo = idVideo;
	}

	public String getTitreVideo() {
		return titreVideo;
	}

	public void setTitreVideo(String titreVideo) {
		this.titreVideo = titreVideo;
	}

	public Date getDateVideo() {
		return dateVideo;
	}

	public void setDateVideo(Date dateVideo) {
		this.dateVideo = dateVideo;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public Time getDureeVideo() {
		return dureeVideo;
	}

	public void setDureeVideo(Time dureeVideo) {
		this.dureeVideo = dureeVideo;
	}

	public int getIdTraduction() {
		return idTraduction;
	}

	public void setIdTraduction(int idTraduction) {
		this.idTraduction = idTraduction;
	}
	
	public String getPageJsp() {
		return pageJsp;
	}

	public void setPageJsp(String pageJsp) {
		this.pageJsp = pageJsp;
	}


}
