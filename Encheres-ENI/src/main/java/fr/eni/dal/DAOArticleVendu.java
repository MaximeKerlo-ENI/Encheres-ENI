package fr.eni.dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;
import fr.eni.bo.Utilisateur;

public interface DAOArticleVendu extends DAO<ArticleVendu> {
	void insert(ArticleVendu articleVendu) throws BusinessException, SQLException;
	List<ArticleVendu> parcategorie(Categorie categorie) throws BusinessException, SQLException;
	List<Integer> filterByEtat(String etat) throws BusinessException, SQLException;
	void delete(ArticleVendu articleVendu) throws BusinessException, SQLException;
	void fillPreparedStatement(ArticleVendu articleVendu, PreparedStatement stmt) throws SQLException;
    
	ArticleVendu selectById(int id) throws BusinessException, SQLException ;
	List<ArticleVendu> selectAll() throws BusinessException, SQLException;
	void update(ArticleVendu var) throws BusinessException, SQLException;
}