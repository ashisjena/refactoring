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

  public String statement() {
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = "Rental Record for " + this.getName() + "\n";

    for (Rental each : this.rentals) {
      frequentRenterPoints += each.getFrequentRenterPoints();

      result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
      totalAmount += each.getCharge();
    }

    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentRenterPoints + " frequent renter points";
    return result;
  }
}
