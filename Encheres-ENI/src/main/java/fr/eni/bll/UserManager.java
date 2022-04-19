package fr.eni.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DAOUtilisateur;
import fr.eni.dal.DalException;

/**
 * Classe charger de gérer nos utilisateurs TODO : rajouter une couche DAO pour
 * stocker les utilisateurs dans une base de donnée
 */
public class UserManager {

	private DAOUtilisateur daoUtilisateur = DAOFactory.getDAOUtilisateur();
	
	public void insert(Utilisateur utilisateur) throws DalException {
		try {
			this.daoUtilisateur.insert(utilisateur);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	 public Utilisateur selectPseudoPwd(String pseudo, String password) throws DalException {
		 Utilisateur user = new Utilisateur();
	 
		 try {
			user = this.daoUtilisateur.selectPseudoPwd(pseudo, password);
		} catch (DalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return user;
	 }
}
