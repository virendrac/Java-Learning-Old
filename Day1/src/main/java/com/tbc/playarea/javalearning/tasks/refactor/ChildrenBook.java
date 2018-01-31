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
public class ChildrenBook extends Book implements Serializable  {

	private static final long serialVersionUID = -734879258402115788L;


	private int bookCategory = 3;

	public ChildrenBook(final String title,  final Date releaseDate ) {
		super();
		this.setTitle( title);
		this.setReleaseDate(releaseDate);
	}

	public ChildrenBook(final String title) {
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

		thisAmount += 1.5;
		if (daysRented > 3)
			thisAmount += (daysRented - 3) * 2;

		return thisAmount;
	}
}
