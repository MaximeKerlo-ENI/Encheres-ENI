package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.bo.Categorie;
import fr.eni.dal.DAOCategorie;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DalException;


public class CategorieManager {

	private DAOCategorie daoCategorie = DAOFactory.getDAOCategorie();

	public void insert(Categorie categorie) throws DalException {
		try {
			this.daoCategorie.insert(categorie);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public void update(Categorie categorie) throws DalException {
		try {
			this.daoCategorie.update(categorie);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	void delete(Categorie categorie) throws DalException {
		try {
			this.daoCategorie.delete(categorie);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public List<Categorie> selectAll() throws DalException {
		List<Categorie> listeCategorie = new ArrayList<>();
		try {
			listeCategorie = this.daoCategorie.selectAll();
		} catch (DalException e) {
			e.printStackTrace();
		}
		return listeCategorie;
	}
}
