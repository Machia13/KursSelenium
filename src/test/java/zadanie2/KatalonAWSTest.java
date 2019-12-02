package zadanie2;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonAWSTest {

    private WebDriver driver;

    private String katalonAWSSite = "https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        // open Chrome instance
        driver = new ChromeDriver();
        // maximize
        driver.manage().window().maximize();
        driver.get(katalonAWSSite);
    }

    @Test
    public void fillFormTestPositivePath(){

        // put first name
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.clear();
        firstName.sendKeys("Karol");

        System.out.println(driver.findElement(By.xpath("//*[@id=\"infoForm\"]/div[1]/label")).getText()
                + " " + firstName.getAttribute("value"));

        // put last name
//        WebElement lastName = driver.findElement(By.id("last-name"));
//        lastName.clear();
//        lastName.sendKeys("Kowalski");
        inputLastName("Kowalski");

        // click Male gender
        WebElement male = driver.findElement(By.xpath("//*[@id='infoForm']/div[3]/div/div/label[1]/input"));
        male.click();

        // put date of birth
        WebElement birthDate = driver.findElement(By.id("dob"));
        birthDate.clear();
        birthDate.sendKeys("05/22/2010");

        // put address
        WebElement address = driver.findElement(By.id("address"));
        address.clear();
        address.sendKeys("Prosta 51");

        // put email
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("karol.kowalski@mailinator.com");

        // put password
        WebElement password = driver.findElement(By.id("password"));
        password.clear();
        password.sendKeys("Pass123");

        // company
        WebElement company = driver.findElement(By.id("company"));
        company.clear();
        company.sendKeys("Coders Lab");

        // select role
        WebElement selectElem = driver.findElement(By.id("role"));
        Select role = new Select(selectElem);
        role.selectByVisibleText("Business Analyst");

        // comment
        WebElement comment = driver.findElement(By.id("comment"));
        comment.clear();
        comment.sendKeys("To jest mój pierwszy automat testowy");

        // submit form by clicking button
        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        // assert that success message appeared
        WebElement successMessage = driver.findElement(By.id("submit-msg"));

        String text = successMessage.getText();
        String idik = successMessage.getAttribute("id");
        String tagName = successMessage.getTagName();

        Boolean isEnabled = successMessage.isEnabled();
        Boolean isDisplayed = successMessage.isDisplayed();

        Assert.assertTrue(successMessage.getText().contains("Successfully submitted!"));
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    private void inputLastName(String lastNameString) {
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.clear();
        lastName.sendKeys(lastNameString);
    }
}
