package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_8_JSPopUpHandle_2 {

  public static void main(String[] args) throws InterruptedException {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(
          new LaunchOptions().setHeadless(false)
      );

      Page page = browser.newPage();

      // Register dialog handler (handles ALL dialogs)
      page.onDialog(dialog -> {
        System.out.println("Dialog message: " + dialog.message());
        System.out.println("Dialog type: " + dialog.type());

        switch (dialog.type()) {
          case "alert":
            dialog.accept();
            break;

          case "confirm":
            dialog.accept(); // or dialog.dismiss();
            break;

          case "prompt":
            dialog.accept("My Input Text");
            break;

          default:
            dialog.dismiss();
        }
      });

      page.navigate("https://the-internet.herokuapp.com/javascript_alerts");

      // Trigger actions that cause multiple dialogs
      page.click("//*[text()='Click for JS Alert']");
      page.click("//*[text()='Click for JS Confirm']");
      page.click("//*[text()='Click for JS Prompt']");Thread.sleep(3000);
      playwright.close();
    }
  }
}