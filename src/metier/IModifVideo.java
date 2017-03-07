package metier;

import java.util.List;

public interface IModifVideo {
	public void modifVideo(Video v);
	public void addVideo(Video v);
	public void suppVideo(int id);
	public List<Video> listVideo();
	public List<Video> listVideoMC(String mc);
	public Video getVideo(int id);

}