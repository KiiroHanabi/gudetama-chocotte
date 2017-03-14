package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModifTraductionImpl implements IModifTraduction {

	@Override
	public void modifTraduction(Traduction t) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE traduction SET idUtilisateur=?, urlTraduction=?, votePositif=?, voteNegatif=?, totalVote=? WHERE idTraduction=?");
			ps.setInt(1, t.getIdUtilisateur());
			ps.setString(2, t.getUrlTraduction());
			ps.setInt(3, t.getVotePositif());
			ps.setInt(4, t.getVoteNegatif());
			ps.setInt(5, t.getTotalVote());
			ps.setInt(6, t.getIdTraduction());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addTraduction(Traduction t) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO traduction VALUES (?,?,?,?,?)");
			ps.setInt(1, t.getIdTraduction());
			ps.setInt(2, t.getIdUtilisateur());
			ps.setString(3, t.getUrlTraduction());
			ps.setInt(4, t.getVotePositif());
			ps.setInt(5, t.getVoteNegatif());
			ps.setInt(6, t.getTotalVote());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void suppTraduction(int idTraduction) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM video WHERE idTraduction=?");
			ps.setInt(1, idTraduction);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Traduction> listTraduction() {
		List<Traduction> trad = new ArrayList<Traduction>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM traduction");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Traduction t = new Traduction();
				t.setIdTraduction(rs.getInt("idTraduction"));
				t.setIdUtilisateur(rs.getInt("idUtilisateur"));
				t.setUrlTraduction(rs.getString("urlTraduction"));
				t.setVotePositif(rs.getInt("votePositif"));
				t.setVoteNegatif(rs.getInt("voteNegatif"));
				t.setTotalVote(rs.getInt("totalVote"));
				trad.add(t);				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trad;
	}

	@Override
	public List<Traduction> listTraductionMC(String mc) {
		List<Traduction> trad = new ArrayList<Traduction>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM traduction WHERE urlTraduction LIKE ?");
			ps.setString(1,  "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Traduction t = new Traduction();
				t.setIdTraduction(rs.getInt("idTraduction"));
				t.setIdUtilisateur(rs.getInt("idUtilisateur"));
				t.setUrlTraduction(rs.getString("urlTraduction"));
				t.setVotePositif(rs.getInt("votePositif"));
				t.setVoteNegatif(rs.getInt("voteNegatif"));
				t.setTotalVote(rs.getInt("totalVote"));
				trad.add(t);				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return trad;
	}

	@Override
	public Traduction getTraduction(int idTraduction) {
		Traduction t = null;
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM traduction WHERE idTraduction LIKE ?");
			ps.setInt(1,  idTraduction);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				t = new Traduction();
				t.setIdTraduction(rs.getInt("idTraductionr"));
				t.setIdUtilisateur(rs.getInt("idUtilisateur"));
				t.setUrlTraduction(rs.getString("urlTraduction"));
				t.setVotePositif(rs.getInt("votePositif"));
				t.setVoteNegatif(rs.getInt("voteNegatif"));
				t.setTotalVote(rs.getInt("totalVote"));			
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(t == null) throw new RuntimeException("Utilisateur "+idTraduction+" introuvable"); 
		return t;
	}

}
