package fr.eni.dal;

import java.util.HashMap;

import fr.eni.bll.BusinessException;
import fr.eni.bo.Utilisateur;

public interface DAOUtilisateur  {
    boolean checkForUniquePseudoAndMail(String pseudo, String mail) throws BusinessException;
    boolean checkForUniquePseudo(String pseudo) throws BusinessException;
    boolean checkForUniqueMail(String mail) throws BusinessException;
    Utilisateur selectUtilisateurByPseudo(String pseudo) throws BusinessException;
    HashMap<Integer, String> selectUtilisateursWithCurrentAuction() throws BusinessException;
    void updateCredit(int noUtilisateur, int newCredit) throws BusinessException;
}