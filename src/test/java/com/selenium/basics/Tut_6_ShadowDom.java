package com.selenium.basics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Tut_6_ShadowDom {

  public static void main(String[] args) {

    WebDriver driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.get("edge://downloads/");
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    String script = "return document.querySelector('downloads-app').shadowRoot.querySelector('responsive-side-pane-layout').querySelector(\"div[slot='navigation-pane']\").querySelector('downloads-searchbox').shadowRoot.querySelector('fluent-text-input')";
    WebElement element = (WebElement) jse.executeScript(script);

    String enterTextScript = "arguments[0].setAttribute('value','edgeDownload')";
    jse.executeScript(enterTextScript, element);
    //
  }
}
