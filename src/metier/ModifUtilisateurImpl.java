package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModifUtilisateurImpl implements IModifUtilisateur {

	@Override
	public void modifUtilisateur(Utilisateur u) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE utilisateur SET login=?, email=?, mdp=?, statut=? WHERE idUtilisateur=?");
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getMdp());
			ps.setString(4, u.getStatut());
			ps.setInt(5, u.getId());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addUtilisateur(Utilisateur u) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO utilisateur VALUES (?,?,?,?,?)");
			ps.setInt(1, u.getId());
			ps.setString(2, u.getLogin());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getMdp());
			ps.setString(5, u.getStatut());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void suppUtilisateur(int id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM utilisateur WHERE idUtilisateur=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Utilisateur> listUtilisateur() {
		List<Utilisateur> util = new ArrayList<Utilisateur>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM utilisateur");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Utilisateur u = new Utilisateur();
				u.setId(rs.getInt("idUtilisateur"));
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setMdp(rs.getString("mdp"));
				u.setStatut(rs.getString("statut"));
				util.add(u);				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return util;
	}

	@Override
	public List<Utilisateur> listUtilisateurMC(String mc) {
		List<Utilisateur> util = new ArrayList<Utilisateur>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM utilisateur WHERE login LIKE ?");
			ps.setString(1,  "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Utilisateur u = new Utilisateur();
				u.setId(rs.getInt("idUtilisateur"));
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setMdp(rs.getString("mdp"));
				u.setStatut(rs.getString("statut"));
				util.add(u);				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return util;
	}

	@Override
	public Utilisateur getUtilisateur(int id) {
		Utilisateur u = null;
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM utilisateur WHERE idUtilisateur LIKE ?");
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				u = new Utilisateur();
				u.setId(rs.getInt("idUtilisateur"));
				u.setLogin(rs.getString("login"));
				u.setEmail(rs.getString("email"));
				u.setMdp(rs.getString("mdp"));
				u.setStatut(rs.getString("statut"));			
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(u == null) throw new RuntimeException("Utilisateur "+id+" introuvable"); 
		return u;
	}

}
