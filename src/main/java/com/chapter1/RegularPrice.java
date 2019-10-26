package com.chapter1;

public class RegularPrice extends Price {
  @Override
  public int getPriceCode() {
    return Movie.REGULAR;
  }

  @Override
  public double getCharge(int daysRented) {
    double result = 2.0;
    if (daysRented > 2) {
      result += (daysRented - 2) * 1.5;
    }
    return result;
  }
}
