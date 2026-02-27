package com.youtube;

import static com.cons.Constant.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Tut_7_JSPopUpHandle {

  public static Page page;
  public static String resultText;

  public static void main(String[] args)  throws InterruptedException{

    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    page = browser.newPage();
    page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
//    alert();
//    confirm();
    prompt();
    playwright.close();
  }

  public static void alert() throws InterruptedException {
    page.onDialog(dialog -> {
      String alertMsg = dialog.message(); // capture alert message
      System.out.println("alertMsg: " + alertMsg);
      dialog.accept();
    });

    page.click("//*[text()='Click for JS Alert']");
    String resultText = page.textContent("#result");
    System.out.println("resultText: " + resultText);Thread.sleep(3000);

  }

  public static void confirm() {
    page.onDialog(dialogC -> {
      String alertMsg = dialogC.message();
      System.out.println("alertMsg: " + alertMsg);
      dialogC.dismiss(); // to click on Cancel JS confirm box
      // dialog.accept(); // to click on OK JS confirm box / prompt
    });
    page.click("//*[text()='Click for JS Confirm']");
    resultText = page.textContent("#result");
    System.out.println("resultText: " + resultText);
  }

  public static void prompt() {
    page.onDialog(dialogP -> {
      String alertMsg = dialogP.message();
      System.out.println("alertMsg: " + alertMsg);
      // dialog.dismiss(); // to click on Cancel JS confirm box
      // dialog.accept(); // to click on OK JS confirm box / prompt
      dialogP.accept("Accepting Prompt"); // to click on OK JS confirm box
    });
    page.click("//*[text()='Click for JS Prompt']");
    resultText = page.textContent("#result");
    System.out.println("resultText: " + resultText);
  }
}
