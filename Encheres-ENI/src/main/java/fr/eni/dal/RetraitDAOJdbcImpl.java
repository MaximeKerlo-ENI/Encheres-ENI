package fr.eni.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Retrait;

public abstract class RetraitDAOJdbcImpl implements DAO<Retrait>{


    /**
     * Insert an instance into the DB and fill this instance with the id generated by mssql server
     * @param  retrait Retrait The instance to insert into the DB
     * @throws BusinessException if the SQL INSERT request is wrong
     * @throws SQLException 
     */
    public void insert(Retrait retrait) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        try {
            String INSERT = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = cnx.prepareStatement(INSERT);
            stmt.setInt(1, retrait.getArticle().getNoArticle());
            stmt.setString(2, retrait.getRue());
            stmt.setString(3, retrait.getCode_postal());
            stmt.setString(4, retrait.getVille());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
            throw e;
        }
    }
//   

    public List<Retrait> selectAll() throws BusinessException {
        return null;
    }

    public void update(Retrait retrait) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        String UPDATE_RETRAIT = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?";
        try {
            PreparedStatement stmt = cnx.prepareStatement(UPDATE_RETRAIT);
            stmt.setString(1, retrait.getRue());
            stmt.setString(2, retrait.getCode_postal());
            stmt.setString(3, retrait.getVille());
            stmt.setInt(4, retrait.getArticle().getNoArticle());
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_UPDATE);
            throw BusinessException;
        }
    }

    public void delete(Retrait retrait) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        String DELETE = "DELETE FROM RETRAITS WHERE no_article = ? ";
        try {
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, retrait.getArticle().getNoArticle());
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_DELETE);
            throw BusinessException;
        }
    }

    /**
     * Fill an instance from a ResultSet
     * @param rs the ResultSet
     * @return Retrait the instance
     * @throws SQLException if the ResultSet doesn't match the different fields
     */
  //  private Retrait hydrateRetrait(ResultSet rs) throws BusinessException {
       // return new Retrait(     		
               // rs.getString("rue"),
               // rs.getString("code_postal"),
              //  rs.getString("ville"),
               // rs.getInt("no_article")
        //)
    }

	
	
	

