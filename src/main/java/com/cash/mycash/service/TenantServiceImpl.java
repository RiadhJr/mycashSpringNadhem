package com.cash.mycash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cash.mycash.entities.Categorie;
import com.cash.mycash.entities.Tenant;
import com.cash.mycash.repos.TenantRepository;


@Service
public class TenantServiceImpl implements TenantService{

	@Autowired
	TenantRepository tenantRepository;
	
	@Override
	public Tenant saveTenant(Tenant t) {
		return tenantRepository.save(t);
	}

	@Override
	public Tenant updateTenant(Tenant t) {
		return tenantRepository.save(t);
	}

	@Override
	public void deleteTenant(Tenant t) {
		tenantRepository.delete(t);
		
	}

	@Override
	public void deleteTenantById(Long id) {
		tenantRepository.deleteById(id);
		
	}

	@Override
	public Tenant getTenant(Long id) {
		
		return tenantRepository.findById(id).get();
	}

	@Override
	public List<Tenant> getAllTenants() {
		
		return tenantRepository.findAll();
	}
	

	@Override
	public Page<Tenant> getAllTenantsParPage(int page, int size) {
		// TODO Auto-generated method stub
		return tenantRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Tenant> FindByNomTenant(String nom) {
		// TODO Auto-generated method stub
		return tenantRepository.findByNomTenant(nom);
	}

	@Override
	public List<Tenant> findByNomTenantContains(String nom) {
		// TODO Auto-generated method stub
		return tenantRepository.findByNomTenantContains(nom);
	}

	@Override
	public List<Tenant> findByNomAndSchema(String tenant, String schema) {
		// TODO Auto-generated method stub
		return tenantRepository.findByNomAndSchema(tenant, schema);
	}

	@Override
	public List<Tenant> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return tenantRepository.findByCategorie(categorie);
	}

	@Override
	public List<Tenant> findByCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return tenantRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Tenant> findByOrderByNomTenantAsc() {
		// TODO Auto-generated method stub
		return tenantRepository.findByOrderByNomTenantAsc();
	}

	@Override
	public List<Tenant> TrierTenantsNomsSchema() {
		// TODO Auto-generated method stub
		return tenantRepository.TrierTenantsNomsSchema();
	}

}
