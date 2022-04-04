package com.cash.mycash.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categorie {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCat;
	
	private String nomCat;
	private String descriptionCat;
	
	@OneToMany (mappedBy = "categorie") //mappedBy : pour ne pas créer un 3 eme table (autre que tenant et categorie) pour faire la liason entre
	@JsonIgnore
	private List<Tenant> tenants;

	public Categorie(String nomCat, String descriptionCat) {
		super();
		this.nomCat = nomCat;
		this.descriptionCat = descriptionCat;
	}
}
