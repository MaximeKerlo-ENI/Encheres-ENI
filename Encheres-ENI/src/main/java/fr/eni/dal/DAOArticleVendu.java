package fr.eni.dal;

import java.sql.PreparedStatement;

import java.util.List;


import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Categorie;


public interface DAOArticleVendu extends DAO<ArticleVendu> {
	void insert(ArticleVendu articleVendu) throws  DalException;
	List<ArticleVendu> parcategorie(Categorie categorie) throws  DalException;
	List<Integer> filterByEtat(String etat) throws DalException;
	void delete(ArticleVendu articleVendu) throws DalException;
	
	void fillPreparedStatement(ArticleVendu articleVendu, PreparedStatement stmt) throws DalException ;
	ArticleVendu selectById(int id) throws DalException ;
	List<ArticleVendu> selectAll() throws  DalException;
	void update(ArticleVendu var) throws  DalException;
}