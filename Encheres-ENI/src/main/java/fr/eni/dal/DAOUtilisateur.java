package fr.eni.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Utilisateur;

public interface DAOUtilisateur  {
	void insert(Utilisateur utilisateur) throws BusinessException, SQLException;
	Utilisateur selectById(int id) throws BusinessException, SQLException;
	Utilisateur selectPseudoPwd(String pseudo, String password) throws BusinessException, SQLException;
	HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws BusinessException, SQLException;
	List<Utilisateur> selectAll() throws BusinessException, SQLException;
	void updateCredit(int noUtilisateur, int newCredit) throws BusinessException, SQLException;
	void delete(Utilisateur utilisateur) throws BusinessException, SQLException;
	Utilisateur hydrateUtilisateur(ResultSet rs) throws BusinessException, SQLException;
	void booleancheckForUniquePseudoAndMail(String pseudo, String mail) throws BusinessException, SQLException;
	boolean checkForUniquePseudo(String pseudo) throws BusinessException, SQLException;
	boolean checkForUniqueMail(String mail) throws BusinessException, SQLException;
	
	
}