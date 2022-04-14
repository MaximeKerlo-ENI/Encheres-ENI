package fr.eni.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Categorie;
import fr.eni.bo.Enchere;


public class CategorieDAOJdbcImpl implements DAOCategorie  {
	
	
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

	  public List<Categorie> selectAll() throws BusinessException, SQLException {
		  Connection cnx = ConnectionProvider.getConnection();
	        List<Categorie> categories = new ArrayList<>();
	        try{
	        	String SELECT_ALL = "SELECT * FROM CATEGORIES";
	        	PreparedStatement stmt = cnx.prepareStatement(SELECT_ALL);
	            
	            stmt.execute(SELECT_ALL);
	            ResultSet rs = stmt.getResultSet();
	            while (rs.next()) {
	                categories.add(new Categorie(
	                        rs.getInt("no_categorie"),
	                        rs.getString("libelle")
	                ));
	            }
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            BusinessException BusinessException = new BusinessException();
	            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
	            throw BusinessException;
	        }
	        return categories;
	    }
	  
	  
	   public boolean checkForUniqueCategorieLibelle(String libelleToCheck) throws BusinessException, SQLException {
		   Connection cnx = ConnectionProvider.getConnection();
	        boolean isUnique = true;
	        try {
	            String CHECK_IF_LIBELLE_IS_UNIQUE = "SELECT * FROM CATEGORIES WHERE libelle LIKE ?";
	            PreparedStatement stmt = cnx.prepareStatement(CHECK_IF_LIBELLE_IS_UNIQUE);
	            stmt.setString(1, libelleToCheck);
	            stmt.execute();
	            ResultSet rs = stmt.getResultSet();
	            if (rs.next()) {
	                isUnique = false;
	            }
	            cnx.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            BusinessException BusinessException = new BusinessException();
	            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
	            throw BusinessException;
	        }
	        return isUnique;
	    }

	

	@Override
	public void update(Categorie var) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		
	}

	  @Override
	    public void delete(Categorie categorie) throws BusinessException, SQLException {

	    }

	@Override
	public Categorie selectById(int id) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	  
	  
	  
	  
	  
	  
}
