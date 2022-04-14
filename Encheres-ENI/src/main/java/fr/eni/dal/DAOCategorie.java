package fr.eni.dal;

import java.sql.SQLException;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Categorie;

public interface DAOCategorie  {
	void insert(Categorie categorie) throws BusinessException, SQLException;
	boolean selectLibelle(String libelleToCheck) throws BusinessException, SQLException;
    
    
    
}