package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_14_BrowserNewBlankTabHandle {

  public static void main(String[] args) {

    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
      BrowserContext browserContext = browser.newContext();
      Page page = browserContext.newPage();
      page.navigate("https://the-internet.herokuapp.com/");
      Thread.sleep(3000);
      Page newTab = page.waitForPopup(() -> {
        page.click("a[target='_blank']");
      });
      newTab.waitForLoadState();
      newTab.navigate("https://the-internet.herokuapp.com/entry_ad");
      Thread.sleep(3000);
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
