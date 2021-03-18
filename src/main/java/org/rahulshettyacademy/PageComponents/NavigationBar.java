package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent  {
    WebDriver driver;
    //common css selector for both header and footer
    By flights = By.cssSelector("[title='Flights']");
    By links=By.cssSelector("a");

    public NavigationBar(WebDriver driver, By selectionElement) {
        super(driver, selectionElement);
    }


    public String getFlightAttribute()
    {
        return findElement(flights).getAttribute("class");
    }
    public int getLinkCount()
    {
        return findElements(links).size();
    }

}
