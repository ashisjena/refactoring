package com.chapter1;

public class Rental {
  private Movie movie;
  private int daysRented;

  public Rental(Movie movie, int daysRented) {
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public void setDaysRented(int daysRented) {
    this.daysRented = daysRented;
  }

  public double getCharge() {
    return this.getMovie().getCharge(this.daysRented);
  }

  public int getFrequentRenterPoints() {
    return this.getMovie().getFrequentRenterPoints(this.daysRented);
  }
}
