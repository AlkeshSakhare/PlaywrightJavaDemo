package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserContext.StorageStateOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

public class Tut_6_AutoLogin {

  public static void main(String[] args)  throws InterruptedException{

    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
      BrowserContext bctx = browser.newContext();
      Page page = bctx.newPage();
      page.navigate("https://classic.crmpro.com/login.cfm");
      page.fill("[name='username']", "aabb1122");
      page.fill("[name='password']", "aabb1122");
      page.click("[value='Login']");
      bctx.storageState(new StorageStateOptions().setPath(Paths.get("crmpro.json")));Thread.sleep(3000);
      playwright.close();
    }
  }

}
