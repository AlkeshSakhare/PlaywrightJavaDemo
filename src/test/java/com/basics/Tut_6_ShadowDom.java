package com.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_6_ShadowDom {

  public static void main(String[] args) {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium()
        .launch(new LaunchOptions().setChannel("msedge").setHeadless(false));

    Page page = browser.newPage();
    page.navigate("edge://downloads/");
    page.locator("fluent-text-input input#control").fill("edgeDownload");

  }

}
