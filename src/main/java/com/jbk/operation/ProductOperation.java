package com.jbk.operation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.AggregateProjection;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import com.jbk.config.HibernateConfiguration;
import com.jbk.entity.Product;

public class ProductOperation {
	SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();

	/*
	 * Task Title 1: Add Product to Database
	 * 
	 * Task Description: The user wants to implement a system for adding product to
	 * a database. The product information Product Id, Product name, Product
	 * Quantity, Product Price, Manufacturing Date (mfgDate), and Expire Date
	 * (expDate). Design a system that allows users to input product
	 * details.validates the data(Optional), connect to the database, inserts the
	 * information, and provides appropriate success or error messages.
	 * 
	 * Input: Product. Output: Messages
	 */

	public String addProduct(Product product) {
		String msg = null;
		try {
			Session session = sessionFactory.openSession();
			session.save(product);
			session.beginTransaction().commit();
			msg = "Data Addedd Succefully";

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something Went Wrong!";
		}

		return msg;

	}

	/*
	 * Task Title 2: Delete Product from Database
	 * 
	 * Task Decription:the user wants to develop a functionality to delete product
	 * from the Database.Each product is identified by a unique Product ID. Design a
	 * system that prompts the user to input the Product ID of the product to be
	 * deleted, connects to the database, delete the specified product, and provides
	 * appropriate success or error message.
	 * 
	 * Input: Product ID Output: Message
	 */

	public String deleteProductById(long productId) {
		String msg = null;

		try {
			Session session = sessionFactory.openSession();

			Product product = session.get(Product.class, productId);

			session.delete(product);
			session.beginTransaction().commit();
			msg = " Record Deleted Successfully.";

		} catch (Exception e) {
			e.printStackTrace();
			msg = "Something Went Wrong, Try again!!";
		}

		return msg;
	}

