package marathonTestNg;





import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
public class QuestionSalesForce extends BaseClassQuestions {
@BeforeTest	

public void TopassData(){
	 
	fileName="QuestionSales";
	 
}
	
	





@Test(dataProvider="getdata")

	public void Questions(String Questn,String Dtl) throws InterruptedException {
	driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	driver.findElement(By.xpath("//button[text()='View All']")).click();
	WebElement Srch=driver.findElement(By.xpath("//input[@part='input']"));
			Srch.sendKeys("Content",Keys.ENTER);
	driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
	Thread.sleep(2000);
	//driver.findElement(By.xpath("//button[@data-aura-rendered-by='1069:0']//lightning-primitive-icon[1]")).click();
	
	WebElement chatterbox=driver.findElement(By.xpath(("//span[text()='Chatter']")));
	driver.executeScript("arguments[0].click()",chatterbox);
	
	
	
	driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
	String title=driver.getTitle();
	System.out.println(title);
	if(title.contains("Chatter Home")) {
		System.out.println("The title is verified");
	}else 
	{
		System.out.println("The title is not verified");
	}
 
    driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(Questn);
     
    driver.findElement(By.xpath("//div[contains(@class,'ql-editor ql-blank')]//p[1]")).sendKeys(Dtl);
    driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button_brand')]")).click();
   String verify = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
   System.out.println(verify);
   Thread.sleep(2000);
   if(verify.contains("Admin Certifications?")) {
    	System.out.println("The Question is Succesfully posted");}
    	else {
    		System.out.println("The Question is not posted");
    }
    	
    }
	

}