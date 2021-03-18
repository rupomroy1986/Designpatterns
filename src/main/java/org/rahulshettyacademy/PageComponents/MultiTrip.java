package org.rahulshettyacademy.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.AbstractComponents.AbstractComponent;
import org.rahulshettyacademy.AbstractComponents.SearchFlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit = By.id("ctl00_mainContent_btn_FindFlights");
    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By destination_2= By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By modalPopUp = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By selectionElement) {
        super(driver, selectionElement);
    }
     //execute round design pattern

    /*public void checkAvail(String origin, String destination) {

        //execute design pattern
        //here we are passing the value as run time like s->selectOriginCity(origin)
        makeStateReady(s->selectOriginCity(origin));
        makeStateReady(s->selectDestinationCity(destination));
        //strategy design pattern
        //selectOriginCity(origin);
        //selectDestinationCity(destination);
        selectDestinationCity2("BLR");
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
    public void selectDestinationCity2(String destination2)
    {
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        //write pre-requities common code and then execute actual functions(any functions)-Book/calendar
        //this refers to the current class instance
        //accept refers to ant methods in the class
        //this refers to the current class instance
        System.out.println("I am inside multi trip");
        findElement(multiCity_rdo).click();
        findElement(modalPopUp).click();
        waitForElementToDisapper(modalPopUp);
        consumer.accept(this);
        System.out.println("am done");
    }


    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        //execute design pattern
        //here we are passing the value as run time like s->selectOriginCity(origin)
        //as he have hardcoded destination2, as we have to break the contract, to overcome this we have used hashMap
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        makeStateReady(s->selectDestinationCity(reservationDetails.get("destination")));
        selectDestinationCity2(reservationDetails.get("destination2"));

        //strategy design pattern
        //selectOriginCity(origin);
        //selectDestinationCity(destination);


    }
}
