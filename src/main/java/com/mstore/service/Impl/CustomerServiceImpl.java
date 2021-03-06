package com.mstore.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.mstore.domain.Account;
import com.mstore.repository.AccountDAO;
import com.mstore.service.CustomerService;


@Repository
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	AccountDAO accDao;
	
	@Override
	public Page<Account> getAllCustomer(int currentPage,String keyword) {
		Pageable pageable = PageRequest.of(currentPage-1, 8);
		
		if(keyword != null) {
			return accDao.getAllCustomerAndSearch(keyword,pageable);
		}
		return accDao.getAllCustomer(pageable);
	}

	@Override
	public Page<Account> getAdmin(int currentPage,String keyword) {
		Pageable pageable = PageRequest.of(currentPage-1, 8);
		
		if(keyword != null) {
			return accDao.getAdminAndSearch(keyword,pageable);
		}
		return accDao.getAdmin(pageable);
	}

	@Override
	public Page<Account> getCustomer(int currentPage,String keyword) {
		Pageable pageable = PageRequest.of(currentPage-1, 8);
		
		if(keyword != null) {
			return accDao.getCustomerAndSearch(keyword,pageable);
		}
		return accDao.getCustomer(pageable);
	}

}
