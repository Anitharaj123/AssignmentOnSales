package marathonTestNg;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OppMarathon extends BaseForOpp {
	@BeforeTest	
	public void oppurdata() {
		filename="OppAmount";
	}


	

	
	
	@Test(dataProvider="oppdata")
	
	public void oprtnty(String oppname, String amt) throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	driver.findElement(By.xpath("//p[text()='Sales']")).click();
	//WebElement opp=driver.findElement(By.xpath("//*[@data-key='chevrondown'][1]"));
//	driver.executeScript("arguments[0].click()", opp);
//	Thread.sleep(2000);
//	WebElement opp1=driver.findElement(By.xpath("//span[@class='slds-truncate']//span"));
//	driver.executeScript("arguments[0].click()", opp1);
	
//	WebElement keys=driver.findElement(By.xpath("//a[contains(@class,'filterIcon slds-button')]"));
//	driver.executeScript("arguments[0].click()", keys);
//	WebElement keys1=driver.findElement(By.xpath("//a[@title='My Opportunities']"));
//	driver.executeScript("arguments[0].click()", keys1);
//	Thread.sleep(5000);
	WebElement vAll = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
	//driver.findElement(By.xpath("(//span[@class='viewAllLabel'])[3]"));
	driver.executeScript("arguments[0].click()", vAll);
	Thread.sleep(2000);
	WebElement nw=driver.findElement(By.xpath("//div[@title='New']"));
	driver.executeScript("arguments[0].click()", nw);
	driver.findElement(By.xpath("(//input[@part='input'])[3]")).sendKeys(oppname);
	
	
	WebElement input=driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[2]"));
	driver.executeScript("arguments[0].click()", input);
	driver.findElement(By.xpath("//span[text()='New Customer']")).click();
	Thread.sleep(2000);
	WebElement nxt=driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[3]"));
	driver.executeScript("arguments[0].click()", nxt);
	driver.findElement(By.xpath("//span[text()='Partner Referral']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(amt);
	driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("29/04/2023");
	
	//driver.findElement(By.xpath("//button[@data-value='--None--']")).click();
	Thread.sleep(2000);
	WebElement nxt1=driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]"));
	driver.executeScript("arguments[0].click()", nxt1);
	Thread.sleep(2000);
	WebElement nxt2=driver.findElement(By.xpath("//span[@title='Needs Analysis']"));
	driver.executeScript("arguments[0].click()", nxt2);
	WebElement nxt3=driver.findElement(By.xpath("(//input[@class='slds-combobox__input slds-input'])[2]"));
	driver.executeScript("arguments[0].click()", nxt3);
	nxt3.sendKeys("cam");
	WebElement cm=driver.findElement(By.xpath("//lightning-base-combobox-formatted-text[@class='slds-truncate']"));
	driver.executeScript("arguments[0].click()", cm);
	WebElement sve=driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']"));
	driver.executeScript("arguments[0].click()", sve);
	Thread.sleep(5000);
	String salespse =driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
	System.out.println(salespse);
	if(salespse.equalsIgnoreCase(oppname)) {
		System.out.println("The Opportunity was created");
	}else {
		System.out.println("The Opportunity not created");
	}
	
	

}
}
//