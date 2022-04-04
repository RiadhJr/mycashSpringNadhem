package com.cash.mycash.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cash.mycash.entities.Categorie;
import com.cash.mycash.entities.Tenant;

public interface TenantService {
	
	Tenant saveTenant(Tenant t);
	Tenant updateTenant(Tenant t);
	void deleteTenant(Tenant t);
	void deleteTenantById(Long id);
	Tenant getTenant(Long id);
	List<Tenant> getAllTenants();
	
	List<Tenant> FindByNomTenant(String nom);
	List<Tenant> findByNomTenantContains(String nom);
	List<Tenant> findByNomAndSchema (String tenant, String schema);
	List<Tenant> findByCategorie (Categorie categorie);
	List<Tenant> findByCategorieIdCat(Long id);
	List<Tenant> findByOrderByNomTenantAsc();
	List<Tenant> TrierTenantsNomsSchema();
	
	Page<Tenant> getAllTenantsParPage(int page, int size);
}
