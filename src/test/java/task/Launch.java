package task;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {
	@Test
	public void lanchTest() throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_2QfC02']//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_3OO5Xc']//input")).sendKeys("laptop");
		
		Thread.sleep(3000);
//		Robot r=new Robot();
//		for (int i = 0; i < 7; i++) {
//			r.keyPress(KeyEvent.VK_DOWN);
//			Thread.sleep(2000);
//		}
//		r.keyPress(KeyEvent.VK_ENTER);
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']//li//div//a//div[@class='lrtEPN _17d0yO']"));
		list.get(list.size()-2).click();
		System.out.println(list);
		
		driver.quit();
	}
}
