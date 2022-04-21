package fr.eni.dal;

import java.util.HashMap;
import java.util.List;

import fr.eni.bo.Utilisateur;



public interface DAOUtilisateur extends DAO<Utilisateur> {

	void insert(Utilisateur utilisateur) throws DalException;
	Utilisateur selectPseudoPwd(String pseudo, String password)throws DalException;
	HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws DalException;
	public List<Utilisateur> selectAll() throws DalException  ;
	void updateCredit(int noUtilisateur, int newCredit) throws DalException;
	void delete(Utilisateur utilisateur) throws DalException;
	void update(Utilisateur utilisateur) throws DalException;
	Utilisateur selectlesId(int no_utilisateur) throws DalException;
	Utilisateur selectById(int id) throws DalException;
	
	
	
	
	
	
}