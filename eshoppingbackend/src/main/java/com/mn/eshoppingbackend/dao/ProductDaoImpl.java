package com.mn.eshoppingbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mn.eshoppingbackend.dto.Category;
import com.mn.eshoppingbackend.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	// For single Product
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	// for List of Product
	@Override
	public List<Product> list() {
		
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product", Product.class)
						.getResultList();
	}
	
	//Insert a product into DB Table

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory
				.getCurrentSession()
					.persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	//update a product 
	@Override
	public boolean update(Product product) {

		try {
			sessionFactory
					.getCurrentSession()
							.update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			
			//call the update method
			return this.update(product);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProduct = "FROM Product WHERE active = :active";
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProduct, Product.class)
							.setParameter("active", true)
								.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		
		return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveProductsByCategory, Product.class)
							.setParameter("active", true)
								.setParameter("categoryId", categoryId)
									.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String searchLatestProducts = "FROM Product WHERE active = :active ORDER BY id";
		return sessionFactory
				.getCurrentSession()
				.createQuery(searchLatestProducts, Product.class)
					.setParameter("active", true)
						.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();
	}

}
