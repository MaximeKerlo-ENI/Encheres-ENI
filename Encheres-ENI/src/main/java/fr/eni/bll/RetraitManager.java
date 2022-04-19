package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.bo.Retrait;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DAORetrait;
import fr.eni.dal.DalException;

public class RetraitManager {

	private DAORetrait daoRetrait = (DAORetrait) DAOFactory.getDAORetrait();

//	public void insert(Retrait retrait) throws DalException {
//		try {
//			this.daoRetrait.insert(retrait);
//		} catch (DalException e) {
//			e.printStackTrace();
//		}
//	}

	public void update(Retrait retrait) throws DalException {
	
		try {
			this.daoRetrait.insert(retrait);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	void delete(Retrait retrait) throws DalException {
		try {
			this.daoRetrait.delete(retrait);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public List<Retrait> selectAll() throws DalException {
		List<Retrait> listeRetrait = new ArrayList<>();
		try {
			listeRetrait = this.daoRetrait.selectAll();
		} catch (DalException e) {
			e.printStackTrace();
		}
		return listeRetrait;
	}
}
