package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnlineStatusPage extends BasePage{

    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement setStatusButton;

    @FindBy(xpath = "//div[@class='set-status-modal__header'][1]")
    public WebElement onlineStatusHeader;

    @FindBy(xpath = "//div[@class='set-status-modal__header'][2]")
    public WebElement setStatusMessageHeader;







}
