package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.PageObjects.TravelHomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest  extends BaseTest {
WebDriver driver;
    TravelHomePage  travelHomePage;

@BeforeTest
public void setUp()
{
    driver =initializeDriver();
    travelHomePage = new TravelHomePage(driver);
}


@Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationdetails)
    {

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());
        //check availability
        //strategy design patterns
        //travelHomePage.setBookingStrategy(new MultiTrip(driver,sectionElement));
        //factory design pattern
        travelHomePage.setBookingStrategy("multitrip");
        /*HashMap<String, String> reservationdetails=new HashMap<String,String>();
        reservationdetails.put("origin","MAA");
        reservationdetails.put("destination","HYD");
        reservationdetails.put("destination2","DEL");*/
        travelHomePage.checkAvail(reservationdetails);
    }
   //if you want to write the test cases with multiple sets of data, use dataproviders
    @DataProvider
    public Object [][]getData() throws IOException {
       //here we are putting the values in Hasmap and running the test with multiple sets of data
        /*HashMap<String, String> reservationdetails=new HashMap<String,String>();
        reservationdetails.put("origin","MAA");
        reservationdetails.put("destination","HYD");
        reservationdetails.put("destination2","DEL");

        HashMap<String, String> reservationdetails1=new HashMap<String,String>();
        reservationdetails1.put("origin","DEL");
        reservationdetails1.put("destination","HYD");
        reservationdetails1.put("destination2","MAA");
        List<HashMap<String,String>> l=new ArrayList();
        l.add(reservationdetails);
        l.add(reservationdetails1);*/


        List<HashMap<String, String>> l = getJsonPath(System.getProperty("user.dir") + "//src//test//java//org//rahulshettyacademy//reservationDetails.json");
        

        return new Object[][]
                {
                        //{reservationdetails},{reservationdetails1}
                        //as we are putting the hashmap in list, so we are using the below code
                        {l.get(0)},{l.get(1)}
                };
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }




}
