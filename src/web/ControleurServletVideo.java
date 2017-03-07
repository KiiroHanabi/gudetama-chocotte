package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.IModifUtilisateur;
import metier.IModifVideo;
import metier.ModifUtilisateurImpl;
import metier.ModifVideoImpl;
import metier.Utilisateur;
import metier.Video;

public class ControleurServletVideo extends HttpServlet {
	private IModifVideo videometier;
	
	public void init() throws ServletException {
		videometier = new ModifVideoImpl();
	}
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("vueVideos.jsp").forward(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		VideoModel videomodel = new VideoModel();
		videomodel.setMotCle(request.getParameter("motCle"));
		List<Video> videos=videometier.listVideoMC(videomodel.getMotCle());
		videomodel.setVideos(videos);
		request.setAttribute("videomodel",videomodel);
		request.getRequestDispatcher("vueVideos.jsp").forward(request, response);
	}
}