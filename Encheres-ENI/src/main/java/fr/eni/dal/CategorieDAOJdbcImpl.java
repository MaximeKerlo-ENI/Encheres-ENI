package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Categorie;
import fr.eni.bo.Enchere;

public abstract class CategorieDAOJdbcImpl implements DAOCategorie {
	
	
	  public void insert(Categorie categorie) throws BusinessException {
	    	 Connection cnx = ConnectionProvider.getConnection();
	        try {
	            String INSERT = "INSERT INTO CATEGORIES (no_categorie,libelle) VALUES (?, ?)";
	            PreparedStatement stmt = cnx.prepareStatement(INSERT);
	            stmt.setInt(1, categorie.getNoCategorie());
	            stmt.setString(2, categorie.getLibelle());
	            stmt.executeUpdate();
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            BusinessException BusinessException = new BusinessException();
	            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
	            throw BusinessException;
	        }
	    }
	
	  public void select(Categorie categorie) throws BusinessException {
	    	 Connection cnx = ConnectionProvider.getConnection();
	        try {
	            String INSERT = "INSERT INTO CATEGORIES (no_categorie,libelle) VALUES (?, ?)";
	            PreparedStatement stmt = cnx.prepareStatement(INSERT);
	            stmt.setInt(1, categorie.getNoCategorie());
	            stmt.setString(2, categorie.getLibelle());
	            stmt.executeUpdate();
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            BusinessException BusinessException = new BusinessException();
	            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
	            throw BusinessException;
	        }
	    }
	  
	  
	  
	

}
