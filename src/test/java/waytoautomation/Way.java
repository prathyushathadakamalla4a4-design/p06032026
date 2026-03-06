package waytoautomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 /*
  * WebElement from = driver.findElement(By.xpath("//div[@id='draggable']"));
	// drop
	WebElement to = driver.findElement(By.xpath("//div[@id='droppable']"));
	Actions un = new Actions(driver);
	Action dragAndDrop = un.clickAndHold(from)
			.moveToElement(to)
			.release(to)
			.build();
 
			//Performing the drag and drop action
			dragAndDrop.perform();
	}
 
}
 */
  
public class Way 
{
 WebDriver driver;
  @BeforeTest 
  public void launch() {
	  driver = new ChromeDriver();
	  driver.get("https://www.way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");
	  driver.manage().window().maximize();
  }
  @Test (priority =1)
  public void frame() 
  {
	  // swiching to first frame
	  driver.switchTo().frame(0);
	   // to click on the open new tab
	  driver.findElement(By.linkText("New Browser Tab")).click();
	  // switching to parrent window
	  Set<String> ids = driver.getWindowHandles();
	  ArrayList<String> id1 = new ArrayList<String>(ids);
	  // first name we are printing
	  System.out.println("window name:" + id1.get(0) );
	  // switching to child window
		driver.switchTo().window((String)id1.get(1));
		System.out.println("window name2:" + id1.get(1));
		driver.close();
		// switching to parent window
		driver.switchTo().window((String)id1.get(0));
		driver.switchTo().defaultContent();
  }
  @Test(priority = 2)
  public void mul() {
  // Boostrap drop down
  List<WebElement> li = driver.findElements(By.xpath("//ul[@class='responsive-tabs']/li/a"));
   System.out.println(li.size()); 
   for(WebElement li1 : li) {
	   System.out.println(li1.getText());
	   if(li1.getText().equalsIgnoreCase("Open Seprate New Window"))
	   {
		   li1.click();
		   break;
	   }
   } 
 // frame
   driver.switchTo().frame(1);
    driver.findElement(By.linkText("Open New Seprate Window")).click();
    Set<String> ids1 = driver.getWindowHandles();
	  ArrayList<String> id12 = new ArrayList<String>(ids1);
	  // first name we are printing
	  System.out.println("window name:" + id12.get(0) );
	  // switching to child window
		driver.switchTo().window((String)id12.get(1));
		System.out.println("window name2:" + id12.get(1));
		driver.close();
		// switching to parent window
		driver.switchTo().window((String)id12.get(0));
		driver.switchTo().defaultContent();
  }
  @Test(priority = 3)
  public void f() {
	  driver.findElement(By.xpath("//a[text()='Frameset']")).click();
	  //frame
	 // driver.switchTo().frame(3);
	 // driver.findElement(By.xpath("//a[text()='Open Frameset Window']/parent::*/parent::*")).click();
  }
  @Test(priority = 4)
  public void drop() {
	  driver.navigate().to("https://www.way2automation.com/way2auto_jquery/dropdown.php#load_box");
	  // enter country
	  driver.findElement(By.xpath("//a[text()='Enter Country']")).click();
	 driver.switchTo().frame(1);
	 WebElement sel = driver.findElement(By.id("combobox"));
	 sel.click();
	 Select sel1 = new Select(sel);
	 sel1.selectByIndex(4);
	 driver.switchTo().defaultContent();
  }
  @Test(priority = 5)
  public void reg() 
  {
	 // in nav selecting
	  driver.findElement(By.linkText("Registration")).click();
	  // first name
	  WebElement fname = driver.findElement(By.xpath("/html/body/section/div/div/div/form/fieldset/p[1]/input"));
	  fname.sendKeys("Thadakamalla");
	  // second name
	  WebElement sname = driver.findElement(By.xpath("/html/body/section/div/div/div/form/fieldset/p[2]/input"));
	  sname.sendKeys("prathyusha");
	  // radio button
	  driver.findElement(By.xpath("//label[text()=' Married']")).click();
	  //Hobby
	  driver.findElement(By.xpath("/html/body/section/div/div/div/form/fieldset[3]/div/label[1]/input")).click();
	  // date of birth
	  // month
	  driver.findElement(By.xpath("/html/body/section/div/div/div/form/fieldset[5]/div[1]/select[1]")).click();
	  driver.findElement(By.xpath("/html/body/section/div/div/div/form/fieldset[5]/div[1]/select[1]/option[1]")).click();
  }
  @Test(priority = 6)
  public void al() throws InterruptedException {
	  driver.findElement(By.linkText("Alert")).click();
	  // frame
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("//button[text()='Click the button to display an alert box:']")).click();
	  driver.switchTo().alert().accept();
	  driver.switchTo().defaultContent();
	  // input alert
	  driver.findElement(By.xpath("//a[text()='Input Alert']")).click();
	  // frame
	  driver.switchTo().frame(1);
	  // alert clicking
	  driver.findElement(By.xpath("//button[text()='Click the button to demonstrate the Input box.']")).click();
	  // send keys
	  driver.switchTo().alert().sendKeys("Hi ashwika");
	  Thread.sleep(2000);
	  driver.switchTo().alert().accept();
	  System.out.println(driver.findElement(By.cssSelector("#demo")).getText());
  }
}
