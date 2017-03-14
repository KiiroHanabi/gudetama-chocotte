package metier;

import java.util.List;

public interface IModifTraduction {
	public void modifTraduction(Traduction t);
	public void addTraduction(Traduction t);
	public void suppTraduction(int idTraduction);
	public List<Traduction> listTraduction();
	public List<Traduction> listTraductionMC(String mc);
	public Traduction getTraduction(int idTraduction);

}
