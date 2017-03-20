package hibernate;

import org.hibernate.Session;

import metier.Traduction;


public class TraductionManager {

		public static void main(String[] args) {
			TraductionManager mgr = new TraductionManager();
			
			if(args[0].equals("insert")) {
				mgr.createAndInsertTraduction(0, "urlUtilisateur", 0, 0, 0);
			}
		}
		
		private void createAndInsertTraduction(int id, String url, int votepos, int voteneg, int totalvote) {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			Traduction t = new Traduction();
			t.setIdUtilisateur(id);
			t.setUrlTraduction(url);
			t.setVotePositif(votepos);
			t.setVoteNegatif(voteneg);
			t.setTotalVote(totalvote);;
			
			session.getTransaction().commit();
		}

	}

