package fr.eni.dal;

import fr.eni.bo.Utilisateur;



public interface DAOUtilisateur extends DAO<Utilisateur> {

	
	Utilisateur selectPseudoPwd(String pseudo, String password)throws DalException;
	void insert(Utilisateur utilisateur) throws DalException;
	void delete(Utilisateur utilisateur) throws DalException;
	void update(Utilisateur utilisateur) throws DalException;
	Utilisateur selectById(int id) throws DalException;
	
	
	
	
	
	
}