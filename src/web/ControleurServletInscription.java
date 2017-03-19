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

public class ControleurServletInscription extends HttpServlet {
	private IModifUtilisateur metier;
		
	public void init() throws ServletException {
		metier = new ModifUtilisateurImpl();
	}
		
	protected void doGet( HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,  response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UtilisateurModel model = new UtilisateurModel();
		request.setAttribute("model",model);
		String action=request.getParameter("action");	
		if(action!=null){
			if(action.equals("appliquer")) {
				try {
					//int id = Integer.parseInt("");
					//model.getUtilisateur().setId(id);
					model.getUtilisateur().setLogin(request.getParameter("login"));
					model.getUtilisateur().setEmail(request.getParameter("email"));
					model.getUtilisateur().setMdp(request.getParameter("mdp"));
					model.getUtilisateur().setStatut("Membre");
					model.setMode(request.getParameter("mode"));
					metier.addUtilisateur(model.getUtilisateur());
					model.setUtilisateurs(metier.listUtilisateur());
				} catch(Exception e) {
					model.setErrors(e.getMessage());
				}
			}
		}
		request.getRequestDispatcher("inscription.jsp").forward(request,response);
	}
}

