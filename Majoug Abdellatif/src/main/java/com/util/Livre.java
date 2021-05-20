package com.util;

public class Livre {
	String name,auteur;
	int categorie,id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public int getCategorie() {
		return categorie;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}
}