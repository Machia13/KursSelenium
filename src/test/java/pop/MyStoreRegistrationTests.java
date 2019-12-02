package pop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pop.pages.CreateAnAccountPage;

import java.util.concurrent.TimeUnit;

public class MyStoreRegistrationTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registerUserTest() {

        // arrange
        String socialTitle = "mr";
        String firstName = "Krzysztof";
        String lastName = "Kowalski";
        String email = "aaaaa@aaaa.pl";
        String password = "12345678";
        String birthdate = "11/11/2000";

        String linkToPage = "https://prod-kurs.coderslab.pl/index.php?controller=authentication&create_account=1";
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);

        // act
        driver.get(linkToPage);
        createAnAccountPage.registerUser(socialTitle, firstName, lastName, email, password, birthdate);

        // assert
        Assert.assertEquals(firstName + " " + lastName,
                driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"))
                        .getText());
    }
}
