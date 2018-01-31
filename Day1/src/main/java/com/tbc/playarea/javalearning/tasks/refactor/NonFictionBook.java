/**
 * 
 */
package com.tbc.playarea.javalearning.tasks.refactor;

import java.io.Serializable;
import java.util.Date;

/**
 * Movie : Simple data class representing movie data.
 * 
 * @author chandrashekarv
 *
 */
public class NonFictionBook extends Book implements Serializable {

	private static final long serialVersionUID = -73487925888L;


	private int bookCategory = 2;

	public NonFictionBook(final String title, final Date releaseDate ) {
		super();
		this.setTitle( title);
		this.setReleaseDate(releaseDate);
	}

	public NonFictionBook(final String title) {
		super();
		this.setTitle( title);
	}



	public int getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(int bookCategory) {
		this.bookCategory = bookCategory;
	}

	public double getCalculatedRent(int daysRented) {
		double thisAmount=0;

		thisAmount += daysRented * 3;

		return thisAmount;
	}
}
