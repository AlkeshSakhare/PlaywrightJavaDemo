package com.cons;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Constant {

  public static Playwright playwright;
  public static Browser browser;
  public static BrowserContext context;
  public static Page page;
  public static String browserName;
  public static String url;
  public static boolean headless = false;

  public static void openBrowser(String browserName, String url) {
    playwright = Playwright.create();
    LaunchOptions options = new LaunchOptions();
    options.setHeadless(headless);
    options.setChannel(browserName);
    switch (browserName.toLowerCase()) {
      case "chrome":
      case "chromium":
      case "msedge":
        browser = playwright.chromium().launch(options);
        break;
      case "firefox":
        browser = playwright.firefox().launch(
            new LaunchOptions().setHeadless(headless));
        break;
      case "webkit":
        browser = playwright.webkit().launch(
            new LaunchOptions().setHeadless(headless));
        break;
      default:
        throw new RuntimeException("Invalid browser name");
    }
    context = browser.newContext();
    page = context.newPage();
    System.out.println("browser : " + browserName);
    System.out.println("Opening url: " + url);
    page.navigate(url);
    System.out.println("Title: " + page.title());
  }

  public static void closeBrowser() {
    browser.close();
    context.close();
    playwright.close();
  }

  public static void main(String[] args) {
    readProp();
    openBrowser(browserName, url);
  }

  public static void readProp() {
    Properties properties = new Properties();
    try {
      properties.load(new FileReader("./src/test/resources/config.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    browserName = properties.getProperty("browserName");
    url = properties.getProperty("url");
    headless = Boolean.parseBoolean(properties.getProperty("headless"));
  }

  public static void readProp(String browserName) {
    readProp();
    Constant.browserName = browserName;
    openBrowser(browserName, url);
  }

}
