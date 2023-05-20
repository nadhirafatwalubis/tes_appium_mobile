package tes_appium_mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class otomatisasi {
	
	static AppiumDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			connect();
			skipSignIn();
			createSet();
			Thread.sleep(1000);
			addCard();

		}catch(Exception exp) {
			System.out.println(exp.getCause());
			System.out.println(exp.getMessage());
			exp.printStackTrace();
		}

	}
	
	public static void connect() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Samsung A14");
        cap.setCapability("udid", "RR8RA01AXNH");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "13");
        
        cap.setCapability("appPackage", "flashcards.words.words");
        cap.setCapability("appActivity", "flashcards.words.words.ui.base.SplashActivity");
        
        
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        
        //membuat objek driver
        driver = new AppiumDriver<MobileElement>(url, cap);
        
        
        System.out.println("aplikasi dibuka..");
	}

	public static void skipSignIn() {
		//skip sign in
		driver.findElementById("flashcards.words.words:id/btnSkipSignIn").click();
	}
	
	public static void createSet() throws InterruptedException {
		//tap tombol 'create set'
		driver.findElementById("flashcards.words.words:id/createDeck").click();
		
		//jeda 1 detik
		Thread.sleep(1000);
		
		//isi nama set
		driver.findElementById("flashcards.words.words:id/deck_name").sendKeys("Buah-buahan");
		
		//klik tombol save
		driver.findElementById("flashcards.words.words:id/save").click();
	}
	
	public static void addCard() {
		//klik tombol add card
		driver.findElementById("flashcards.words.words:id/addCards").click();
		driver.findElementById("flashcards.words.words:id/addCards").click();
		
		//masukkan kata pada halaman dpn card
		driver.findElementById("flashcards.words.words:id/front_text").sendKeys("apel");
		
		//masukkan kata pada laman belakang card
		driver.findElementById("flashcards.words.words:id/back_side").sendKeys("berwarna merah, bulat, manis");
		
		//klik tombol save
		driver.findElementById("flashcards.words.words:id/save").click();
	}
}
