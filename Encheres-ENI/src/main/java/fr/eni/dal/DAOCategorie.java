package fr.eni.dal;

public interface DAOCategorie extends DAO<Categorie> {
    boolean checkForUniqueCategorieLibelle(String libelleToCheck) throws DALException;
}