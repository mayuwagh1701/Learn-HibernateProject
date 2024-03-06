package com.jbk;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jbk.config.HibernateConfiguration;
import com.jbk.entity.Product;
import com.jbk.operation.ProductOperation;
import com.sun.xml.bind.v2.runtime.Name;

public class Test {
	public static void main(String[] args) {

		System.out.println("App Started");
		Scanner sc = new Scanner(System.in);
		ProductOperation operation = new ProductOperation();
		int choice;
		char ch;

		do {
			System.out.println("Press 1. Add Product:");
			System.out.println("Press 2. Delete Product by id:");
			System.out.println("Press 3. Get Product by Id:");
			System.out.println("Press 4. Update Product:");
			System.out.println("Press 5. Get All Products: ");
			System.out.println("Press 6. Get All Products In AS_Order:");
			System.out.println("Press 7. Get All Product In DS_Order:");

			/* ***** Restrictions ************ */
			System.out.println("Press 8. Get Product by Name:");
			System.out.println("Press 9. Get Product Whose Price > Given Price of Product");

			/* ******* Projections ************* */
			System.out.println("Press 10. Get Max Price of Products:");
			System.out.println("Press 11. Get Min Price of Products:");
			System.out.println("Press 12. Get Sum of Price of All Products");

			/* ***** Projections + Restrictions *************** */
			System.out.println("Press 13. Get Product with Max Price");

			choice = sc.nextInt();

			switch (choice) {
			case 1:

			{
				Product product = new Product();
				System.out.println("Enter product Id:");
				int productId = sc.nextInt();
				product.setProductId(productId);

				System.out.println("Enter exp_date:");
				String expDate = sc.next();
				product.setExpDate(expDate);

				System.out.println("Enter mfg_date:");
				String mfgDate = sc.next();
				product.setMfgDate(mfgDate);

				System.out.println("Enter product name:");
				String productName = sc.next();
				product.setProductName(productName);

				System.out.println("Eneter product price:");
				double productPrice = sc.nextDouble();
				product.setProductPrice(productPrice);

				System.out.println("Enter product qty:");
				int productQty = sc.nextInt();
				product.setProductQty(productQty);

				String msg = operation.addProduct(product);
				System.out.println(msg);
				break;
			}
			case 2: {
				System.out.println("Enter Product Id: ");
				int productId = sc.nextInt();

				String msg = operation.deleteProductById(productId);

				System.out.println(msg);
				break;
			}

			case 3: {
				System.out.println("Enter Product Id:");
				int productId = sc.nextInt();
				Product product = operation.getProductById(productId);
				System.out.println(product);

				break;
			}
			case 4: {
				System.out.println("Enter Product Information for Updation:");
				Product product = new Product();

				System.out.println("Enter product id:");
				int productId = sc.nextInt();
				product.setProductId(productId);

				System.out.println("Enter product exp_date:");
				String expDate = sc.next();
				product.setExpDate(expDate);

				System.out.println("Enter product mfg_date:");
				String mfgDate = sc.next();
				product.setMfgDate(mfgDate);

				System.out.println("Enter product name:");
				String productName = sc.next();
				product.setProductName(productName);

				System.out.println("Enter product price:");
				double productPrice = sc.nextDouble();
				product.setProductPrice(productPrice);

				System.out.println("Enter product qty:");
				int productQty = sc.nextInt();
				product.setProductQty(productQty);

				String msg = operation.updateProductById(product);
				System.out.println(msg);

				break;
			}

			case 5: {
				List<Product> list = operation.getAllProduct();

				for (Product product : list) {
					System.out.println(product);
				}
				break;
			}

			case 6: {
				System.out.println("Enter Field Name to Sort Product in Asceding Order:");
				String parameter = sc.next();
				List<Product> list = operation.getAllProductInASO(parameter);
				for (Product product : list) {
					System.out.println(product);
				}

				break;
			}
			case 7: {
				System.out.println("Enter Field Name to Sort Product in Descending Order:");
				String parameter = sc.next();
				List<Product> list = operation.getAllProductInDSO(parameter);
				for (Product product : list) {
					System.out.println(product);

				}
				break;
			}
			case 8: {
				System.out.println("Enter Product Name:");
				String productName = sc.next();
				Product product = operation.getProductByName(productName);
				System.out.println(product);
				break;
			}

			case 9: {
				System.out.println("Enter Price:");
				Double productPrice = sc.nextDouble();
				List<Product> list = operation.moreThanGivenPriceProduct(productPrice);
				if (list.isEmpty()) {
					System.out.println("Product not Found:");
				} else {
					for (Product product : list) {
						System.out.println(product);
					}
				}

				break;

			}
			case 10: {
				double maxPrice = operation.getMaxPrice();
				System.out.println(maxPrice);
				break;
			}
			case 11: {
				double minPrice = operation.getMinPrice();
				System.out.println(minPrice);

				break;
			}

			case 12: {
				 double sumOfProducts = (long) operation.getSumOfProducts();
				System.out.println(sumOfProducts);

				break;

			}

			case 13: {
				Product product = operation.productWithMaxPrice();
				if (product != null) {
					System.out.println(product);
				} else {
					System.out.println("product not found");
				}
				break;
			}

			default:
				System.out.println("Invalid choice");
				break;
			}

			System.out.println("Do you want to continue yes/no");
			ch = sc.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}

}
