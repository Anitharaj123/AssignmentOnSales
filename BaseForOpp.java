package marathonTestNg;


	import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;





	public class BaseForOpp {
		public String filename;
		public RemoteWebDriver driver;
		public ChromeOptions Options;
		public EdgeOptions Options1;
		
	
	
@Parameters({"Browser","urL","uname","pwd"})
	@BeforeMethod
		public void precondition(String browser,String url,String Username,String Password) {
	if(browser.equalsIgnoreCase("Chrome")) {
		driver= new ChromeDriver();
		
		Options=new ChromeOptions();
		 Options.addArguments("--remote-allow-origins=*");
		Options.addArguments("--disable-notifications");
	
		
	}
	else if(browser.equalsIgnoreCase("Edge")) {
	    driver=new EdgeDriver();
	    //public EdgeOptions Options1;
	    Options1=new EdgeOptions();
		 Options1.addArguments("--remote-allow-origins=*");
		Options1.addArguments("--disable-notifications");

	}

		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("Login")).click();

	}
	@AfterMethod
	public void postcondition() {
		driver.close();
	}

	@DataProvider(name="oppdata")
	public String[][] sendData() throws IOException {
		

		String[][] readData = OppMarathonExcel.readData(filename);
		
		return readData;
	}
	}


