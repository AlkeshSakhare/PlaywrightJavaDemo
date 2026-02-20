package com.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_2_BrowserContext {

  public static void main(String[] args) {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));

    BrowserContext bctx1 = browser.newContext();
    Page page1 = bctx1.newPage();
    page1.navigate("https://testautomationpractice.blogspot.com/");
    System.out.println(page1.title());

    BrowserContext bctx2 = browser.newContext();
    Page page2 = bctx2.newPage();
    page2.navigate("https://practicetestautomation.com/practice-test-login/");
    System.out.println(page2.title());

    page1.close();
    bctx1.close();

    page2.close();
    bctx2.close();


  }
}
