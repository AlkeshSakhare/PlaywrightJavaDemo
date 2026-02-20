package com.basics;

import com.cons.Constant;

public class Tut_5_Const {

  public static void main(String[] args) {
    Constant.openBrowser("msedge", "https://google.com");
    Constant.closeBrowser();
    Constant.openBrowser("chromium", "https://www.w3schools.com/");
    Constant.closeBrowser();
    Constant.openBrowser("firefox", "https://www.selenium.dev/");
    Constant.closeBrowser();
    Constant.openBrowser("webkit", "https://playwright.dev/");
    Constant.closeBrowser();
  }
}
