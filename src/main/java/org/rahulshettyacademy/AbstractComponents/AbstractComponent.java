package org.rahulshettyacademy.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

//driver.findlement-=it will cover the enter page,  we have to use sectionelement.findelement=it will only cover the footer element
//we will create customized findelement, it will identity the section fo the page. on that section, it will do findelement
//for that we have create a class abstract component.
public abstract class AbstractComponent {
    WebElement selectionElement;
    WebDriver driver;

    public AbstractComponent(WebDriver driver, By selectionElement) {
        this.selectionElement=driver.findElement(selectionElement);
        this.driver=driver;
    }

    public WebElement findElement(By findElementBy)
    {
        return selectionElement.findElement(findElementBy);
    }

    public List<WebElement> findElements(By findElementBy)
    {
        return selectionElement.findElements(findElementBy);
    }
    public void waitForElementToDisapper(By findBy)
    {
        //as the scope is within the method, so we have mentioned webdriver driver in the global variables
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }
}
