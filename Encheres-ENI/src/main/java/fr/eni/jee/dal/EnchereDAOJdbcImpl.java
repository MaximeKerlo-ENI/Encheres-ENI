package fr.eni.jee.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.bo.Utilisateur;

public class EnchereDAOJdbcImpl {

	
	private final static String INSERT = "insert into Utilisateurs (pseudo, nom,prenom) values(?,?,?);";
	
	
	
	
	public void add(Utilisateur utilisateurs) throws SQLException {
		// On fait appel à la classe ConnectionProvider pour recupérer une connexion depuis notre pool
		Connection cnx = ConnectionProvider.getConnection();
		
		// 1 - on crée une "requête préparée" à partir de la connexion recupérée et de notre template de requête SQL ( attribut INSERT)
		PreparedStatement pStmt = cnx.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
		
		// 2 - je remplace les ? de ma requête par les varleurs correspondantes
		// je remplace le premier ? de ma requête par la note de mon objet Avis
		pStmt.setString(1, utilisateurs.getPseudo()); // ATTENTION, les paramètres commencent à l'index : 1
		// je remplace le deuxième ? de ma requête par la description de mon objet Avis
		pStmt.setString(2, utilisateurs.getNom());
		pStmt.setString(3, utilisateurs.getPrenom());
		// 3 - j'execute la requête SQL
		pStmt.executeUpdate(); // ici , il faut faire executeUpdate() et pas executeQuery() parce qu'on modifie des données
		
		// 4 -  je recupère l'id genéré et je met à jour l'objet Avis
		ResultSet rs = pStmt.getGeneratedKeys();
		if (rs.next()) { // si jamais il y a un resultat
			utilisateurs.setNoUtilisateur(rs.getInt(1)); //alors on utilise sa valeur pour mettre à jour l'id de l'avis
		}
	}

}

	
