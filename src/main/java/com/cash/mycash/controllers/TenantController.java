package com.cash.mycash.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cash.mycash.entities.Tenant;
import com.cash.mycash.service.TenantService;

@Controller
public class TenantController {  
	
	@Autowired
	TenantService tenantService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		modelMap.addAttribute("tenant", new Tenant());
		modelMap.addAttribute("mode", "new");
		return "formTenant";
	}
	
	/*@RequestMapping("/saveTenant")
	public String saveTenant(@ModelAttribute("tenant") Tenant tenant,
							  @RequestParam("date") String date,
							  ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateAjout = dateformat.parse(String.valueOf(date)); 
	tenant.setDateAjout(dateAjout);
	Tenant saveTenant = tenantService.saveTenant(tenant);
	String msg ="tenant enregistré avec Id "+saveTenant.getIdTenant();
	modelMap.addAttribute("msg", msg);
	return "createTenant";
	}*/
	
	@RequestMapping("/saveTenant")
	public String saveTenant(@Valid Tenant tenant, BindingResult bindingResult)
	{
		
		if (bindingResult.hasErrors()) return "formTenant";
		tenantService.saveTenant(tenant);
		return "formTenant";
	} 
	
	@RequestMapping("/ListeTenants")
	public String listeProduits(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		Page<Tenant> prods = tenantService.getAllTenantsParPage(page, size);
		modelMap.addAttribute("tenants", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeTenants";
	}
	
	@RequestMapping("/supprimerTenant")
	public String supprimerTenant(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
	tenantService.deleteTenantById(id);
	Page<Tenant> tenant = tenantService.getAllTenantsParPage(page, size);
	modelMap.addAttribute("tenants", tenant);
	modelMap.addAttribute("pages", new int[tenant.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeTenants";
	}
	
	
	@RequestMapping("/modifierTenant")
	public String editerTenant(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Tenant t= tenantService.getTenant(id);
	modelMap.addAttribute("tenant", t);
	modelMap.addAttribute("mode", "edit");
	return "formTenant";
	}
	
	@RequestMapping("/updateTenant")
	public String updateTenanat(@ModelAttribute("produit") Tenant tenant,
	@RequestParam("date") String date,
		ModelMap modelMap) throws ParseException
	{
	//conversion de la date 
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateAjout = dateformat.parse(String.valueOf(date));
	tenant.setDateAjout(dateAjout);
	tenantService.updateTenant(tenant);
	List<Tenant> prods = tenantService.getAllTenants();
	modelMap.addAttribute("tenants", prods);
	return "listeTenants";
	}
	
}
