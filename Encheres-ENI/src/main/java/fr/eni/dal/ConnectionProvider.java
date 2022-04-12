package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Classe dediée à la gestion de notre pool de connexion
 */
public class ConnectionProvider {
	// on va stocker une référence vers notre pool de connexion dans un attribut :
	// "datasource"
	private static DataSource datasource;

	// bloc static : bloc d'initialisation qui va être appelé UNE fois au chargement
	// de la classe
	// est pratique pour initialiser des variables "statiques"
	private static DataSource dataSource;

    // Au chargement de la classe, la DataSource est recherchée dans l'arbre JNDI
    static
    {
        Context context;
        try {
            context = new InitialContext();
            ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException("Impossible d'accéder à la base de données");
        }
    }
    
    /**
     * Cette méthode retourne une connexion opérationnelle issue du pool de connexion
     * vers la base de données. 
     * @return Connection
     * @throws SQLException If something went wrong with the context (not found, wrong values)
     */
    public static Connection getConnection() throws SQLException
    {
        return ConnectionProvider.dataSource.getConnection();
    }
}