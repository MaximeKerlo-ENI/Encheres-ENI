package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.bo.Enchere;
import fr.eni.dal.DAOEnchere;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DalException;

public class EncheresManager {

	private DAOEnchere daoEnchere = DAOFactory.getDAOEnchere();

	public void insert(Enchere enchere) throws DalException {
		try {
			this.daoEnchere.insert(enchere);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public void update(Enchere enchere) throws DalException {

		try {
			this.daoEnchere.insert(enchere);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	void delete(Enchere enchere) throws DalException {
		try {
			this.daoEnchere.delete(enchere);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public List<Enchere> selectAll() throws DalException {
		List<Enchere> listeEncheres = new ArrayList<>();
		try {
			listeEncheres = this.daoEnchere.selectAll();
		} catch (DalException e) {
			e.printStackTrace();
		}
		return listeEncheres;
	}
}
