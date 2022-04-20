package fr.eni.bll;

import java.util.ArrayList;
import java.util.List;
import fr.eni.bo.ArticleVendu;
import fr.eni.dal.DAOArticleVendu;
import fr.eni.dal.DAOFactory;
import fr.eni.dal.DalException;

public class ArticleManager {

	private DAOArticleVendu daoArticle = DAOFactory.getDAOArticleVendu();

	public void insert(ArticleVendu article) throws DalException {
		try {
			this.daoArticle.insert(article);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public void update(ArticleVendu article) throws DalException {
		try {
			this.daoArticle.update(article);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public void delete(ArticleVendu article) throws DalException {
		try {
			this.daoArticle.delete(article);
		} catch (DalException e) {
			e.printStackTrace();
		}
	}

	public List<ArticleVendu> selectAll() throws DalException {
		List<ArticleVendu> listeArticle = new ArrayList<ArticleVendu>();
		try {
			listeArticle = this.daoArticle.selectAll();
		} catch (DalException e) {
			e.printStackTrace();
		}
		return listeArticle;
	}
}


