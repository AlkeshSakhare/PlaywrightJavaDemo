package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tut_9_FileUpload {

  public static void main(String[] args) throws InterruptedException {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    page.navigate(
        "C:\\Users\\Alkesh\\eclipse-workspace\\PlaywrightDemo\\src\\test\\resources\\fileUpload.html");
    page.setInputFiles("#file-upload", Paths.get("./src/test/resources/test-upload.txt"));
    Thread.sleep(4000);
    //to deselect file
    page.setInputFiles("#file-upload", new Path[0]);Thread.sleep(3000);
    playwright.close();
  }
}
