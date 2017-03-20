package web;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

public class ControleurServletAccueil extends HttpServlet {
private IModifVideo metier;
	
	public void init() throws ServletException {
		metier = new ModifVideoImpl();
	}
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,  response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		VideoModel model = new VideoModel();
		request.setAttribute("model",model);
		String action=request.getParameter("action");	
		if(action!=null){
			if(action.equals("Rechercher")){
				model.setMotCle(request.getParameter("motCle"));
				List<Video> videos=metier.listVideoMC(model.getMotCle());
				model.setVideos(videos);
			}
			
		}
		request.getRequestDispatcher("accueil.jsp").forward(request,response);
	}
}
