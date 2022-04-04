package com.cash.mycash.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Entity
public class Tenant {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idTenant;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomTenant;
	
	//@Min(value = 10)
	//@Max(value = 10000)  //exemple de contrainte sur quanite par exemple
	
	@NotNull
	@Size (min = 4,max = 15)
	private String schemaName;
	
	
	private String passWord;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateAjout;
	
	@ManyToOne   //optionnel ici  
	private Categorie categorie;
	
	
	
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Tenant(String nomTenant, String schemaName, Date dateAjout) {
		super();
		this.nomTenant = nomTenant;
		this.schemaName = schemaName;
		this.dateAjout = dateAjout;
	}





	public Long getIdTenant() {
		return idTenant;
	}
	public void setIdTenant(Long idTenant) {
		this.idTenant = idTenant;
	}
	public String getNomTenant() {
		return nomTenant;
	}
	public void setNomTenant(String nomTenant) {
		this.nomTenant = nomTenant;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public Date getDateAjout() {
		return dateAjout;
	}
	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}





	@Override
	public String toString() {
		return "Tenant [idTenant=" + idTenant + ", nomTenant=" + nomTenant + ", schemaName=" + schemaName
				+ ", dateAjout=" + dateAjout + "]";
	}





	public Categorie getCategorie() {
		return categorie;
	}





	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}





	public String getPassWord() {
		return passWord;
	}





	public void setPassWord(String passWord) {
		this.passWord = new BCryptPasswordEncoder().encode(passWord);
	}
	
	


}
