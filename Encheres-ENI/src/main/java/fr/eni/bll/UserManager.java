package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DAOUtilisateur;
import fr.eni.dal.DalException;

public class UserManager {

	private DAOUtilisateur daoUtilisateur = DAOFactory.getDAOUtilisateur();
	
	public void insert(Utilisateur utilisateur) throws DalException {
		try {
			this.daoUtilisateur.insert(utilisateur);
		} catch (DalException e) {
			e.printStackTrace();
		} 
	}
	
	public void update(Utilisateur utilisateur) throws DalException {
		try {
			this.daoUtilisateur.update(utilisateur);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Utilisateur utilisateur) throws DalException {
		try {
			this.daoUtilisateur.delete(utilisateur);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public List<Utilisateur> selectAll() throws DalException {
		List<Utilisateur> utilisateur = new ArrayList<Utilisateur>();
		try {
			utilisateur = this.daoUtilisateur.selectAll();
		} catch (DalException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}
	
	public Utilisateur selectPseudoPwd(String pseudo, String password) throws DalException {
		 Utilisateur user = new Utilisateur();
	 
		 try {
			user = this.daoUtilisateur.selectPseudoPwd(pseudo, password);
		} catch (DalException e) {
			e.printStackTrace();
		} 
		return user;
	 }
}
