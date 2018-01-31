package com.tbc.playarea.javalearning.tasks.refactor;

import java.util.Date;

public abstract class Book {

    private Date releaseDate;

    private long id;
    private String title;

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract int getBookCategory();

    public double getCalculatedRent(int daysRented) {
        double thisAmount=0;

        thisAmount += 2;
        if (daysRented > 2)
            thisAmount += (daysRented - 2) * 1.5;

        return thisAmount;
    }
}
