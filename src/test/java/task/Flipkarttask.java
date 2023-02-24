package task;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkarttask {

	@Test
	public void flipkartTest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//div[@class='_2QfC02']//button[@class='_2KpZ6l _2doB4z']")).click();
		
		WebElement fashion = driver.findElement(By.xpath("//div[@class='eFQ30H']//a[.='Fashion']"));
		Actions action=new Actions(driver);
		action.moveToElement(fashion).perform();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='_3XS_gI']//a[.=\"Men's T-Shirts\"]")).click();
		
		driver.findElement(By.xpath("(//div[@class='_13oc-S']//a[.='Men Printed Round Neck Dark Green T-Shirt'])[1]")).click();
		
		Set<String> allwid = driver.getWindowHandles();
		for (String wid : allwid) {
			String url = driver.switchTo().window(wid).getCurrentUrl();
			if (url.contains("https://www.flipkart.com/blive-printed-men-round-neck-dark-green-t-shir")) {
				driver.switchTo().window(wid);
				System.out.println(url);
			}
			
			
		}
		
		
		
	}
}
