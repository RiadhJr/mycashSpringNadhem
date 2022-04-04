package com.cash.mycash;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.cash.mycash.entities.Categorie;
import com.cash.mycash.entities.Tenant;
import com.cash.mycash.service.CategorieService;
import com.cash.mycash.service.TenantService;

@SpringBootApplication
public class MycashApplication implements CommandLineRunner{

	@Autowired
	TenantService tenantService;
	@Autowired
	CategorieService categorieService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	public static void main(String[] args) {
		SpringApplication.run(MycashApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//tenantService.saveTenant(new Tenant("tenant_4", "tenant_4schema", new Date()));
		//tenantService.saveTenant(new Tenant("tenant_5", "tenant_5schema", new Date()));
		//tenantService.saveTenant(new Tenant("tenant_6", "tenant_6schema", new Date()));
		
		//categorieService.saveCategorie(new Categorie("cafe", "cafeteria"));
		
		
		repositoryRestConfiguration.exposeIdsFor(Tenant.class); //retourner id pour les api
	
	}

}
