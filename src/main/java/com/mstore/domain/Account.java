package com.mstore.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")

public class Account{
	
	@Id
	String username;
	String password;
	String fullname;
	String phone;
	String email;
	String address;
	Boolean activated;
	Boolean admin;
	
	@OneToMany(mappedBy = "account",fetch = FetchType.EAGER)
	List<Order> orders;
}
