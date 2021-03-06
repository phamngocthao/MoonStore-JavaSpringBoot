package com.mstore.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mstore.domain.Account;
import com.mstore.repository.AccountDAO;
import com.mstore.repository.OrderDetailDAO;
import com.mstore.service.AccountService;

@Repository
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDAO accDao;
	
	@Autowired
	OrderDetailDAO detailDao;

	@Override
	public Account getByUsername(String username) {
		// TODO Auto-generated method stub
		return accDao.getById(username);
	}

	@Override
	public List<Object[]> getHistory(String username) {
		// TODO Auto-generated method stub
		return detailDao.getHistoryByCustomer(username);
	}
	
	
}
