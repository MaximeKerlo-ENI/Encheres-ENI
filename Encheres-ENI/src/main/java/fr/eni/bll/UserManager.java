package fr.eni.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DAOUtilisateur;

/**
 * Classe charger de gérer nos utilisateurs TODO : rajouter une couche DAO pour
 * stocker les utilisateurs dans une base de donnée
 */
public class UserManager {

	private DAOUtilisateur daoUtilisateur = DAOFactory.getDAOUtilisateur();
	
	public void insert(Utilisateur utilisateur) {
		try {
			this.daoUtilisateur.insert(utilisateur);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public Utilisateur selectPseudoPwd(String pseudo, String password) {
		 Utilisateur user = new Utilisateur();
	 
		 try {
			user = this.daoUtilisateur.selectPseudoPwd(pseudo, password);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	 }
}
