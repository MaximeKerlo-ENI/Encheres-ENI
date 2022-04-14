package fr.eni.dal;

public abstract class DAOFactory {
	
	public static DAOArticleVendu getDAOArticleVendu() {
		return new ArticleVenduDAOJdbcImpl();
	
	
	

}
