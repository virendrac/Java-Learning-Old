package com.tbc.playarea.javalearning.tasks.refactor.service;

import com.tbc.playarea.javalearning.tasks.refactor.Rental;

import java.util.Iterator;
import java.util.ListIterator;

public class StatementService {

    public String fetchStatement(ListIterator<Rental> rentalsItr , String name) {

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

        while (rentalsItr.hasNext()) {
            double thisAmount = 0;
            Rental rental = (Rental) rentalsItr.next();

            thisAmount=rental.getRentAmount();

            // add frequent renter points
            frequentRenterPoints+=rental.getFrequentRentalPoints();

            // show figures for this rental
            result.append("\t").append(rental.getBook().getTitle()).append("\t").append(String.valueOf(thisAmount))
                    .append("\n");
            totalAmount += thisAmount;
        }

        result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");


        return result.toString();
    }
}
