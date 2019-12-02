package pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

    private WebDriver driver;

    @FindBy(xpath="//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input")
    private WebElement mrRadioButton;

    @FindBy(xpath="//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[2]/span/input")
    private WebElement mrsRadioButton;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "birthday")
    private WebElement birthdate;

    @FindBy(xpath = "//*[@id=\"customer-form\"]/footer/button")
    private WebElement save;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerUser(String socialTitle, String firstName, String lastName,
                             String email, String password, String birthdate) {

        if (socialTitle.equals("mr"))
            mrRadioButton.click();
        else
            mrsRadioButton.click();

        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);

        this.email.clear();
        this.email.sendKeys(email);

        this.password.clear();
        this.password.sendKeys(password);

        this.birthdate.clear();
        this.birthdate.sendKeys(birthdate);

        save.click();
    }
}
