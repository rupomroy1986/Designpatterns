package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {
    //in place of writing driver.findelement, we are extending abstract ccomponenets
    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By cb = By.id("ctl00_mainContent_chk_IndArm");
    private By search =By.id("ctl00_mainContent_btn_FindFlights");
    private By to =By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");



    public RoundTrip(WebDriver driver, By selectionElement) {
        super(driver, selectionElement);
    }


    /*public void checkAvail(String origin, String destination) {
        //this is execute around design pattern
        System.out.println("I am inside round trip");
        makeStateReady(s->selectOriginCity(origin));
        //makeStateReady(s->selectDestinationCity(destination));
        //findElement(rdo).click();
        selectDestinationCity(destination);
        findElement(cb).click();
        findElement(search).click();
    }*/

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady(Consumer<RoundTrip> consumer)
    {
        //write pre-requities common code and then execute actual functions(any functions)-Book/calendar
        //this refers to the current class instance
        //accept refers to ant methods in the class
        //this refers to the current class instance
        System.out.println("I am inside round trip");
        findElement(rdo).click();
        consumer.accept(this);
        System.out.println("am done with round trip");
    }


    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        //this is execute around design pattern
        System.out.println("I am inside round trip");
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        //makeStateReady(s->selectDestinationCity(destination));
        //findElement(rdo).click();
       // selectDestinationCity(destination);
        findElement(cb).click();
        findElement(search).click();

    }
}