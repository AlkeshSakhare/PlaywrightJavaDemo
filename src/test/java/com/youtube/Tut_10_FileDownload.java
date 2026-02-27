package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;

public class Tut_10_FileDownload {

  public static void main(String[] args) throws InterruptedException {
    Playwright playwright = Playwright.create();
    Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
    Page page = browser.newPage();
    page.navigate("https://the-internet.herokuapp.com/download");
    Download download = page.waitForDownload(() -> {
      page.click("a:text('test-upload.txt')");
    });

    System.out.println("download.suggestedFilename() : " + download.suggestedFilename());
    System.out.println("download.url() : " + download.url());
    //download file to a location
    System.out.println("Default download.path().toString(): " + download.path().toString());
    download.saveAs(Paths.get("./src/test/resources/" + download.suggestedFilename()));
    Thread.sleep(3000);
    playwright.close();
  }
}
