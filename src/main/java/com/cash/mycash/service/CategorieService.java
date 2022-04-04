package com.cash.mycash.service;

import java.util.List;

import com.cash.mycash.entities.Categorie;

public interface CategorieService {
	
	Categorie saveCategorie(Categorie c);
	Categorie updateCategorie(Categorie c);
	void deleteCategorie(Categorie c);
	void deleteCategorieById(Long id);
	Categorie getCategorie(Long id);
	List<Categorie> getAllCategories();

	
}
