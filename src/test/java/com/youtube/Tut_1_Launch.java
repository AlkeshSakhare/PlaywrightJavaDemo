package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_1_Launch {

  public static void main(String[] args) {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    page.navigate("https://google.com");
    System.out.println(page.title());
    page.close();
    browser.close();
    playwright.close();
  }

}
