package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.IModifUtilisateur;
import metier.ModifUtilisateurImpl;
import metier.Utilisateur;

public class ControleurServlet extends HttpServlet {
	private IModifUtilisateur metier;
	
	public void init() throws ServletException {
		metier = new ModifUtilisateurImpl();
	}
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getRequestDispatcher("vueUtilisateur.jsp").forward(request,  response);
	}
	// doute sur le nom de la liste et utilisateursParMC -> 1:00:00 de la vidéo environ
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UtilisateurModel model = new UtilisateurModel();
		//request.setAttribute("model",model);
		model.setMotCle(request.getParameter("motCle"));
		List<Utilisateur> utilisateurs=metier.listUtilisateurMC(model.getMotCle());
		model.setUtilisateurs(utilisateurs);
		request.setAttribute("model",model);
		request.getRequestDispatcher("vueUtilisateur.jsp").forward(request, response);
		/*String action=request.getParameter("action");	
		if(action!=null){
			if(action.equals("chercher")){
				model.setMotCle(request.getParameter("motCle"));
				List<Utilisateur> utilisateurs=metier.listUtilisateurMC(model.getMotCle());
				model.setUtilisateurs(utilisateurs);
				
				//request.setAttribute("mod", model);
				//request.getRequestDispatcher("vueUtilisateur.jsp").forward(request, response);
			}
			// doute sur le nom de l'action.est-ce vraiment delete ?
			else if(action.equals("delete")){
				int id=request.getParameter("idUtilisateur");
				metier.suppUtilisateur(id);
				model.setUtilisateurs(metier.listUtilisateurs());
			}
		}
		request.getRequestDispatcher("VueUtilisateurs.jsp").forward(request,response);*/
	}
}
