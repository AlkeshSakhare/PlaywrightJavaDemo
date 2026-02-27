package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.awt.Dimension;
import java.awt.Toolkit;

public class Tut_11_MaxWindow {

  public static void main(String[] args) throws InterruptedException {
    String url = "https://the-internet.herokuapp.com";
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) dimension.getWidth();
    int height = (int) dimension.getHeight();
    System.out.println("Width X Height = " + width + " X " + height);
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    BrowserContext browserContext = browser.newContext(
        new NewContextOptions().setViewportSize(width, height));
    Page page = browserContext.newPage();
    page.navigate(url);
    Thread.sleep(3000);
    playwright.close();
  }
}
