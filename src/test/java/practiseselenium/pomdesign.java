package practiseselenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class pomdesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.tripadvisor.in/");
        
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
        
        je.executeScript("arguments[0].scrollIntoView(true);",element);
       
        driver.findElement(By.xpath("//input[@placeholder='Where to?']")).sendKeys("Club Mahindra");
        driver.findElement(By.xpath("//input[@placeholder='Where to?']")).sendKeys(Keys.ENTER);
        List<WebElement> searchlist=driver.findElements(By.xpath("//*[@class='ui_column is-12 content-column result-card result-card-default']"));
        
        System.out.println("number of list:"+searchlist.size());
        searchlist.get(0).click();
        
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it=windows.iterator();
        String parentID=it.next();
        String childID=it.next();
        
        driver.switchTo().window(childID);
     WebElement element1 = driver.findElement(By.xpath("//h2[text()='Reviews']//parent::div"));
     //   driver.findElement(By.xpath(xpathExpression))
        je.executeScript("arguments[0].scrollIntoView(true);",element1);
     // je.executeScript("document.querySelector('#COMMUNITYCONTENT').scrollIntoView(text(\"Write a review\"))");//"xpath(\"//h2[text()='Reviews']"
        
        driver.findElement(By.xpath("//a[text()='Write a review']")).click();
        
        Actions a=new Actions(driver);
       // a.moveToElement(driver.findElement()).build().perform();
        a.moveToElement(driver.findElement(By.cssSelector("span[id='bubble_rating']")))
        .click(driver.findElement(By.cssSelector("span[class='ui_bubble_rating fl bubble_50']"))).build().perform();
      // a.moveToElement(driver.findElement()).click().build().perform();
        //a.moveToElement(target)
      // a.click().build().perform();
       
        driver.findElement(By.id("ReviewTitle")).sendKeys("Title of your review");
      /*  for(int i=0;i<searchlist.size();i++)
        {
        	String name=searchlist.get(0).getText();
        	System.out.println(name);
        	
        }
        */
        


        
	}

}
