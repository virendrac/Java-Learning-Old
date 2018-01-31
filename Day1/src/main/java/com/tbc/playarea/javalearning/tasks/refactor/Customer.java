/**
 * 
 */
package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.tbc.playarea.javalearning.tasks.refactor.service.*;

/**
 * Customer class that denotes customer details as well as customer related
 * operations.
 * 
 * @author chandrashekarv
 *
 */
public class Customer implements Serializable {

	private static final long serialVersionUID = 851426779607326255L;

	private long id;
	private String name;

	private StatementService service = new StatementService();

	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		super();
		this.name = name;
	}

	public String fetchStatement() {

		return service.fetchStatement(rentals.listIterator(),getName());

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Rental> getRentals() {
		return rentals;
	}

	public void addRental(final Rental rental) {
		getRentals().add(rental);
	}

}
