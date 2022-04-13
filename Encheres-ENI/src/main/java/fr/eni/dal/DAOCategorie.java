package fr.eni.dal;

import fr.eni.bll.BusinessException;

public interface DAOCategorie  {
    boolean checkForUniqueCategorieLibelle(String libelleToCheck) throws BusinessException;
}