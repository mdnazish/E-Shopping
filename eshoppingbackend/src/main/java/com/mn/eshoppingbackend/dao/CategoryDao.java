package com.mn.eshoppingbackend.dao;

import java.util.List;

import com.mn.eshoppingbackend.dto.Category;

public interface CategoryDao {
	
	List<Category> list();

	Category get(int id);

}
