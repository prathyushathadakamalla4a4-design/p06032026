package waytoautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class hyr 
{
	WebDriver driver;
	
 @BeforeTest
 public void launch() {
	 driver = new ChromeDriver();
	
	 driver.manage().window().maximize();
 }
 @Test
 public void f1() 
 {
	 driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
	 //driver.switchTo().frame("frm1");
	 driver.switchTo().frame(1);
	 //dropdown
	 WebElement sel = driver.findElement(By.id("selectnav1"));
	 sel.click();
	 driver.switchTo().defaultContent();
	 driver.findElement(By.id("course")).click();
 }
  @Test
 public void am() throws InterruptedException {
	// driver.get("https://the-internet.herokuapp.com/context_menu"); 
	 /*
	  * 1. click
	  * 2. mouse hover
	  * 3. right click(contex click)
	  * 4. double click
	  * 5. drag and drop
	  */
	 Actions act = new Actions(driver);
	// act.moveToElement(driver.findElement(By.id("hot-spot"))).contextClick().build().perform();
	// driver.switchTo().alert().accept();
	// driver.navigate().to("https://the-internet.herokuapp.com/hovers");
	 //Thread.sleep(2000);
	 //act.moveToElement(driver.findElement(By.xpath("//div[@id='content']/child::div/div[1]"))).build().perform();
	 driver.get("https://testautomationpractice.blogspot.com/");
	 act.moveToElement(driver.findElement(By.xpath("//button[text()='Point Me']"))).build().perform();
	 // double click
	// act.moveToElement(driver.findElement(By.xpath("//button[text()='Copy Text']"))).doubleClick().build().perform();
	act.doubleClick(driver.findElement(By.xpath("//button[text()='Copy Text']"))).build().perform();
	
	

	WebElement drag = driver.findElement(By.id("draggable"));
	WebElement drop = driver.findElement(By.id("droppable"));
	act.dragAndDrop(drag,drop).build().perform();
 }
}
