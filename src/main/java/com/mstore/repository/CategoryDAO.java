package com.mstore.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mstore.domain.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer>{
	
	@Query("SELECT c FROM Category c WHERE c.name LIKE ?1")
	public List<Category> selectCategorybyShirt(String shirt);
	
	@Query("SELECT c FROM Category c WHERE c.name LIKE ?1")
	public List<Category> selectCategorybyPant(String pant);
	
	@Query("SELECT c FROM Category c WHERE c.name LIKE ?1")
	public List<Category> selectCategorybyAccess(String accessories);
	
	@Query("SELECT c FROM Category c WHERE c.name LIKE %?1% ORDER BY c.id desc")
	public Page<Category> getAllCategoryAndSearch(String keyword,Pageable pageable);
	
	@Query("SELECT c FROM Category c ORDER BY c.id desc")
	public Page<Category> getAllCategory(Pageable pageable);
	
}
