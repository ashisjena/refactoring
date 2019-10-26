package com.chapter1;

public class Movie {
  public static final int CHILDREN = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;

  private String title;
  private Price price;

  public Movie(String title, int priceCode) {
    this.title = title;
    setPriceCode(priceCode);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Price getPrice() {
    return this.price;
  }

  public void setPriceCode(int priceCode) {
    switch (priceCode) {
      case REGULAR:
        this.price = new RegularPrice();
        break;
      case CHILDREN:
        this.price = new ChildrensPrice();
        break;
      case NEW_RELEASE:
        this.price = new NewReleasePrice();
        break;
      default:
        throw new IllegalArgumentException("Incorrect Price code");
    }
  }

  public double getCharge(int daysRented) {
    return this.price.getCharge(daysRented);
  }

  public int getFrequentRenterPoints(int daysRented) {
    return this.price.getFrequentRenterPoints(daysRented);
  }
}
