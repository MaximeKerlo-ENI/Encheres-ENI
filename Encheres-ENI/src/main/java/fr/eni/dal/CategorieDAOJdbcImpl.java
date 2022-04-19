package fr.eni.dal;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.eni.bo.Categorie;



public class CategorieDAOJdbcImpl implements DAOCategorie  {
	
	
	  public void insert(Categorie categorie) throws DalException {
	    	 
	        try (Connection cnx = ConnectionProvider.getConnection()) {
	            String INSERT = "INSERT INTO CATEGORIES (categorie,libelle) VALUES (?, ?)";
	            PreparedStatement stmt = cnx.prepareStatement(INSERT);
	            stmt.setInt(1, categorie.getNoCategorie());
	            stmt.setString(2, categorie.getLibelle());
	            stmt.executeUpdate();
	            
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        	 DalException dalException = new DalException();
	             dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
	             throw dalException;
	        }
	    }
	
	  public Categorie selectById(int id) throws DalException {
	       
	        Categorie categorie = null;
	        try (Connection cnx = ConnectionProvider.getConnection()){
	            String SELECT_BY_ID = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";
	            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
	            stmt.setInt(1, id);
	            stmt.execute();
	            ResultSet rs = stmt.getResultSet();
	            if (rs.next()) {
	                categorie = new Categorie(
	                        rs.getInt("no_categorie"),
	                        rs.getString("libelle")
	                );
	            }
	            
	        } catch (SQLException e) {
	         	e.printStackTrace();
	        	 DalException dalException = new DalException();
	             dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
	             throw dalException;
	        }
	        return categorie;
	    }
	  
	  
	  public boolean selectLibelle(String libelleToCheck) throws DalException {
		  
	        boolean sql = true;
	        try (Connection cnx = ConnectionProvider.getConnection()){
	            String select = "SELECT * FROM CATEGORIES WHERE libelle LIKE ?";
	            PreparedStatement stmt = cnx.prepareStatement(select);
	            stmt.setString(1, libelleToCheck);
	            stmt.execute();
	            ResultSet rs = stmt.getResultSet();
	            if (rs.next()) {
	                sql = false;
	            }
	           
	        } catch (SQLException e) {
	        	e.printStackTrace();
	        	 DalException dalException = new DalException();
	             dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
	             throw dalException;
	        }
	        return sql;
	    }

	  public List<Categorie> selectAll() throws DalException {
	
	        List<Categorie> categories = new ArrayList<>();
	        try(Connection cnx = ConnectionProvider.getConnection()){
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
	           
	        } catch (SQLException e) {
	        	e.printStackTrace();
	       	 DalException dalException = new DalException();
             dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
             throw dalException;
	        }
	        return categories;
	    }
	  
	  
	   public boolean checkForUniqueCategorieLibelle(String libelleToCheck) throws DalException{
		  
	        boolean isUnique = true;
	        try(Connection cnx = ConnectionProvider.getConnection()) {
	            String CHECK_IF_LIBELLE_IS_UNIQUE = "SELECT * FROM CATEGORIES WHERE libelle LIKE ?";
	            PreparedStatement stmt = cnx.prepareStatement(CHECK_IF_LIBELLE_IS_UNIQUE);
	            stmt.setString(1, libelleToCheck);
	            stmt.execute();
	            ResultSet rs = stmt.getResultSet();
	            if (rs.next()) {
	                isUnique = false;
	            }
	            
	        } catch (SQLException e) {
	         	e.printStackTrace();
		       	 DalException dalException = new DalException();
	             dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
	             throw dalException;
	        }
	        return isUnique;
	    }

	

	@Override
	public void update(Categorie var) throws DalException {
		// TODO Auto-generated method stub
		
	}

	  @Override
	    public void delete(Categorie categorie) throws DalException {

	    }

	

	  
	  
	  
	  
	  
	  
}
