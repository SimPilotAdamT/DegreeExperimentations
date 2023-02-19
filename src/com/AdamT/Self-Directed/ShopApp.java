// Most of my expanded code is on https://github.com/SimPilotAdamT/DegreeExperimentations/
// Everything is licensed under the GNU GPL v3 License.

import java.util.Scanner;

/**
 * A simple command-line application for managing products in a store.
 * The user can display a list of products, buy stock, sell stock,
 * and change the prices of products.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-12-10T03:30:00Z
 */
public class ShopApp {
	/** The list of products in the store. */
	private static Product[] products;

	/** The number of products in the store. */
	private static final int NUM_PRODUCTS = 5;

	/** A scanner for reading input from the user. */
	private static final Scanner input = new Scanner(System.in);

	/**
	 * The main entry point for the application.
	 *
	 * @param args command-line arguments
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:30:00Z
	 */
	public static void main(String[] args) {
		System.out.println("Adam Tazul - 2274640 - SimPilotAdamT");
		products = new Product[NUM_PRODUCTS];
		// Initialize the products array with some default products
		products[0] = new Product("Shampoo", 10, 2.5);
		products[1] = new Product("Soap", 15, 1.0);
		products[2] = new Product("Toothpaste", 20, 0.75);
		products[3] = new Product("Toothbrush", 5, 1.25);
		products[4] = new Product("Mouthwash", 10, 3.0);
		// Display the main menu and handle the user's choice
		int choice = showMenu();
		while (choice != 5) {
			switch (choice) {
				case 1:
					displayProducts();
					break;
				case 2:
					buyStock();
					break;
				case 3:
					sellStock();
					break;
				case 4:
					repriceStock();
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
					break;
			}
			choice = showMenu();
		}
		System.out.println("Exiting program...");
		input.close();
	}

	/**
	 * Displays the main menu for the application, and reads the user's choice.
	 *
	 * @return the user's choice from the main menu
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:30:00Z
	 */
	private static int showMenu() {
		boolean valid = false;
		String in;
		int out;
		while (!valid) {
			System.out.println();
			System.out.println("Shop App Menu:");
			System.out.println("1. Display products");
			System.out.println("2. Buy stock");
			System.out.println("3. Sell stock");
			System.out.println("4. Reprice stock");
			System.out.println("5. Exit program");
			System.out.print("Enter your choice: ");
			in = input.nextLine();
			try {
				out = Integer.parseInt(in);
				valid = true;
			} catch (NumberFormatException e) {System.out.println("Error! Invalid input!");}
		}
		return out;
	}

	/**
	 * Displays a list of products in the store.
	 *
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:30:00Z
	 */
	private static void displayProducts() {
		System.out.println();
		System.out.println("Product List:");
		for (int i = 0; i < NUM_PRODUCTS; i++) {
			Product product = products[i];
			System.out.println(
				(i+1) + ". " +
				product.getName() + " - " +
				"Stock Level: " + product.getStockLevel() + " - " +
				"Price: £" + product.getPrice()
			);
		}
	}

	/**
	 * Lets the user buy stock for a product.
	 *
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:30:00Z
	 */
	private static void buyStock() {
		boolean valid = false;
		String in;
		String out;
		int numItems;
		System.out.println();
		System.out.println("Buy Stock:");
		int productIndex = selectProduct();
		if (productIndex == -1) return;
		Product product = products[productIndex];
		while (!valid) {
			System.out.print("Enter the number of items to buy: ");
			in = input.nextLine();
			try {
				numItems = Integer.parseInt(in);
				if (numItems >= 0) valid = true;
				else System.out.println("Invalid number of items. Please try again.\n");
			} catch (NumberFormatException e) {System.out.println("Error! Invalid input!\n");}
		}
		double totalCost = product.buyStock(numItems);
		System.out.println("Total cost: £" + totalCost);
	}

	/**
	 * Lets the user sell stock for a product.
	 *
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:30:00Z
	 */
	private static void sellStock() {
		boolean valid = false;
		String in;
		int numItems;
		System.out.println();
		System.out.println("Sell Stock:");
		int productIndex = selectProduct();
		if (productIndex == -1) return;
		Product product = products[productIndex];
		while (!valid) {
			System.out.print("Enter the number of items to sell: ");
			in = input.nextLine;
			try {
				numItems = Integer.parseInt(in);
				if (numItems < 0 || !product.sell(numItems)) System.out.println("Invalid number of items. Please try again.\n");
				else valid = true;
			} catch (NumberFormatException e) {System.out.println("Error! Invalid input!\n");}
		}
		double totalIncome = product.sellStock(numItems);
		System.out.println("Total Income: £" + totalCost);
	}

