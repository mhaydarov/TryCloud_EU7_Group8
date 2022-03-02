package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends BasePage{




   @FindBy(xpath = "//button[@id='new-contact-button']")
   public WebElement newContactButton;

   @FindBy(xpath = "//input[@inputmode='email']")
   public WebElement emailBox;


   @FindBy(xpath = "//button[@aria-label='Actions'][1]")
   public  WebElement actionMenu;


   @FindBy(xpath = "//ul[starts-with(@id,'menu')]/*[3]")
   public  WebElement deleteMenu;
}
