package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_4_Shadowdom {

  public static void main(String[] args) throws InterruptedException {

    Playwright playwright = Playwright.create();

    Browser browser = playwright.chromium()
        .launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
    BrowserContext bctx = browser.newContext();
    Page page = bctx.newPage();
    page.navigate("chrome://downloads/");
    page.waitForLoadState();
    page.locator("#searchInput").fill("searchDownloadFile"); // this will also work
    page.locator("cr-toolbar-search-field #searchInput")
        .fill("searchDownloadFile"); // this will also work
    page.waitForLoadState();
    page.close();
    bctx.close();
    browser.close();
    Thread.sleep(3000);
    playwright.close();
  }
}
