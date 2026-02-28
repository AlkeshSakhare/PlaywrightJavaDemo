package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_13_BrowserWindowHandle {

  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      LaunchOptions launchOptions = new LaunchOptions();
      launchOptions.setHeadless(false);
      launchOptions.setChannel("msedge");
      Browser browser = playwright.chromium().launch(launchOptions);
      BrowserContext bctx = browser.newContext();
      Page page = bctx.newPage();
      page.navigate("https://the-internet.herokuapp.com/windows");
      Thread.sleep(3000);
      Page newTab = page.waitForPopup(() -> {
        page.click("a:text('Click Here')");

      });
      newTab.waitForLoadState();
      System.out.println("Child Title: " + newTab.title());
      System.out.println("Child Url: " + newTab.url());
      Thread.sleep(3000);
      newTab.close();
      Thread.sleep(3000);
      System.out.println("Parent Title: " + page.title());
      System.out.println("Parent Url: " + page.url());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
