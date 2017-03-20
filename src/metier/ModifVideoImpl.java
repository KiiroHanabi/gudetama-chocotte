package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class ModifVideoImpl implements IModifVideo {

	@Override
	public void modifVideo(Video v) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE video SET titreVideo=?, dateVideo=?, urlVideo=?, dureeVideo=?, idTraduction=? WHERE idVideo=?");
			ps.setString(1, v.getTitreVideo());
			ps.setDate(2, new Date(v.getDateVideo().getTime()));
			ps.setString(3, v.getUrlVideo());
			ps.setTime(4, v.getDureeVideo());
			ps.setInt(5, v.getIdTraduction());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addVideo(Video v) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO video VALUES (?,?,?,?,?)");
			ps.setInt(1, v.getIdVideo());
			ps.setString(1, v.getTitreVideo());
			ps.setDate(2, new Date(v.getDateVideo().getTime()));
			ps.setString(3, v.getUrlVideo());
			ps.setTime(4, v.getDureeVideo());
			ps.setInt(5, v.getIdTraduction());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void suppVideo(int id) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM video WHERE idVideo=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Video> listVideo() {
		List<Video> vid = new ArrayList<Video>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM video");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Video v = new Video();
				v.setIdVideo(rs.getInt("idVideo"));
				v.setTitreVideo(rs.getString("titreVideo"));
				v.setDateVideo(rs.getDate("dateVideo"));
				v.setUrlVideo(rs.getString("url"));
				v.setDureeVideo(rs.getTime("dureeVideo"));
				v.setIdTraduction(rs.getInt("idTraduction"));
				vid.add(v);				
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vid;
	}

	@Override
	public List<Video> listVideoMC(String mc) {
		List<Video> vid = new ArrayList<Video>();
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM video WHERE titreVideo LIKE ? OR idVideo LIKE ? OR dateVideo LIKE ? OR dureeVideo LIKE ?");
			ps.setString(1,  "%"+mc+"%");
			ps.setString(2, "%"+mc+"%");
			ps.setString(3, "%"+mc+"%");
			ps.setString(4, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Video v = new Video();
				v.setIdVideo(rs.getInt("idVideo"));
				v.setTitreVideo(rs.getString("titreVideo"));
				v.setDateVideo(rs.getDate("dateVideo"));
				v.setUrlVideo(rs.getString("urlVideo"));
				v.setDureeVideo(rs.getTime("dureeVideo"));
				v.setIdTraduction(rs.getInt("idTraduction"));
				vid.add(v);				
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vid;
	}

	@Override
	public Video getVideo(int id) {
		Video v = null;
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM video WHERE idVideo LIKE ?");
			ps.setInt(1,  id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				v = new Video();
				v.setIdVideo(rs.getInt("idVideo"));
				v.setTitreVideo(rs.getString("titreVideo"));
				v.setDateVideo(rs.getDate("dateVideo"));
				v.setUrlVideo(rs.getString("url"));
				v.setDureeVideo(rs.getTime("dureeVideo"));
				v.setIdTraduction(rs.getInt("idTraduction"));	
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(v == null) throw new RuntimeException("Video "+id+" introuvable"); 
		return v;
	}

}
