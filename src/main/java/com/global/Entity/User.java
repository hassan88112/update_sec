package com.global.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.filefilter.FalseFileFilter;

import lombok.NonNull;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	@Column(unique = true)

	private String email;

	private String password;
	
	@ManyToMany
	@JoinTable(name = "User_role" ,
	joinColumns  =@JoinColumn(name = "USER_ID"),
	inverseJoinColumns = @JoinColumn(name="ROLE_ID"))		
	private List<Role> roles;



}
