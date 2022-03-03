package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlineStatusPage extends BasePage{

    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement setStatusButton;

    @FindBy(xpath = "//div[@class='set-status-modal__header'][1]")
    public WebElement onlineStatusHeader;

    @FindBy(xpath = "//div[@class='set-status-modal__header'][2]")
    public WebElement setStatusMessageHeader;

    @FindBy(xpath = "//form[@class='custom-input__form']//input")
    public WebElement setStatusMessageInputBox;

    @FindBy(xpath = "//span[@class='clear-at-select__label']")
    public WebElement clearStatusMessage;

    @FindBy(xpath = "//input[@class='multiselect__input']")
    public WebElement clearStatusDropDown;

    @FindBy(xpath = "//li[@class='multiselect__element']")
    public List<WebElement> clearStatusDropDownOptions;






}
