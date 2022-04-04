package com.cash.mycash.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomTen", types = { Tenant.class })
public interface TenantProjection {
	public String getNomTenant();

}