	/*
	 * Task Title 3: Get particular Product data from Database using productId.
	 * 
	 * Task Description: The user wants to develop a functionality to get product
	 * form the database
	 * 
	 * Input: Product ID. Output: Product
	 */
	public Product getProductById(long productId) {
		Product product = null;
		try {
			Session session = sessionFactory.openSession();
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	/*
	 * Task Title 4: Update particular Product.
	 * 
	 * Task Description: The user want to develop a functionality to update
	 * particular Product . user will give updated product data to update exiting
	 * product. if product will update successfully then return success messages
	 * otherwise error message.
	 * 
	 * Input:Product(updated information). Output:Message(Updated successfully if
	 * operation success)
	 */

	public String updateProductById(Product product) {
		String msg = null;
		try {

			Session session = sessionFactory.openSession();
			session.update(product);
			session.beginTransaction().commit();
			msg = "Data Updated Successfully";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something Went Wrong, Try again!!");
		}

		return msg;
	}

	/*
	 * Task Title 5: Retrieve all Product from Database
	 * 
	 * Task Description: The user aims to implement a feature that retrieves all
	 * products form the database.this functionality involves fetching information
	 * about every product stored in the database and presenting it to the user.
	 * 
	 * Input: None( As this task involves retrieving all products, there may not be
	 * specific input parameters.). Output: List of Products
	 * 
	 * if the retrieval is successful, return the list of products; otherwise,
	 * return an product not found message.
	 */

	public List<Product> getAllProduct() {
		List<Product> list = null;
		try {
			Session session = sessionFactory.openSession();
			// how to get object of criteria?
			Criteria criteria = session.createCriteria(Product.class);

			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/*
	 * Task Title 6: Retrieve All Products in Ascending Order by Given Parameter
	 * Task Description: The user want implement the functionality to retrieve all
	 * products from the database. This functionality includes the ability to
	 * specify a parameter based on which the products will be sorted in ascending
	 * order.
	 * 
	 * Input: Parameter (e.g. price, name). Output:List of Products in Ascending
	 * Order
	 * 
	 * If the retrieval and sorting process is successful, return the list of
	 * products in ascending order based on the specified parameter; otherwise,
	 * return an error message.
	 */

	public List<Product> getAllProductInASO(String parameter) {
		List list = null;
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			criteria.addOrder(Order.asc(parameter));
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	/*
	 * Task Title 7: Retrieve All Products in Descending Order by Given Parameter
	 * Task Description: The user want implement the functionality to retrieve all
	 * products from the database. This functionality includes the ability to
	 * specify a parameter based on which the products will be sorted in Descending
	 * order.
	 * 
	 * Input: Parameter (e.g. price, name). Output:List of Products in Ascending
	 * Order
	 * 
	 * If the retrieval and sorting process is successful, return the list of
	 * products in ascending order based on the specified parameter; otherwise,
	 * return an error message.
	 */

	public List<Product> getAllProductInDSO(String parameter) {
		List list = null;
		try {

			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.desc(parameter));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/*
	 * Restrictions: it used for non-primary value
	 * 
	 * Task Title 8: Retrieve Product by Product Name Task Description: The user
	 * desires to implement a feature that retrieves a specific product from the
	 * database based on its name. This functionality involves searching the
	 * database for a product with a given name and returning its information.
	 * 
	 * Input: Product Name. Output: Product Information
	 * 
	 * If a product with the specified name is found, return the product
	 * information; otherwise, provide an error message indicating that the product
	 * was not found.
	 */

	public Product getProductByName(String productName) {
		Product product = null;

		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			SimpleExpression eq = Restrictions.eq("productName", productName);
			criteria.add(eq);

			Product uniqueResult = (Product) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;

	}

	/*
	 * Task Title 9: Retrieve Products with Price Greater Than Specified Price
	 * 
	 * Task Description: The user desires to implement a feature that retrieves
	 * products from the database with a price greater than a user-specified amount.
	 * This functionality involves querying the database for products that meet the
	 * specified price criterion and returning the relevant information.
	 * 
	 * Input: User-specified Price. Output: List of Products with Prices Greater
	 * Than the User-specified Amount
	 * 
	 * If products matching the criteria are found, return the list of products;
	 * otherwise, return an appropriate error message.
	 */

	public List<Product> moreThanGivenPriceProduct(Double productPrice) {
		List list = null;
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			SimpleExpression gt = Restrictions.gt("productPrice", productPrice);
			criteria.add(gt);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/*
	 * Projections: It is used for Aggregate Functions. Task 10: Retrieve Maximum
	 * Price Description: The aim is to create a function that identifies and
	 * returns the maximum price among all products stored in the database.
	 * 
	 * the output of this function will be the maximum price found within the
	 * database, rather than returning the product associated with that price
	 * 
	 */
	public double getMaxPrice() {
		double maxPrice = 0;

		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.max("productPrice"));
			List list = criteria.list();

			if (!list.isEmpty()) {
				maxPrice = (Double) list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maxPrice;

	}

	/*
	 * Task 11: Retrieve Minimum Price Description: The aim is to create a function
	 * that identifies and returns the minimum price among all products stored in
	 * the database.
	 * 
	 * the output of this function will be the minimum price found within the
	 * database, rather than returning the product associated with that price
	 */
	public double getMinPrice() {
		double minPrice = 0;
		try {
			Session session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.min("productPrice"));
			List list = criteria.list();

			if (!list.isEmpty()) {
				minPrice = (Double) list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return minPrice;

	}

	/*
	 * Task 12: Retrieve sum of product Price Description: The aim is to create a
	 * function that identifies and returns the sum of product price among all
	 * products stored in the database.
	 * 
	 * the output of this function will be the sum of product price found within the
	 * database
	 */

	public double getSumOfProducts() {
		long sum = 0;

		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			criteria.setProjection(Projections.count("productPrice"));
			List list = criteria.list();

			if (!list.isEmpty() && list.get(0) != null) {

				sum =  ((Number) list.get(0)).longValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sum;

	}

	/*
	 * Projections + Restrictions. Task Title 13: Retrieve product with maximum
	 * price. Task Description: Develop a feature that fetches the product with the
	 * highest price from database
	 */
	public Product productWithMaxPrice() {
		Product product = null;
		try {

			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);

			double maxPrice = getMaxPrice();

			criteria.add(Restrictions.eq("productPrice", maxPrice));

			List<Product> list = criteria.list();

			if (!list.isEmpty()) {
				product = list.get(0);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;

	}

	/*
	 * HomeWork Task Title 14: Retrieve Products by Name Pattern Task Description:
	 * The user desires to create a functionality that retrieves products whose
	 * names match a given pattern. This task involves searching the database for
	 * products whose names contain or closely match the specified pattern.
	 * 
	 * Input: Name Pattern Output: List of Matching Products
	 * 
	 * If products matching the given name pattern are found, return the list of
	 * those products; otherwise, return an appropriate error message indicating
	 * that no matching products were found.
	 ***********************************************************************
	 * 
	 * 
	 * 10) Task Title 15: Retrieve Products Within Price Range Task Description: The
	 * user intends to create a functionality that retrieves products falling within
	 * a specified price range. This feature involves querying the database to find
	 * products whose prices are between the given low and high values.
	 * 
	 * Input: Price Range (Low and High) Output: List of Products
	 * 
	 * The system should return a list of products that have prices within the
	 * specified range. If the retrieval is successful, provide the list; otherwise,
	 * return an error message.
	 * 
	 */

}
