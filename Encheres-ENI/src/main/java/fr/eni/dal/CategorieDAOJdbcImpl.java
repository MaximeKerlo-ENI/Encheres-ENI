package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Categorie;
import fr.eni.bo.Enchere;

public abstract class CategorieDAOJdbcImpl implements DAOCategorie {
	
	
	  public void insert(Categorie categorie) throws BusinessException, SQLException {
	    	 Connection cnx = ConnectionProvider.getConnection();
	        try {
	            String INSERT = "INSERT INTO CATEGORIES (categorie,libelle) VALUES (?, ?)";
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
	
	  public boolean selectLibelle(String libelleToCheck) throws BusinessException, SQLException {
		  Connection cnx = ConnectionProvider.getConnection();
	        boolean sql = true;
	        try {
	            String select = "SELECT * FROM CATEGORIES WHERE libelle LIKE ?";
	            PreparedStatement stmt = cnx.prepareStatement(select);
	            stmt.setString(1, libelleToCheck);
	            stmt.execute();
	            ResultSet rs = stmt.getResultSet();
	            if (rs.next()) {
	                sql = false;
	            }
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            BusinessException BusinessException = new BusinessException();
	            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
	            throw BusinessException;
	        }
	        return sql;
	    }

}
