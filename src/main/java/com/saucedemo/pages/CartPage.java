package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.saucedemo.utils.Log;
import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartItems = By.cssSelector(".cart_item");
    private By checkoutButton = By.id("checkout");
    private By removeButton = By.cssSelector(".btn_secondary");
    private By cartQuantity = By.cssSelector(".cart_quantity");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int getNumberOfItems() {
        return driver.findElements(cartItems).size();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
        Log.info("Checkout button clicked.");
    }

    public void removeFirstItem() {
        driver.findElements(removeButton).get(0).click();
        Log.info("First item removed.");
    }

    public String getItemQuantity(int index) {
        return driver.findElements(cartQuantity).get(index).getText();
    }
}