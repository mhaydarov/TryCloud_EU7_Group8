package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TalkModulePage extends BasePage{
  @FindBy(xpath= "//*[@id=\"appmenu\"]/li[5]/a")
 public WebElement talkModule;

  @FindBy(xpath = "//button[@aria-label='Create a new group conversation']")
    public WebElement createConv;

  @FindBy(css = "input.conversation-name")
    public WebElement convName;

  @FindBy(xpath = "//*[@id=\"body-user\"]/div[6]/div[2]/div/div/div[2]/button")
    public WebElement addParticipants;

  @FindBy(xpath = "//*[@id=\"body-user\"]/div[6]/div[2]/div/div/div[1]/div/div[2]/div[1]/ul/li[2]/div[2]/div/span")
    public WebElement Employee1;

    @FindBy(xpath = "//*[@id=\"body-user\"]/div[6]/div[2]/div/div/div[1]/div/div[3]/div[1]/ul/li[4]/div[2]/div/span")
    public WebElement Employee100;

    @FindBy(tagName = "//span[text()='Employee103']")
    public WebElement Employee103;

    @FindBy(tagName = "//span[text()='Hello22 (Public circle, Dakota)']")
    public WebElement circle1;
    @FindBy (xpath = "//*[@id=\"body-user\"]/div[6]/div[2]/div/div/div[2]/button[2]")
    public WebElement createConverastion;

    @FindBy(xpath = "//*[@id=\"conversation_74qep6o8\"]/div[2]/div[1]/span[1]")
    public WebElement convBOX;




}
