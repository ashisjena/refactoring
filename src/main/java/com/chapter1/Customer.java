package com.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals;

  public Customer(String name) {
    this.name = name;
    this.rentals = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void addRental(Rental rental) {
    this.rentals.add(rental);
  }

  // Now Statement is loosely coupled with calculation logic. We can add a other flavour of statement in future ex. html / pdf etc.
  public String statement() {
    String result = "Rental Record for " + this.getName() + "\n";

    for (Rental each : this.rentals) {
      result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
    }

    result += "Amount owed is " + this.getTotalCharge() + "\n";
    result += "You earned " + this.getTotalFrequentRenterPoints() + " frequent renter points";
    return result;
  }

  private int getTotalFrequentRenterPoints() {
    int frequentRenterPoints = 0;
    for (Rental rental : this.rentals) {
      frequentRenterPoints += rental.getFrequentRenterPoints();
    }
    return frequentRenterPoints;
  }

  private double getTotalCharge() {
    double totalAmount = 0;
    for (Rental rental : this.rentals) {
      totalAmount += rental.getCharge();
    }
    return totalAmount;
  }
}
