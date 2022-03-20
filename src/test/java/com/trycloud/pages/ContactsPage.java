package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import com.trycloud.utilities.WebUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactsPage extends BasePage{


   @FindBy(xpath  ="//input[@id='contact-fullname']")
   public WebElement contactFullName;



   @FindBy(xpath = "//button[@id='new-contact-button']")
   public WebElement newContactButton;


   @FindBy(xpath = "//input[@inputmode='email']")
   public WebElement emailBox;


   @FindBy(xpath = "//div[@class='header-right']/*[1]//*/*")
   public WebElement searchButton;


   @FindBy(xpath = "//input[@type='search']")
   public WebElement searchBox;


   @FindBy(xpath = "//h2[@class='empty-content__title']")
   public  WebElement deleteMessage;

   @FindBy(xpath = "//h3//*[1]/*[1]")
   public  WebElement newContact;


   public  void selectContact(String name ) {
      searchButton.click();
      searchBox.sendKeys(name);
      WebUtilities.waitFor(3);
      WebElement selectedName=Driver.get().findElement(By.xpath("//h3[@title='" + name + "'][1]"));
      selectedName.click();


   }


   @FindBy(xpath = "//div[@class='contact-header__actions']")
   public  WebElement actionMenu;


   @FindBy(xpath = "(//*[text()='Delete'])[5]")
   public WebElement deleteButton;


   @FindBy(xpath = "//li[@id='everyone']/*[2]/*[1]")
   public  WebElement allContactsNumber;



   @FindBy(xpath = "//*[@title='+ New group']")
   public  WebElement newGroupButton;

   public void clickNewGroup(){
      WebUtilities.waitFor(2);
      newGroupButton.click();
   }


   @FindBy(xpath = "//input[@class='action-input__input focusable']")
   public WebElement newGroupBox;


   @FindBy(xpath = "//label[@class='action-input__label']")
   public WebElement newGroupArrow;

   public void clickArrow(){
      newGroupArrow.click();
   }


public void clickThreeDots(){
   actionMenu.click();
}

public void clickDeleteButton(){
   WebUtilities.waitForClickablility(deleteButton,10);
   deleteButton.click();
}

public void dashboardPageAssert(){
   WebUtilities.waitFor(2);
   String currentUrl= Driver.get().getCurrentUrl();
   Assert.assertTrue("Verify that user is on dashboard page",currentUrl.contains("dashboard"));

}

public void contactsModuleClick(){
   DashboardPage dashboardPage=new DashboardPage();

   WebUtilities.waitForClickablility(dashboardPage.contactsModule,3);

   dashboardPage.contactsModule.click();
}

public void contactsTitleAssert(){
   String actualTitle=Driver.get().getTitle();

   String expectedTitle="Contacts - Trycloud QA";

   Assert.assertEquals(expectedTitle,actualTitle);

}
public void newContactButtonClick(){
   WebUtilities.waitFor(3);
   new ContactsPage().newContactButton.click();
   WebUtilities.waitFor(3);
}

public void contactDetailsOpen(){

   WebUtilities.waitFor(3);

   String actualResult=contactFullName.getAttribute("value");

   String expectedResult="New contact";

   Assert.assertEquals(expectedResult,actualResult);
}


public  void enterContactDetails(){
   contactFullName.clear();
   WebUtilities.waitFor(3);
   contactFullName.sendKeys("Aysoltan");

   emailBox.sendKeys("nana@example.com");
}

public  void assertNewContactCreated(){
   searchButton.click();
   searchBox.sendKeys("Aysoltan");

   WebUtilities.waitFor(3);

   String actualContact=newContact.getText();
   String expectedContact="Aysoltan";
   Assert.assertEquals(expectedContact,actualContact);
}


public void selectedContactDetails() {
   WebUtilities.waitFor(3);

   String actualName =contactFullName.getAttribute("value");
   String expectedName = "Aysoltan";
   Assert.assertEquals(expectedName, actualName);
}


public  void setDeleteMessage(){
   WebUtilities.waitFor(2);
   deleteMessage.getText();

   String expectedDeleteMessage=deleteMessage.getText();
   String actualDeleteMessage="No contact selected";

   Assert.assertEquals(expectedDeleteMessage,actualDeleteMessage);
}
}

