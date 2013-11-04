
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Selenium  {
    public static void main(String[] args) {
    	testCase1();
    	testCase2();
    	testCase3();
    	testCase4();
    	testCase5();
    	 testCase6();
    	 testCase7();
    }
    
    public static void testCase1(){
    	System.out.println("Checking the 3 valid users");
    	WebDriver driver1 = new FirefoxDriver();
    	driver1.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname = driver1.findElement(By.name("userId"));
        WebElement pswd = driver1.findElement(By.name("userPassword"));

        // Enter something to search for
        uname.clear();
        pswd.clear();
        
        uname.sendKeys("andy");
        pswd.sendKeys("apple");
        // Now submit the form. WebDriver will find the form for us from the element
        uname.submit();
        
        if (driver1.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Successfull Login for andy");
        }
        else{
        	System.out.println("UnSuccessfull Login for andy");
        }
        
        WebDriver driver2 = driver1;
    	driver2.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname2 = driver2.findElement(By.name("userId"));
        WebElement pswd2 = driver2.findElement(By.name("userPassword"));

        // Enter something to search for
        uname2.clear();
        pswd2.clear();
        
        uname2.sendKeys("bob");
        pswd2.sendKeys("bathtub");
        // Now submit the form. WebDriver will find the form for us from the element
        uname2.submit();
        
        if (driver2.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Successfull Login for bob");
        }
        else{
        	System.out.println("UnSuccessfull Login for bob");
        }
        
        WebDriver driver3 = driver2;
    	driver3.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname3 = driver3.findElement(By.name("userId"));
        WebElement pswd3 = driver3.findElement(By.name("userPassword"));

        // Enter something to search for
        uname3.clear();
        pswd3.clear();
        
        uname3.sendKeys("charley");
        pswd3.sendKeys("china");
        // Now submit the form. WebDriver will find the form for us from the element
        uname3.submit();
        
        if (driver3.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Successfull Login for charley");
        }
        else{
        	System.out.println("UnSuccessfull Login for charley");
        }
        
        WebDriver driver4 = driver3;
    	driver4.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname4 = driver4.findElement(By.name("userId"));
        WebElement pswd4 = driver4.findElement(By.name("userPassword"));

        // Enter something to search for
        uname4.clear();
        pswd4.clear();
        
        uname4.sendKeys("riddhi");
        pswd4.sendKeys("ihddir");
        // Now submit the form. WebDriver will find the form for us from the element
        uname4.submit();
        
        if (driver4.getTitle().equals("Bad Login")){
        	System.out.println("UnSuccessfull Login for riddhi");
        }
        else{
        	System.out.println("Successfull Login for riddhi");
        }
        driver4.close();
    }  
    
    public static void testCase2(){
    	System.out.println("\n\nUsernames case insensitive;passwords case-sensitive;leading/trailing spaces");
    	WebDriver driver1 = new FirefoxDriver();
    	driver1.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname = driver1.findElement(By.name("userId"));
        WebElement pswd = driver1.findElement(By.name("userPassword"));

        // Enter something to search for
        uname.clear();
        pswd.clear();
        
        uname.sendKeys("AnDy");
        pswd.sendKeys("apple");
        // Now submit the form. WebDriver will find the form for us from the element
        uname.submit();
        
        if (driver1.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Successfull Login for AnDy");
        }
        else{
        	System.out.println("UnSuccessfull Login for andy");
        }
        
        WebDriver driver2 = driver1;
    	driver2.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname2 = driver2.findElement(By.name("userId"));
        WebElement pswd2 = driver2.findElement(By.name("userPassword"));

        // Enter something to search for
        uname2.clear();
        pswd2.clear();
        
        uname2.sendKeys(" bob");
        pswd2.sendKeys("bathtub  ");
        // Now submit the form. WebDriver will find the form for us from the element
        uname2.submit();
        
        if (driver2.getTitle().equals("Online temperature conversion calculator")){
        	System.out.println("Successfull Login for bob(leading space) and bathtub(trailing space)");
        }
        else{
        	System.out.println("UnSuccessfull Login for bob");
        }
        
        WebDriver driver3 = driver2;
    	driver3.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname3 = driver3.findElement(By.name("userId"));
        WebElement pswd3 = driver3.findElement(By.name("userPassword"));

        // Enter something to search for
        uname3.clear();
        pswd3.clear();
        
        uname3.sendKeys("charley");
        pswd3.sendKeys("CHIna");
        // Now submit the form. WebDriver will find the form for us from the element
        uname3.submit();
        
        if (driver3.getTitle().equals("Bad Login")){
        	System.out.println("UnSuccessfull Login for charley;check password-CHIna (case-sensitive)");
        }
        else{
        	System.out.println("Successfull Login for charley ");
        }
        driver3.close();
     }
    
    public static void testCase3(){
    	
    	System.out.println("\n\nTesting 3 failed logins in 10secs leading to lockout");
    	
    	WebDriver driver1 = new FirefoxDriver();
    	int count = 0;
    	long end = System.currentTimeMillis() + 10000;
    	
    	driver1.get("http://adnan.appspot.com/testing-lab-login.html");
    	WebElement uname = driver1.findElement(By.name("userId"));
    	WebElement pswd = driver1.findElement(By.name("userPassword"));
    	// Enter something to search for
        uname.clear();
        pswd.clear();
        
        uname.sendKeys("blah1");
        pswd.sendKeys("blah1");
        // Now submit the form. WebDriver will find the form for us from the element
        uname.submit();
        
        if (driver1.getTitle().equals("Bad Login")){
        	count = count +1;
        	System.out.println("Failed login for blah1:"+count);
        }
        
        WebDriver driver2 = driver1;
    	driver2.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname2 = driver2.findElement(By.name("userId"));
        WebElement pswd2 = driver2.findElement(By.name("userPassword"));

        // Enter something to search for
        uname2.clear();
        pswd2.clear();
        
        uname2.sendKeys("blah2");
        pswd2.sendKeys("blah2");
        // Now submit the form. WebDriver will find the form for us from the element
        uname2.submit();
        
        if (driver1.getTitle().equals("Bad Login")){
        	count = count +1;
        	System.out.println("Failed login for blah2:"+count);
        }
        
        WebDriver driver3 = driver2;
    	driver3.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname3 = driver3.findElement(By.name("userId"));
        WebElement pswd3 = driver3.findElement(By.name("userPassword"));

        // Enter something to search for
        uname3.clear();
        pswd3.clear();
        
        uname3.sendKeys("blah3");
        pswd3.sendKeys("blah3");
        // Now submit the form. WebDriver will find the form for us from the element
        uname3.submit();
        
        if (driver1.getTitle().equals("Bad Login")){
        	count = count +1;
        	System.out.println("Failed login for blah3:"+count);
        }
        
        if (count==3 && System.currentTimeMillis() < end){
        	System.out.println("LOCKOUT testing:3 failed logins in 10 seconds");
        }
        
        WebDriver driver4 = driver3;
    	driver4.get("http://adnan.appspot.com/testing-lab-login.html");
        WebElement uname4 = driver4.findElement(By.name("userId"));
        WebElement pswd4 = driver4.findElement(By.name("userPassword"));

        // Enter something to search for
        uname4.clear();
        pswd4.clear();
        
        uname4.sendKeys("blah4");
        pswd4.sendKeys("blah4");
        // Now submit the form. WebDriver will find the form for us from the element
        uname4.submit();
        
        if (driver4.getTitle().equals("Bad Login")){
        	count = count +1;
        	System.out.println("BUG:::NO LOCKOUT THOUGH THERE WERE FAILED LOGINS");
        }
        driver4.close();
    }
    
    public static void testCase4(){
    	System.out.println("\n\nTesting Temperature results precision");
    	WebDriver driver1 = new FirefoxDriver();
    	
    	driver1.get("http://adnan.appspot.com/testing-lab-calculator.html");
    	WebElement temp = driver1.findElement(By.name("farenheitTemperature"));
    	
    	temp.clear();
    	temp.sendKeys("190");
    	temp.submit();
    	WebElement celtemp = driver1.findElement(By.tagName("h2"));
    	String[] ctemp = celtemp.getText().split("\\=");
    	String[] cval = ctemp[1].split("\\s+");
    	String[] finalcval = cval[1].split("\\.");
    	if (finalcval.length==2){
    		System.out.println("PASS: Converted Temperatures between 0 to 212 have double precision");
    		System.out.println("90 Farenheit = 87.78 Celsius");
    	}
    	WebDriver driver2 = driver1;
    	driver2.get("http://adnan.appspot.com/testing-lab-calculator.html");
    	WebElement temp2 = driver2.findElement(By.name("farenheitTemperature"));
    	
    	temp2.clear();
    	temp2.sendKeys("451");
    	temp2.submit();
    	WebElement celtemp2 = driver2.findElement(By.tagName("h2"));
    	String[] ctemp2 = celtemp2.getText().split("\\=");
    	String[] cval2 = ctemp2[1].split("\\s+");
    	String[] finalval = cval2[1].split("\\.");
    	if (finalval.length==2){
    		System.out.println("BUG::: Converted Temperatures out of [0-212] also have double precision");
    		System.out.println("451 Farenheit = 232.78 Celsius");
    	}
    	driver2.close();
   }
   
    public static void testCase5(){
    	System.out.println("\n\nTesting Temperature input as floating point numbers");
    	WebDriver driver1 = new FirefoxDriver();
    	
    	driver1.get("http://adnan.appspot.com/testing-lab-calculator.html");
    	WebElement temp = driver1.findElement(By.name("farenheitTemperature"));
    	temp.clear();
    	temp.sendKeys("97");
    	temp.submit();
    	if (driver1.getTitle().equals("Temperature Converter Result")){
    		System.out.println("PASS: 97F");
    	}
    	
    	WebDriver driver2 = driver1;
    	driver2.get("http://adnan.appspot.com/testing-lab-calculator.html");
    	WebElement temp1 = driver2.findElement(By.name("farenheitTemperature"));
    	temp1.clear();
    	temp1.sendKeys("-3.14");
    	temp1.submit();
    	if (driver2.getTitle().equals("Temperature Converter Result")){
    		System.out.println("PASS: -3.14");
    	}
    	
    	WebDriver driver3 = driver2;
    	driver3.get("http://adnan.appspot.com/testing-lab-calculator.html");
    	WebElement temp2 = driver3.findElement(By.name("farenheitTemperature"));
    	temp2.clear();
    	temp2.sendKeys("-3.14");
    	temp2.submit();
    	if (driver3.getTitle().equals("Temperature Converter Result")){
    		System.out.println("BUG: Even accepts 9.73E2");
    	}
    	driver3.close();
    }
    
    public static void testCase6(){
    	System.out.println("\n\nTesting Temperature invalid input temperatures");
    	WebDriver driver1 = new FirefoxDriver();
    	
    	driver1.get("http://adnan.appspot.com/testing-lab-calculator.html");
    	WebElement temp1 = driver1.findElement(By.name("farenheitTemperature"));
    	temp1.clear();
    	temp1.sendKeys("mango");
    	temp1.submit();
    	if (driver1.getTitle().equals("Bad Temperature")){
    		System.out.println("SUCCESS:Number format exception for invalid input:mango");
    	}
    	driver1.close();
    }
    
    public static void testCase7(){
    	System.out.println("\n\nTesting case insensitivity of “farenheitTemperature");
    	 WebDriver driver1 = new FirefoxDriver();
    	 driver1.get("http://adnan.appspot.com/testing-lab-conversion?faRENhEITTemperature=100");
    	 if (driver1.getTitle().equals("No Temperature")){
    		 System.out.println("BUG:::farenheitTemperature is case sensitive");
    	 }
    	 driver1.close();
    }
    
    
    
}