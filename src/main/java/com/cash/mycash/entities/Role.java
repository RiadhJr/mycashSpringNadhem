package com.cash.mycash.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Role {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long role_id;
	private String role;
	
	//@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id") ,inverseJoinColumns = @JoinColumn(name="role_id"))
	@OneToMany (mappedBy = "role")
	private List<User> users;


}
