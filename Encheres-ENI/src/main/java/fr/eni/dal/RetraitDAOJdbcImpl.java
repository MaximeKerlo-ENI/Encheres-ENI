package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Retrait;

public class RetraitDAOJdbcImpl implements DAO<Retrait>{


    public void insert(Retrait retrait) throws DalException {
    	
        try (Connection cnx = ConnectionProvider.getConnection()){
            String INSERT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(INSERT);
            stmt.setInt(1, retrait.getArticle().getNoArticle());
            stmt.setString(2, retrait.getRue());
            stmt.setString(3, retrait.getCode_postal());
            stmt.setString(4, retrait.getVille());
            stmt.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        	DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
            throw dalException;
        }
    }

   

    public void update(Retrait retrait) throws DalException  {
    	
        String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?";
        try (Connection cnx = ConnectionProvider.getConnection()){
            PreparedStatement stmt = cnx.prepareStatement(UPDATE_RETRAIT);
            stmt.setString(1, retrait.getRue());
            stmt.setString(2, retrait.getCode_postal());
            stmt.setString(3, retrait.getVille());
            stmt.setInt(4, retrait.getArticle().getNoArticle());
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        	DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_UPDATE);
            throw dalException;
        }
    }

    public void delete(Retrait retrait) throws DalException {
    	
        String DELETE = "DELETE FROM RETRAITS WHERE no_article = ? ";
        try (Connection cnx = ConnectionProvider.getConnection()){
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, retrait.getArticle().getNoArticle());
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        	DalException dalException = new DalException();
            dalException.addError(ErrorCodesDAL.ERROR_SQL_DELETE);
            throw dalException;
        }
    }

	@Override
	public List<Retrait> selectAll() throws DalException {
		// TODO Auto-generated method stub
		return null;
	}





	 public Retrait selectById(int noArticle) throws DalException {
	       
	        Retrait retrait = null;
	        String SELECT_BY_ID = "SELECT * FROM RETRAITS WHERE no_article = ?";
	        try (Connection cnx = ConnectionProvider.getConnection()){
	            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
	            stmt.setInt(1, noArticle);
	            stmt.execute();
	           
	        } catch (SQLException e) {
	          	e.printStackTrace();
	        	DalException dalException = new DalException();
	            dalException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
	            throw dalException;
	        }
	        return retrait;
	    }






  
  
    }

	
	
	

