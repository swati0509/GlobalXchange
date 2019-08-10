

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GlobalX {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "./software/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://token.globalxchange.com/checkout/1");
		driver.findElement(By.xpath("//button[contains(.,'Launch GXBrokerage')]")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[contains(.,'GXBroker License')]")).click();
		driver.findElement(By.cssSelector("p.m-0")).click();
		driver.findElement(By.name("legalName")).sendKeys("Broker");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("swati@gmail.com");
		driver.findElement(By.xpath("(//div[@class='mt-2  inputBoxStyle'])[4]")).click();
		WebElement country = driver.findElement(By.xpath("//select[@name='countryCode']"));
		Select s=new Select(country);
		s.selectByVisibleText("India +91");
		
		//s.selectByValue("+91 IN");
		driver.findElement(By.cssSelector("input[type='number']")).sendKeys("87864350978");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("RTnagar");
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Bang");
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("KA");
		driver.findElement(By.cssSelector("input[name='zipcode']")).sendKeys("560098");
		WebElement state = driver.findElement(By.cssSelector("select[name='country']"));
		Select s1=new Select(state);
		s1.selectByValue("India");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("password");
		WebElement cp = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('disabled')", cp);
		cp.sendKeys("password");
		driver.findElement(By.xpath("//button[@type='button']")).click();
		
		
		
		

	}

}