	/**
	 * Lets the user change the price of a product.
	 *
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:30:00Z
	 */
	private static void repriceStock() {
		boolean valid = false;
		String in;
		double newPrice;
		System.out.println();
		System.out.println("Reprice Stock:");
		int productIndex = selectProduct();
		if (productIndex == -1) return;
		Product product = products[productIndex];
		while (!valid) {
			System.out.print("Enter the new price: ");
			in = input.nextLine();
			try {
				newPrice = Double.parseDouble(in);
				if (newPrice < 0) System.out.println("Invalid price. Please try again.\n");
				else valid = true;
			} catch (NumberFormatException e) {System.out.println("Error! Invalid input!\n");}
		}
		product.setPrice(newPrice);
	}

	/**
	 * Lets the user select a product from the list of products.
	 *
	 * @return the index of the selected product, or -1 if no product was selected
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:30:00Z
	 */
	private static int selectProduct() {
		boolean valid = false;
		String in;
		int productIndex
		displayProducts();
		while (!valid) {
			System.out.print("Enter the product number: ");
			in = input.nextLine();
			try {
				productIndex = Integer.parseInt(in);
				if (productIndex < 1 || productIndex > NUM_PRODUCTS) System.out.println("Invalid product number. Please try again.\n");
				else valid = true;
			} catch (NumberFormatException e) {System.out.println("Error! Invalid input!\n");}
		}
		return productIndex - 1;
	}
}


/**
 * A class representing a product in a store.
 * It has a name, stock level, and price.
 *
 * @author Adam Tazul - 2274640 - SimPilotAdamT
 * @since 2022-12-10T03:00:00Z
 */
class Product {
	/** The name of the product. */
	private String name;

	/** The number of items in stock for this product. */
	private int stockLevel;

	/** The price of each item for this product. */
	private double price;

	/**
	 * Constructs a new Product with the given name, stock level, and price.
	 *
	 * @param name the name of the product
	 * @param stockLevel the initial stock level for the product
	 * @param price the price of each item for this product
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public Product(String name, int stockLevel, double price) {
		this.name = name;
		this.stockLevel = stockLevel;
		this.price = price;
	}

	/**
	 * Returns the name of the product.
	 *
	 * @return the name of the product
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public String getName() {return this.name;}

	/**
	 * Sets the name of the product.
	 *
	 * @param name the new name of the product
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public void setName(String name) {this.name = name;}

	/**
	 * Returns the current stock level for the product.
	 *
	 * @return the current stock level for the product
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public int getStockLevel() {return this.stockLevel;}

	/**
	 * Sets the stock level for the product.
	 *
	 * @param stockLevel the new stock level for the product
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public void setStockLevel(int stockLevel) {this.stockLevel = stockLevel;}

	/**
	 * Returns the price of each item for this product.
	 *
	 * @return the price of each item for this product
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public double getPrice() {return this.price;}

	/**
	 * Sets the price of each item for this product.
	 *
	 * @param price the new price of each item for this product
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public void setPrice(double price) {this.price = price;}

	/**
	 * Adds the given number of items to the stock level for this product.
	 *
	 * @param newItems the number of items to add to the stock level
	 * @return the total cost of buying the new items
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public double buyStock(int newItems) {
		this.stockLevel += newItems;
		return newItems * this.price;
	}

	/**
	 * Subtracts the given number of items from the stock level for this product.
	 *
	 * @param soldItems the number of items to add to the stock level
	 * @return the total income from selling the sold items
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public double sellStock(int soldItems) {
		this.stockLevel -= soldItems;
		return soldItems * this.price;
	}

	/**
	 * Tries to sell the given number of items from the stock for this product.
	 *
	 * @param itemsSold the number of items to sell
	 * @return true if the sale was successful, false if there were not enough items in stock
	 * @author Adam Tazul - 2274640 - SimPilotAdamT
	 * @since 2022-12-10T03:00:00Z
	 */
	public boolean sell(int itemsSold) {
		if (itemsSold > this.stockLevel) return false;
		else {
			this.stockLevel -= itemsSold;
			return true;
		}
	}
}
