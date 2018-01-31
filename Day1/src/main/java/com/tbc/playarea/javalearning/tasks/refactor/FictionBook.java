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
public class FictionBook extends Book implements Serializable  {

	private static final long serialVersionUID = -73487925840725788L;


	private int bookCategory = 1;
	//
	public FictionBook(final String title, final Date releaseDate ) {
		super();
		this.setTitle( title);
		this.setReleaseDate(releaseDate);
	}

	public FictionBook(final String title) {
		super();
		this.setTitle( title);
	}

	public int getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(int bookCategory) {
		this.bookCategory = bookCategory;
	}

	public double getCalculatedRent(int daysRented ) {
		double thisAmount=0;

		thisAmount += 2;
			if (daysRented > 2)
				thisAmount += (daysRented - 2) * 1.5;

		return thisAmount;
	}
}
