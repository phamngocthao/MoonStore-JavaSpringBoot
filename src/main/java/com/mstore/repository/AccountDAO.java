package com.mstore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mstore.domain.Account;


@Repository
public interface AccountDAO extends JpaRepository<Account, String>{

	@Query("SELECT a FROM Account a WHERE a.admin=false AND CONCAT(a.fullname,' ',a.email,' ',a.phone,' ',a.address) LIKE %?1%"
			+ " ORDER BY a.dateregister desc")
	public Page<Account> getAllCustomerAndSearch(String keyword,Pageable pageable);
	
	
	@Query("SELECT a FROM Account a WHERE a.admin=false ORDER BY a.dateregister desc")
	public Page<Account> getAllCustomer(Pageable pageable);
	
	@Query("SELECT a FROM Account a WHERE a.admin = false ORDER BY a.dateregister desc")
	public Page<Account> getCustomer(Pageable pageable);
	
	@Query("SELECT a FROM Account a WHERE a.admin=false AND CONCAT(a.fullname,' ',a.email,' ',a.phone,' ',a.address) LIKE %?1%"
			+ " ORDER BY a.dateregister desc")
	public Page<Account> getCustomerAndSearch(String keyword,Pageable pageable);
	
	@Query("SELECT a FROM Account a WHERE a.admin = true ORDER BY a.dateregister desc")
	public Page<Account> getAdmin(Pageable pageable);
	
	@Query("SELECT a FROM Account a WHERE a.admin=true AND CONCAT(a.fullname,' ',a.email,' ',a.phone,' ',a.address) LIKE %?1%"
			+ " ORDER BY a.dateregister desc")
	public Page<Account> getAdminAndSearch(String keyword,Pageable pageable);
}
