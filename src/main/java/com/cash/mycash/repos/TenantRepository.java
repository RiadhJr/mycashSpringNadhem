package com.cash.mycash.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cash.mycash.entities.Categorie;
import com.cash.mycash.entities.Tenant;


@RepositoryRestResource(path = "rest")
public interface TenantRepository extends JpaRepository<Tenant, Long> {

	List<Tenant> findByNomTenant(String nom);
	List<Tenant> findByNomTenantContains(String nom);
	
	
	/*@Query("select t from Tenant t where t.nomTenant like %?1 and t.schemaName like %?2") 
	List<Tenant> findByNomAndSchema (String tenant, String schema);*/
	
	@Query("select t from Tenant t where t.nomTenant like %:nom and t.schemaName like :schema")
	List<Tenant> findByNomAndSchema (@Param("nom") String nom,@Param("schema") String schema);
	
	
	@Query("select t from Tenant t where t.categorie = ?1") 
	List<Tenant> findByCategorie (Categorie categorie);
	
	List<Tenant> findByCategorieIdCat(Long id);
	
	List<Tenant> findByOrderByNomTenantAsc();
	
	
	//@Query("select t from Tenant t order by t.nomTenant ASC, t.schemaName DESC")
	@Query("select t , max(t.idTenant) from Tenant t")
	List<Tenant> TrierTenantsNomsSchema ();
}
