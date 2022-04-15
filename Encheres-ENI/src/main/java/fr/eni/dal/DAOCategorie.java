package fr.eni.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Categorie;

public interface DAOCategorie extends DAO<Categorie>{
	
	void insert(Categorie categorie) throws BusinessException, SQLException;
	boolean selectLibelle(String libelleToCheck) throws BusinessException, SQLException;
	List<Categorie> selectAll() throws BusinessException, SQLException;
	boolean checkForUniqueCategorieLibelle(String libelleToCheck) throws BusinessException, SQLException;
	void update(Categorie var) throws BusinessException, SQLException;
	void delete(Categorie categorie) throws BusinessException, SQLException;
	Categorie selectById(int id) throws BusinessException, SQLException;
    
    
}