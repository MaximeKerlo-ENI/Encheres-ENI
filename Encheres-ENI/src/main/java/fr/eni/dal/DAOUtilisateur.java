package fr.eni.dal;

import fr.eni.bo.Utilisateur;



public interface DAOUtilisateur extends DAO<Utilisateur> {

	void insert(Utilisateur utilisateur) throws DalException;
	void delete(Utilisateur utilisateur) throws DalException;
	void update(Utilisateur utilisateur) throws DalException;
	Utilisateur selectById(int id) throws DalException;
	
	
}