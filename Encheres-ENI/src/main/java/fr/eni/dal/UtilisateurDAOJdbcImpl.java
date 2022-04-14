package fr.eni.dal;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements DAOUtilisateur  {

    /**
     * Insert an instance into the DB and fill this instance with the id generated by mssql server
     * @param  utilisateur Utilisateur The instance to insert into the DB
     * @throws SQLException 
     * @throws DALException if the SQL INSERT request is wrong
     */
    public void insert(Utilisateur utilisateur) throws BusinessException, SQLException {
        Connection cnx = ConnectionProvider.getConnection();
        try {
            String INSERT = "INSERT INTO UTILISATEURS " +
                    "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pStmt = cnx.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
            pStmt.executeUpdate();
            ResultSet rs = pStmt.getGeneratedKeys();
            if (rs.next()) {
                utilisateur.setNoUtilisateur(rs.getInt(1));
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_INSERT);
            throw BusinessException;
        }
    }

    /**
     * Extract data from the DB by id
     * @param id int The id of the utilisateur to extract from the DB
     * @return utilisateur An instance of the utilisateur
     * @throws SQLException 
     * @throws DALException if the SQL SELECT request is wrong
     */
    public Utilisateur selectById(int id) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        Utilisateur utilisateur = null;
        try {
            String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_ID);
            stmt.setInt(1, id);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                utilisateur = hydrateUtilisateur(rs);
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw BusinessException;
        }
        return utilisateur;
    }
    /**
     * Extract data from the DB by pseudo (pseudo is unique value)
     * @param pseudo String The pseudo of the utilisateur to extract from the DB
     * @return utilisateur An instance of the utilisateur
     * @throws SQLException 
     * @throws DALException if the SQL SELECT request is wrong
     */
    public Utilisateur selectUtilisateurByPseudo(String pseudo) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        Utilisateur utilisateur = null;
        try {
            String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
            PreparedStatement stmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
            stmt.setString(1, pseudo);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            if (rs.next()) {
                utilisateur = hydrateUtilisateur(rs);
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw BusinessException;
        }
        return utilisateur;
    }

    /**
     * Extract all users that have currently an auction and returns only their names
     * Purpose of this query is to display the names of the sellers on homepage
     * @return An ArrayList, index are for no_article and values are Strings with pseudo
     * @throws SQLException 
     * @throws DALException if the SQL SELECT request is wrong
     */
    public HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        HashMap<Integer, String> pseudos = new HashMap<> ();
        try {
            String SELECT_USERS_WITH_CURRENT_AUCTIONS =
                    "SELECT AV.no_article, pseudo " +
                    "FROM UTILISATEURS " +
                    "INNER JOIN ARTICLES_VENDUS AV on UTILISATEURS.no_utilisateur = AV.no_utilisateur ";
            Statement stmt = cnx.createStatement();
            stmt.execute(SELECT_USERS_WITH_CURRENT_AUCTIONS);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                pseudos.put(rs.getInt("no_article"), rs.getString("pseudo"));
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw BusinessException;
        }
        return pseudos;
    }

    /**
     * Select all the utilisateurs from the DB
     * @return An ArrayList filled with instances of Utilisateur
     * @throws SQLException 
     */
    public List<Utilisateur> selectAll() throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            Statement stmt = cnx.createStatement();
            String SELECT_ALL = "SELECT * FROM UTILISATEURS";
            stmt.execute(SELECT_ALL);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                utilisateurs.add(hydrateUtilisateur(rs));
            }
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException dalException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_SELECT);
            throw e;
        }
        return utilisateurs;
    }
    /**
     * Update to the db from an instance of Utilisateur
     * @param utilisateur Utilisateur the instance filled with informations to update
     */
 

   
    public void updateCredit(int noUtilisateur, int newCredit) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        try {
            String UPDATE_CREDIT = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur = ?";
            PreparedStatement stmt = cnx.prepareStatement(UPDATE_CREDIT);
            stmt.setInt(1, newCredit);
            stmt.setInt(2, noUtilisateur);
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_UPDATE);
            throw BusinessException;
        }
    }

    /**
     * Delete from the db from an instance of Utilisateur
     * @param utilisateur Utilisateur the instance filled with the noUtilisateur to delete
     * @throws SQLException 
     */
    public void delete(Utilisateur utilisateur) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        try {
            String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?;" ;
            PreparedStatement stmt = cnx.prepareStatement(DELETE);
            stmt.setInt(1, utilisateur.getNoUtilisateur());
            stmt.setString(2, utilisateur.getPseudo());
            stmt.executeUpdate();
            cnx.close();
        } catch (SQLException e) {
            e.printStackTrace();
            BusinessException BusinessException = new BusinessException();
            BusinessException.addError(ErrorCodesDAL.ERROR_SQL_DELETE);
            throw BusinessException;
        }
    }

    

    public Utilisateur hydrateUtilisateur(ResultSet rs) throws BusinessException, SQLException {
        return new Utilisateur(
                rs.getInt("no_utilisateur"),
                rs.getString("pseudo"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("email"),
                rs.getString("telephone"),
                rs.getString("rue"),
                rs.getString("code_postal"),
                rs.getString("ville"),
                rs.getString("mot_de_passe"),
                rs.getInt("credit"),
                rs.getBoolean("administrateur")
        );
    }

  

  
    public boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        boolean isUnique = true;
        try {
            String CHECK_IF_PSEUDO_AND_MAIL_ALREADY_EXIST =
                    "SELECT * FROM UTILISATEURS " +
                    "WHERE pseudo LIKE ? OR email LIKE ?;";
            PreparedStatement stmt = cnx.prepareStatement(CHECK_IF_PSEUDO_AND_MAIL_ALREADY_EXIST);
            stmt.setString(1, pseudo);
            stmt.setString(2, pseudo);
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

    /**
     * Check in the Database is a pseudo and a mail adress all already takeen
     * @param pseudo String The mail
     * @return boolean true if the pseudo and the mail are free and false if not
     * @throws SQLException 
     * @throws DALException If the SQL request is wrong
     */
    public boolean checkForUniquePseudo(String pseudo) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        boolean isUnique = true;
        try {
            String CHECK_IF_PSEUDO_ALREADY_EXIST =
                    "SELECT * FROM UTILISATEURS " +
                            "WHERE pseudo LIKE ?;";
            PreparedStatement stmt = cnx.prepareStatement(CHECK_IF_PSEUDO_ALREADY_EXIST);
            stmt.setString(1, pseudo);
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

    /**
     * Check in the Database is a pseudo and a mail adress all already takeen
     * @param mail String The mail
     * @return boolean true if the pseudo and the mail are free and false if not
     * @throws SQLException 
     * @throws DALException If the SQL request is wrong
     */
    public boolean checkForUniqueMail(String mail) throws BusinessException, SQLException {
    	Connection cnx = ConnectionProvider.getConnection();
        boolean isUnique = true;
        try {
            String CHECK_IF_MAIL_ALREADY_EXIST =
                    "SELECT * FROM UTILISATEURS " +
                            "WHERE email LIKE ?;";
            PreparedStatement stmt = cnx.prepareStatement(CHECK_IF_MAIL_ALREADY_EXIST);
            stmt.setString(1, mail);
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
	public void booleancheckForUniquePseudoAndMail(String pseudo, String mail) throws BusinessException, SQLException {
		// TODO Auto-generated method stub
		
	}
}