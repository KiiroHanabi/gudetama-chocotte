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

public class ControleurServletVideo extends HttpServlet {
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
			if(action.equals("chercher")){
				model.setMotCle(request.getParameter("motCle"));
				List<Video> videos=metier.listVideoMC(model.getMotCle());
				model.setVideos(videos);
			}
			else if(action.equals("delete")){
				int id=Integer.parseInt(request.getParameter("ref"));
				metier.suppVideo(id);
				model.setVideos(metier.listVideo());
			}
			else if(action.equals("edit")) {
				int id=Integer.parseInt(request.getParameter("ref"));
				Video v = metier.getVideo(id);
				model.setVideo(v);
				model.setMode("edit");
				model.setVideos(metier.listVideo());
			}
			else if(action.equals("save")) {
				try {
					int id = Integer.parseInt(request.getParameter("idVideo"));
					model.getVideo().setIdVideo(id);
					model.getVideo().setTitreVideo(request.getParameter("titreVideo"));
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
					model.getVideo().setDateVideo(sdf.parse(request.getParameter("dateVideo")));
					model.getVideo().setUrlVideo(request.getParameter("urlVideo"));
					DateFormat formatter = new SimpleDateFormat("HH:mm");
					java.sql.Time timeValue = new java.sql.Time(formatter.parse(request.getParameter("dureeVideo")).getTime());
					model.getVideo().setDureeVideo(timeValue);
					model.getVideo().setIdTraduction(Integer.parseInt(request.getParameter("idTraduction")));
					model.getVideo().setPageJsp(request.getParameter("pageJsp"));
					model.setMode(request.getParameter("mode"));
					if(model.getMode().equals("ajout"))
						metier.addVideo(model.getVideo());
					else if(model.getMode().equals("edit"))
						metier.modifVideo(model.getVideo());
					model.setVideos(metier.listVideo());
				} catch(Exception e) {
					model.setErrors(e.getMessage());
				}
			}
		}
		request.getRequestDispatcher("vueVideos.jsp").forward(request,response);
	}
}
