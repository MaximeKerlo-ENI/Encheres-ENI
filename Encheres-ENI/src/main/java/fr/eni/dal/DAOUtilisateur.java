package fr.eni.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Utilisateur;

public interface DAOUtilisateur extends DAO<Utilisateur> {
	
	void insert(Utilisateur utilisateur) throws DalException;
	Utilisateur selectPseudoPwd(String pseudo, String password) throws DalException;
	HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws DalException;
	List<Utilisateur> selectAll() throws DalException;
	void updateCredit(int noUtilisateur, int newCredit) throws DalException;
	void delete(Utilisateur utilisateur) throws DalException;
	Utilisateur hydrateUtilisateur(ResultSet rs) throws DalException;
	boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws DalException;
	boolean checkForUniquePseudo(String pseudo) throws DalException;
	void update(Utilisateur utilisateur) throws DalException;
	void fillPreparedStatement(Utilisateur utilisateur, PreparedStatement stmt) throws SQLException;
	Utilisateur selectlesId(int no_utilisateur) throws DalException;
	Utilisateur selectById(int id) throws DalException;
}