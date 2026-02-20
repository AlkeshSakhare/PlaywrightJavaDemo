package com.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_1_Launch {


  public static void main(String[] args) {
    String url = "https://amazon.com";
    Playwright playwright = Playwright.create();
    LaunchOptions launchOptions = new LaunchOptions();
    launchOptions.setChannel("msedge");
    launchOptions.setHeadless(false);

    Browser browser = playwright.chromium().launch(launchOptions);
    Page page = browser.newPage();
    page.navigate(url);
    /* WAITS UNTIL NETWORK ACTIVITY SETTLES */
    //  page.waitForLoadState(LoadState.NETWORKIDLE);
    String title = page.title();
    System.out.println("Title is :" + title);
    String curentUrl = page.url();
    System.out.println("Page URL is :" + curentUrl);

    browser.close();
    playwright.close();
  }

}
