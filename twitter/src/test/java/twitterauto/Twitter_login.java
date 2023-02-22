package twitterauto;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Twitter_login {
	WebDriver driver;
	
	@Test
	public void launch() throws AWTException, InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "H:\\Demoproject\\testng\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		String url ="https://twitter.com/i/flow/login";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter username or number
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.mouseMove(597, 373);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Enter the username here");
		
		
		//next button
		Thread.sleep(2000);

		driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[6]")).click();
		
		//password enter
		Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Enter the Password here");
        
        //login button
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();
    
        Thread.sleep(2000);
		robot.mouseMove(513,104);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		
		//Twitting
		driver.findElement(By.xpath("//div[@data-block='true']//div")).sendKeys("Enter the tweet here");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@role='button']//div[@dir='ltr']//span//span[contains(text(),'Tweet')]")).click();
        Thread.sleep(4000);            
        
        
        
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile , new File("H:\\Demoproject\\testng\\Screenshot\\screenshot.png"));

        
        //logout button inside login
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='Account menu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='logout")).click(); //allter the xpath accordingly as it is variable for each user with id
	
        //logout button
		Thread.sleep(2000);
        driver.findElement(By.xpath("//body//div//div[@role='alertdialog']//div//div//div[1]//div[1]")).click();
		 
		
	}


}
