package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

public class FooterNav extends AbstractComponent {
    By flights = By.cssSelector("[title='Flights']");
    By links=By.cssSelector("a");

    public FooterNav(WebDriver driver, By selectionElement) {
        super(driver,selectionElement); //when you inherit parent class-you should invoke parent class constructor in your own child class constructor
    }

    //methods to handle the flights
    //when selenium executes any of the methods in this class-scope of selenium
    //should be on the footer only

    public String getFlightAttribute()
    {
        return findElement(flights).getAttribute("class");
    }
    public int getLinkCount()
    {
        return findElements(links).size();
    }


}
