package fr.eni.dal;


import java.util.List;
import fr.eni.bo.Enchere;


public interface DAOEnchere extends DAO<Enchere>  {
	void insert(Enchere enchere) throws DalException;
	Enchere selectById(int id) throws DalException;
	List<Enchere> selectAll() throws DalException;
	void update(Enchere enchere) throws  DalException;
	void delete(Enchere enchere) throws  DalException;
	
	
   
}