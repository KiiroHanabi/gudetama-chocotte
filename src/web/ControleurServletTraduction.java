package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.IModifTraduction;
import metier.ModifTraductionImpl;
import metier.Traduction;

public class ControleurServletTraduction extends HttpServlet {
	private IModifTraduction metier;
	
	public void init() throws ServletException {
		metier = new ModifTraductionImpl();
	}
	
	protected void doGet( HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request,  response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		TraductionModel model = new TraductionModel();
		request.setAttribute("model",model);
		/*model.setMotCle(request.getParameter("motCle"));
		List<Utilisateur> utilisateurs=metier.listUtilisateurMC(model.getMotCle());
		model.setUtilisateurs(utilisateurs);
		request.setAttribute("model",model);
		request.getRequestDispatcher("vueUtilisateur.jsp").forward(request, response);*/
		String action=request.getParameter("action");	
		if(action!=null){
			if(action.equals("chercher")){
				model.setMotCle(request.getParameter("motCle"));
				List<Traduction> traductions = metier.listTraductionMC(model.getMotCle());
				model.setTraductions(traductions);
				
				//request.setAttribute("mod", model);
				//request.getRequestDispatcher("vueUtilisateur.jsp").forward(request, response);
			}
			// doute sur le nom de l'action.est-ce vraiment delete ?
			else if(action.equals("delete")){
				int id=Integer.parseInt(request.getParameter("ref"));
				metier.suppTraduction(id);
				model.setTraductions(metier.listTraduction());
			}
			else if(action.equals("edit")) {
				int id=Integer.parseInt(request.getParameter("ref"));
				Traduction t = metier.getTraduction(id);
				model.setTraduction(t);
				model.setMode("edit");
				model.setTraductions(metier.listTraduction());
			}
			else if(action.equals("save")) {
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					model.getTraduction().setIdTraduction(id);
					model.getTraduction().setIdUtilisateur(Integer.parseInt(request.getParameter("idUtilisateur")));
					model.getTraduction().setUrlTraduction(request.getParameter("urlTraduction"));
					model.getTraduction().setVotePositif(Integer.parseInt(request.getParameter("votePositif")));
					model.getTraduction().setVoteNegatif(Integer.parseInt(request.getParameter("voteNegatif")));
					model.getTraduction().setTotalVote(Integer.parseInt(request.getParameter("totalVote")));
					model.setMode(request.getParameter("mode"));
					if(model.getMode().equals("ajout"))
						metier.addTraduction(model.getTraduction());
					else if(model.getMode().equals("edit"))
						metier.modifTraduction(model.getTraduction());
					model.setTraductions(metier.listTraduction());
				} catch(Exception e) {
					model.setErrors(e.getMessage());
				}
			}
		}
		request.getRequestDispatcher("vueTraductions.jsp").forward(request,response);
	} //1:37:40 2-JEE: Bases du Développement Web...
}
