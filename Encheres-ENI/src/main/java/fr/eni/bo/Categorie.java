package fr.eni.bo;

import java.util.ArrayList;

public class Categorie {
	private int noCategorie;
	private String libelle;
	ArrayList<ArticleVendu> categorieArticle;
	public Categorie(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.categorieArticle = categorieArticle;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public ArrayList<ArticleVendu> getCategorieArticle() {
		return categorieArticle;
	}
	public void setCategorieArticle(ArrayList<ArticleVendu> categorieArticle) {
		this.categorieArticle = categorieArticle;
	}
	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", categorieArticle="
				+ categorieArticle + "]";
	}
	
}
