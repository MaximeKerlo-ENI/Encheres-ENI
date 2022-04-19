package fr.eni.dal;


import java.util.List;


import fr.eni.bo.Retrait;

public interface DAORetrait {
	void insert(Retrait retrait) throws DalException ;
	void update(Retrait retrait) throws DalException;
	void delete(Retrait retrait) throws DalException;
	List<Retrait> selectAll() throws DalException;
	Retrait selectById(int noArticle) throws DalException ;
	
}
