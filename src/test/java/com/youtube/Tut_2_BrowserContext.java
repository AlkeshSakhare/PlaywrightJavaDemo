package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_2_BrowserContext {

  public static void main(String[] args) throws InterruptedException {

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    BrowserContext bcontx1 = browser.newContext();
    Page page1 = bcontx1.newPage();
    page1.navigate("https://www.w3schools.com/");
    System.out.println(page1.title());

    BrowserContext bcontx2 = browser.newContext();
    Page page2 = bcontx2.newPage();
    page2.navigate("https://practicetestautomation.com/practice-test-login/");
    System.out.println(page2.title());

    page1.close();
    bcontx1.close();

    page2.close();
    bcontx2.close();Thread.sleep(3000);
    playwright.close();
  }
}
