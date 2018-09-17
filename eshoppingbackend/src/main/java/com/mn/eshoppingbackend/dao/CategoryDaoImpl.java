package com.mn.eshoppingbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mn.eshoppingbackend.dto.Category;

@Repository("categoryDao")
@Transactional // Use Class Level - if Every method belongs to transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	// private static List<Category> categories = new ArrayList<>();

	/*
	 * static { Category category = new Category();
	 * 
	 * //adding first category category.setId(1); category.setName("Television");
	 * category.setDescription("This is related to TV");
	 * category.setImageURL("CAT_1.png"); categories.add(category);
	 * 
	 * 
	 * //adding second category category = new Category(); category.setId(2);
	 * category.setName("Laptop");
	 * category.setDescription("This is related to Laptop");
	 * category.setImageURL("CAT_2.png"); categories.add(category);
	 * 
	 * 
	 * //adding third category category = new Category(); category.setId(3);
	 * category.setName("Mobile");
	 * category.setDescription("This is related to Mobile");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * categories.add(category); }
	 */

	@Override
	public List<Category> list() {

		// return categories;

		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
	}

	/*
	 * (non-Javadoc) Getting single category based on id
	 * 
	 * @see com.mn.eshoppingbackend.dao.CategoryDao#get(int)
	 */
	@Override
	public Category get(int id) {

		// enhanced for loop
		/*
		 * for(Category category : categories) { if(category.getId() == id) return
		 * category; } return null;
		 */

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	// @Transactional // Use Method Level - if only one transactional method present
	public boolean add(Category category) {
		try {
			// add the category to the database table
		
			sessionFactory.getCurrentSession().persist(category);
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {

		try {
			// updating a single category from the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {
			// deleting a single category from the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

}
