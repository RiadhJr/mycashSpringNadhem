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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long user_id;
	private String username;
	private String password;
	private Boolean enabled;

	@ManyToOne
	private Role role;
}
