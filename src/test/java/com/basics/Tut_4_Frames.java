package com.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_4_Frames {

  public static void main(String[] args) {

    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium()
          .launch(new LaunchOptions().setHeadless(false).setChannel("msedge"));
      Page page = browser.newPage();
      page.navigate("https://the-internet.herokuapp.com/iframe");
      Locator closeBtn = page.locator("[aria-label='Close']");
      if (closeBtn.isVisible()) {
        closeBtn.click();
      }
      String content = page.frameLocator("#mce_0_ifr").locator("#tinymce p").textContent();
      System.out.println("Content: " + content);
      browser.close();
    }
  }

}
