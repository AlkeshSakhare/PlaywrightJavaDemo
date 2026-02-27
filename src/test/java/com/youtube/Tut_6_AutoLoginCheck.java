package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

public class Tut_6_AutoLoginCheck {

  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
      BrowserContext bctx = browser.newContext(
          new NewContextOptions().setStorageStatePath(Paths.get("crmpro.json")));
      Page page = bctx.newPage();
      page.navigate("https://classic.crmpro.com/login.cfm");
      page.fill("[name='promotion_code']", "this is promotion_code");
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
