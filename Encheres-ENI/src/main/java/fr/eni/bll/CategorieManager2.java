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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public void update(Categorie categorie) throws DalException {
//	
//		this.daoRetrait.insert(categorie);
//	}

	void delete(Categorie categorie) throws DalException {
		try {
			this.daoCategorie.delete(categorie);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Categorie> selectAll() throws DalException {
		List<Categorie> listeCategorie = new ArrayList<>();
		try {
			listeCategorie = this.daoCategorie.selectAll();
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeCategorie;
	}
	

//	boolean selectLibelle(String libelleToCheck) throws  DalException;

//	boolean checkForUniqueCategorieLibelle(String libelleToCheck) throws  DalException;

//	Categorie selectById(int id) throws DalException;
	
	
	
}
