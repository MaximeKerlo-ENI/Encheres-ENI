package fr.eni.bo;

import java.time.LocalDate;

public class Enchere {
	private LocalDate dateEnchère;
	private int montant_enchere;
	private Utilisateur no_utilisateur;
	private ArticleVendu no_article;
	public Enchere(LocalDate dateEnchère, int montant_enchere, Utilisateur no_utilisateur, ArticleVendu no_article) {
		this.dateEnchère = dateEnchère;
		this.montant_enchere = montant_enchere;
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
	}
	
	public Enchere() {
	
	}

	public LocalDate getDateEnchère() {
		return dateEnchère;
	}
	public void setDateEnchère(LocalDate dateEnchère) {
		this.dateEnchère = dateEnchère;
	}
	public float getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	public Utilisateur getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(Utilisateur no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public ArticleVendu getNo_article() {
		return no_article;
	}
	public void setNo_article(ArticleVendu no_article) {
		this.no_article = no_article;
	}
	@Override
	public String toString() {
		return "Enchere [dateEnchère=" + dateEnchère + ", montant_enchere=" + montant_enchere + ", no_utilisateur="
				+ no_utilisateur + ", no_article=" + no_article + "]";
	}
	
}
