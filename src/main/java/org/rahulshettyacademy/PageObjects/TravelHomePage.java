package org.rahulshettyacademy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;
import org.rahulshettyacademy.AbstractComponents.StrategyFactor;
import org.rahulshettyacademy.PageComponents.FooterNav;
import org.rahulshettyacademy.PageComponents.NavigationBar;

import java.util.HashMap;

public class TravelHomePage {
    WebDriver driver;
    By selectionElement =By.id("traveller-home");
    //this is for header element
    By footerNavSectionElement = By.id("buttons");
    //created object for the interface
    SearchFlightAvail searchFlightAvail;


    public TravelHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }


    public NavigationBar getNavigationBar()
    {

        return new NavigationBar(driver,footerNavSectionElement);
    }

    public FooterNav getFooterNav()
    {
        return new FooterNav(driver, selectionElement);

    }
    //here the return type is interface-SearchFlightAvail searchFlightAvail
    //here we are using interface return type
    //here we are using the strategy design pattern
    //if we use the return type as multitrip trip, then it will throw an error for Roundtrip. So, we have used interface
    /*public void setBookingStrategy(SearchFlightAvail searchFlightAvail)
    {
        this.searchFlightAvail=searchFlightAvail;
    }*/

    public void setBookingStrategy(String strategyType)
    {
        StrategyFactor StrategyFactor=new StrategyFactor(driver);
        searchFlightAvail   =StrategyFactor.createStrategy(strategyType);
        this.searchFlightAvail=searchFlightAvail;
    }



     public void checkAvail(HashMap<String,String> reservationDetails)
     {
         searchFlightAvail.checkAvail(reservationDetails );
     }
     public String getTitle()
     {
         return driver.getTitle();
     }

}
