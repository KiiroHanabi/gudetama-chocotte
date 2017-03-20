package hibernate;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import org.hibernate.Session;

import metier.Video;

public class VideoManager {

		public static void main(String[] args) {
			VideoManager mgr = new VideoManager();
			
			if(args[0].equals("insert")) {
				Date d = new Date(0);
				Time t = new Time(0);
				mgr.createAndInsertVideo("titreVideo", d, "urlVideo", t, 0, "pageJsp");
			}
		}
		
		private void createAndInsertVideo(String titre, Date date, String url, Time duree, int idTrad, String page) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			Video v = new Video();
			v.setTitreVideo(titre);
			v.setDateVideo(date);
			v.setUrlVideo(url);
			v.setDureeVideo(duree);
			v.setIdTraduction(idTrad);
			v.setPageJsp(page);
			
			session.getTransaction().commit();
		}

	}

