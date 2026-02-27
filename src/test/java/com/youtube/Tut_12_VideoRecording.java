package com.youtube;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tut_12_VideoRecording {

  public static void main(String[] args) {

    try (Playwright playwright = Playwright.create()) {

      Browser browser = playwright.chromium()
          .launch(new LaunchOptions()
              .setHeadless(false));

      BrowserContext context = browser.newContext(
          new Browser.NewContextOptions()
              .setRecordVideoDir(Paths.get("./src/test/resources/videos/"))
              .setRecordVideoSize(1280, 720));

      Page page = context.newPage();

      page.navigate("https://the-internet.herokuapp.com/");
      page.click("text=Form Authentication");
      page.fill("#username", "tomsmith");
      page.fill("#password", "SuperSecretPassword!");
      page.click("[type='submit']");
      page.click("text=Logout");

      // ✅ Close context FIRST to finalize video
      context.close();

      // ✅ Get only this test’s video file
      Path videoPath = page.video().path();

      // ✅ Create timestamp
      String timestamp = LocalDateTime.now()
          .format(DateTimeFormatter.ofPattern("dd-MM-yyyy__hh-mm-ss_a"));

      // ✅ Create custom name
      Path newPath = Paths.get("./src/test/resources/videos/LoginTest_" + timestamp + ".webm");

      // ✅ Rename only this file
      Files.move(videoPath, newPath, StandardCopyOption.REPLACE_EXISTING);

      System.out.println("Video saved as: " + newPath);

      browser.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}