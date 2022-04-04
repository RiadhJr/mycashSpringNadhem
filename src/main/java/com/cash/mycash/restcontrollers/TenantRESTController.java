package com.cash.mycash.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cash.mycash.entities.Tenant;
import com.cash.mycash.service.TenantService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TenantRESTController {
	
	@Autowired
	TenantService tenantService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Tenant> getAllTenants ()
	{
		return tenantService.getAllTenants();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Tenant getTenantById(@PathVariable("id") Long id) { 
		return tenantService.getTenant(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Tenant createProduit(@RequestBody Tenant tenant) {
	return tenantService.saveTenant(tenant);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Tenant updateProduit(@RequestBody Tenant tenant) {
	return tenantService.updateTenant(tenant);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteTenant(@PathVariable("id") Long id)
	{
		tenantService.deleteTenantById(id);
	}
	
	@RequestMapping(value="/tenantscat/{idCat}",method = RequestMethod.GET)
	public List<Tenant> getTenantsByCatId(@PathVariable("idCat") Long idCat) {
	return tenantService.findByCategorieIdCat(idCat);
	}

}
