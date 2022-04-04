package com.cash.mycash;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.cash.mycash.entities.Categorie;
import com.cash.mycash.entities.Tenant;
import com.cash.mycash.repos.TenantRepository;
import com.cash.mycash.service.TenantService;

/*@SpringBootTest
class MycashApplicationTests {

	@Autowired
	private TenantRepository tenantRepository;
	
	@Autowired
	private TenantService tenantService;
	
	@Test
	public void testCreateTenant() {
		Tenant ten = new Tenant("tenant3", "tenant3schema", new Date());
		tenantRepository.save(ten);
	}
	
	@Test
	public void testFindByNomTenantContains()
	{
	Page<Tenant> tenant = tenantService.getAllTenantsParPage(0,2);
	System.out.println(tenant.getSize());
	System.out.println(tenant.getTotalElements());
	System.out.println(tenant.getTotalPages());
	
	tenant.getContent().forEach(t -> {System.out.println(t.toString());
	});  */

	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
/*
	}
	*/
	/*
	@Test
	public void testFindByNomTenant()
	{
	List<Tenant> tenants = tenantRepository.findByNomTenant("tenant_4");
	for (Tenant t : tenants)
	{
	System.out.println(t);
	}
	}
	
	@Test
	public void testFindByTenantContains ()
	{
	List<Tenant> Tenants=tenantRepository.findByNomTenantContains("6");
	for (Tenant t : Tenants)
	{
	System.out.println(t);
	} 
	}
	
	@Test
	public void testfindByNomAndSchema()
	{
	List<Tenant> tenants = tenantRepository.findByNomAndSchema("tenant_4" , "tenant_4schema");
	for (Tenant t : tenants)
	{
	System.out.println(t);
	}
	}
	
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Tenant> tenants = tenantRepository.findByCategorie(cat);
	for (Tenant t : tenants)
	{
	System.out.println(t);
	}
	}
	
	@Test
	public void findByCategorieIdCat()
	{
	List<Tenant> tenants = tenantRepository.findByCategorieIdCat(1L);
	for (Tenant t : tenants)
	{
	System.out.println(t);
	}
	}
	
	@Test
	public void testfindByOrderByNomTenantAsc()
	{
	List<Tenant> tenants = tenantRepository.findByOrderByNomTenantAsc();
	for (Tenant t : tenants)
	{
	System.out.println(t);
	}
	}
	@Test public void testTrierTenantsNomsSchema()
	{
	List<Tenant> tenants = tenantRepository.TrierTenantsNomsSchema();
	for (Tenant t : tenants)
	{
	System.out.println(t);
	}
	}
}*/
