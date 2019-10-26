package com.chapter1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

  private Customer customer;
  private Movie django;
  private Movie madMax;
  private Movie spiderMan;
  private Movie homeAlone;
  private Movie titanic;
  private Movie godfather;

  private static final String resultTemplateHeader = "Rental Record for %s\n";
  private static final String resultTemplateMovie = "\t%s\t%.1f\n";
  private static final String resultTemplateFooter = "Amount owed is %.1f\nYou earned %d frequent renter points";

  @Before
  public void setUp() {
    this.customer = new Customer("Ram");
    this.django = new Movie("Django Unchanged", Movie.NEW_RELEASE);
    this.madMax = new Movie("Mad Max", Movie.NEW_RELEASE);
    this.spiderMan = new Movie("SpiderMan", Movie.CHILDREN);
    this.homeAlone = new Movie("homeAlone", Movie.CHILDREN);
    this.titanic = new Movie("Titanic", Movie.REGULAR);
    this.godfather = new Movie("God Father", Movie.REGULAR);
  }

  @Test
  public void statementForNewRelease1DaysRental() {
    this.customer.addRental(new Rental(django, 1));

    Assert.assertEquals("New Release 1 Days Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateFooter, this.customer.getName(), django.getTitle(), 3.0f, 3.0f, 1),
            this.customer.statement());
  }

  @Test
  public void statementForNewReleaseForMoreThan1DaysRental() {
    this.customer.addRental(new Rental(django, 3));

    Assert.assertEquals("New Release 3 Days Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateFooter, this.customer.getName(), django.getTitle(), 9.0f, 9.0f, 2),
            this.customer.statement());
  }

  @Test
  public void statementForNewReleases() {
    this.customer.addRental(new Rental(django, 1));
    this.customer.addRental(new Rental(madMax, 3));

    Assert.assertEquals("New Release multiple Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateMovie + resultTemplateFooter,
                    this.customer.getName(), django.getTitle(), 3.0f, madMax.getTitle(), 9.0f, 12.0f, 3),
            this.customer.statement());
  }

  @Test
  public void statementForChildrenLessThenEqualTo3DaysRental() {
    this.customer.addRental(new Rental(spiderMan, 3));

    Assert.assertEquals("Children Less than equal to 3 Days Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateFooter,
                    this.customer.getName(), spiderMan.getTitle(), 1.5f, 1.5f, 1),
            this.customer.statement());
  }

  @Test
  public void statementForChildrenForMoreThan3DaysRental() {
    this.customer.addRental(new Rental(spiderMan, 5));

    Assert.assertEquals("Children more than 3 Days Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateFooter,
                    this.customer.getName(), spiderMan.getTitle(), 4.5f, 4.5f, 1),
            this.customer.statement());
  }

  @Test
  public void statementForChildrenReleases() {
    this.customer.addRental(new Rental(spiderMan, 2));
    this.customer.addRental(new Rental(homeAlone, 5));

    Assert.assertEquals("Children release multiple Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateMovie + resultTemplateFooter,
                    this.customer.getName(), spiderMan.getTitle(), 1.5f, homeAlone.getTitle(), 4.5f, 6.0f, 2),
            this.customer.statement());
  }

  @Test
  public void statementForRegularLessThenEqualTo2DaysRental() {
    this.customer.addRental(new Rental(titanic, 2));

    Assert.assertEquals("Regular Less than equal to 2 Days Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateFooter,
                    this.customer.getName(), titanic.getTitle(), 2.0f, 2.0f, 1),
            this.customer.statement());
  }

  @Test
  public void statementForRegularForMoreThan2DaysRental() {
    this.customer.addRental(new Rental(titanic, 4));

    Assert.assertEquals("General more than 2 Days Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateFooter,
                    this.customer.getName(), titanic.getTitle(), 5.0f, 5.0f, 1),
            this.customer.statement());
  }

  @Test
  public void statementForGeneralReleases() {
    this.customer.addRental(new Rental(titanic, 1));
    this.customer.addRental(new Rental(godfather, 4));

    Assert.assertEquals("General release multiple Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateMovie + resultTemplateFooter,
                    this.customer.getName(), titanic.getTitle(), 2.0f, godfather.getTitle(), 5.0f, 7.0f, 2),
            this.customer.statement());
  }

  @Test
  public void statementForMultipleCategoryReleases() {
    this.customer.addRental(new Rental(titanic, 1));
    this.customer.addRental(new Rental(spiderMan, 2));
    this.customer.addRental(new Rental(madMax, 3));

    Assert.assertEquals("Multiple Category multiple Rental",
            String.format(resultTemplateHeader + resultTemplateMovie + resultTemplateMovie + resultTemplateMovie + resultTemplateFooter,
                    this.customer.getName(), titanic.getTitle(), 2.0f, spiderMan.getTitle(), 1.5f, madMax.getTitle(), 9.0f, 12.5f, 4),
            this.customer.statement());
  }

}