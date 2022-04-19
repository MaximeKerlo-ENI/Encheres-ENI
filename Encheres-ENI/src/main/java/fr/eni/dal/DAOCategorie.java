package fr.eni.dal;


import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Categorie;

public interface DAOCategorie extends DAO<Categorie>{
	
	void insert(Categorie categorie) throws DalException;
	boolean selectLibelle(String libelleToCheck) throws  DalException;
	List<Categorie> selectAll() throws  DalException;
	boolean checkForUniqueCategorieLibelle(String libelleToCheck) throws  DalException;
	void update(Categorie var) throws  DalException;
	void delete(Categorie categorie) throws DalException;
	Categorie selectById(int id) throws DalException;
    
    
}