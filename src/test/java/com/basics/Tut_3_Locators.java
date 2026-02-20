package com.basics;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.util.List;
import java.util.stream.Collectors;

public class Tut_3_Locators {

  public static void main(String[] args) {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    page.navigate("https://www.orangehrm.com/en/contact-sales");
    Locator countryOptions = page.locator("#Form_getForm_Country option");

    System.out.println("Country Count: " + (countryOptions.count() - 1));

    for (int i = 1; i < countryOptions.count(); i++) {
      System.out.println(
          "Country No: " + i + " " + countryOptions.nth(i).textContent().trim());

    }

    List<String> countryList = countryOptions.allTextContents();
    countryList = countryList.stream().map(s -> s.trim()).collect(Collectors.toList());
    System.out.println("CountryList:" + countryList);

    page.close();
    browser.close();
    playwright.close();
    
  }

}
