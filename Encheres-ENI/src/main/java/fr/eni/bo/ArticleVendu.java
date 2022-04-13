package fr.eni.bo;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleVendu {
	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private boolean etatVente; // (à déterminer : en cours, vendu...?)
	private Retrait lieuRetrait;
	private ArrayList<Enchere> listeEnchere;
	private Utilisateur no_utilisateur;
	private Categorie no_categorie;
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, boolean etatVente, Retrait lieuRetrait,
			Utilisateur no_utilisateur, Categorie no_categorie) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.lieuRetrait = lieuRetrait;
		this.listeEnchere = listeEnchere;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
	}
	
	public ArticleVendu() {
		
	}

	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public int getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public int getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}
	public boolean isEtatVente() {
		return etatVente;
	}
	public void setEtatVente(boolean etatVente) {
		this.etatVente = etatVente;
	}
	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}
	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}
	public ArrayList<Enchere> getListeEnchere() {
		return listeEnchere;
	}
	public void setListeEnchere(ArrayList<Enchere> listeEnchere) {
		this.listeEnchere = listeEnchere;
	}
	public Utilisateur getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(Utilisateur no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public Categorie getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(Categorie no_categorie) {
		this.no_categorie = no_categorie;
	}
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", lieuRetrait=" + lieuRetrait
				+ ", listeEnchere=" + listeEnchere + ", no_utilisateur=" + no_utilisateur + ", no_categorie="
				+ no_categorie + "]";
	}
	
}
