package com.mstore.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mstore.domain.Category;
import com.mstore.repository.CategoryDAO;
import com.mstore.service.CategoryService;

@Repository
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDAO categoryDao;

	@Override
	public List<Category> getCategoryToShirt() {
		String shirt = "áo%";
		return categoryDao.selectCategorybyShirt(shirt);
	}
	
	@Override
	public List<Category> getCategoryToPant() {
		String pant = "quần%";
		return categoryDao.selectCategorybyPant(pant);
	}
	
	@Override
	public List<Category> getCategoryToAccessories() {
		String accessories = "phụ%";
		return categoryDao.selectCategorybyAccess(accessories);
	}

	@Override
	public Category insert(Category category) {
		
		return categoryDao.save(category);
	}

	@Override
	public Category update(Category category) {
		
		return categoryDao.save(category);
	}

	@Override
	public void delete(int id) {
		
		categoryDao.deleteById(id);	
	}

	@Override
	public Page<Category> getAllCategoryAndSearch(int currentPage, String keyword) {
		Pageable pageable = PageRequest.of(currentPage-1, 8);
		
		if(keyword != null) {
			return categoryDao.getAllCategoryAndSearch(keyword,pageable);
		}
		return categoryDao.getAllCategory(pageable);
	}

	@Override
	public Page<Category> getAllCategory(int pageNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
