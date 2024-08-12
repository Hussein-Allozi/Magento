import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Magento {

	WebDriver driver = new ChromeDriver();

	Random rand = new Random();
	

	@BeforeTest
	public void opensite() {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = false)
	public void signup() throws InterruptedException {
		String[] firstNames = { "Alice", "Bob", "Charlie", "Diana", "Eve" };
		String[] lastNames = { "Smith", "Johnson", "Williams", "Brown", "Jones" };
		int firstn = rand.nextInt(firstNames.length);
		int lastn = rand.nextInt(lastNames.length);
		int num = rand.nextInt(100);
		String domain = "@gmail.com";
		String passwords = "Hussein1992@2";
		WebElement creatacounte = driver.findElement(
				By.xpath("//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']"));
		creatacounte.click();
		WebElement firstname = driver.findElement(By.id("firstname"));
		WebElement lastname = driver.findElement(By.id("lastname"));
		WebElement email = driver.findElement(By.id("email_address"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement confirmpass = driver.findElement(By.id("password-confirmation"));
		WebElement signup = driver.findElement(By.xpath("//button[@title='Create an Account']"));

		String a = firstNames[firstn];
		String b = lastNames[lastn];
		String emails = a + b + num + domain;
		firstname.sendKeys(a);
		lastname.sendKeys(b);
		email.sendKeys(emails);
		pass.sendKeys(passwords);
		confirmpass.sendKeys(passwords);
		signup.click();

		WebElement MenSection = driver.findElement(By.cssSelector("#ui-id-5"));
		MenSection.click();

		WebElement OlItemsContainer = driver.findElement(By.className("product-items"));

		System.out.println(OlItemsContainer.findElements(By.tagName("li")).size());
		List<WebElement> Items = OlItemsContainer.findElements(By.tagName("li"));

		int randomIndex = rand.nextInt(Items.size());
		System.out.println(randomIndex);
		Items.get(randomIndex).click();

		WebElement SizesContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute size'] div[role='listbox']"));

		List<WebElement> allSizes = SizesContainer.findElements(By.tagName("div"));
		int RandomSize = rand.nextInt(allSizes.size());
		allSizes.get(RandomSize).click();

		WebElement colorsContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));

		List<WebElement> allColors = colorsContainer.findElements(By.tagName("div"));
		int RandomColor = rand.nextInt(allColors.size());

		allColors.get(RandomColor).click();

	}

	@Test
	public void Women() throws InterruptedException {
		WebElement WomenSection = driver.findElement(By.id("ui-id-4"));

		WomenSection.click();

		;

//		System.out.println(driver.findElements(By.className("product-item")).size());

		WebElement productITemsContainer = driver.findElement(By.className("product-items"));

//		System.out.println(productITemsContainer.findElements(By.className("product-item")).size());;
//		
//		; 

//		System.out.println(driver.findElements(By.tagName("li")).size());

		List<WebElement> AllItems = productITemsContainer.findElements(By.tagName("li"));

		int totalNumberOfItems = AllItems.size();
		int randomItem = rand.nextInt(totalNumberOfItems);

		AllItems.get(randomItem).click();
		;

		WebElement theContainerOfSizes = driver.findElement(By.cssSelector(".swatch-attribute-options.clearfix"));

		;

		String[] sizes = { "33", "34", "36", "37" };
// select any one for me i will select the first one 
//System.out.println(theContainerOfSizes.findElements(By.className("swatch-option")).size());
//System.out.println(theContainerOfSizes.findElements(By.tagName("div")).size());
		List<WebElement> ListOfSizes = theContainerOfSizes.findElements(By.className("swatch-option"));
		int numberofSizes = ListOfSizes.size();

		int randomSize = rand.nextInt(numberofSizes);
		ListOfSizes.get(randomSize).click();
		;

		WebElement ColorsContainer = driver
				.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> ListOfClors = ColorsContainer.findElements(By.tagName("div"));
		int numberOfColors = ListOfClors.size();

		int randomColor = rand.nextInt(numberOfColors);
		ListOfClors.get(randomColor).click();

		WebElement AddToCartButton = driver.findElement(By.id("product-addtocart-button"));

		AddToCartButton.click();

		Thread.sleep(5000);

		WebElement MessageAdded = driver.findElement(By.cssSelector(".message-success.success.message"));

		System.out.println(MessageAdded.getText().contains("You added"));

		Assert.assertEquals(MessageAdded.getText().contains("You added"), true);

// review section 

		driver.navigate().refresh();

		WebElement ReviewSEction = driver.findElement(By.id("tab-label-reviews-title"));

		ReviewSEction.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollTo(0,1200)");

		Thread.sleep(2000);

		WebElement RatingStars = driver.findElement(By.cssSelector(".control.review-control-vote"));

		;

		Thread.sleep(2000);

		System.out.println(RatingStars.findElements(By.tagName("label")).size() + "*****************");
//		RatingStars.findElements(By.tagName("label")).get(2).click();

		String[] ids = { "Rating_1", "Rating_2", "Rating_3", "Rating_4", "Rating_5" };
		int randomIndex = rand.nextInt(ids.length);
		WebElement element = driver.findElement(By.id(ids[randomIndex]));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		WebElement nickname = driver.findElement(By.id("nickname_field"));
		nickname.sendKeys("soso");

		WebElement summary = driver.findElement(By.id("summary_field"));

		summary.sendKeys("mahmoud");

		WebElement review = driver.findElement(By.id("review_field"));

		review.sendKeys("hello this is a test");
		;

		WebElement submitReviewButton = driver.findElement(By.cssSelector(".action.submit.primary"));

		submitReviewButton.click();

		String actualTextforReview = driver.findElement(By.cssSelector(".message-success.success.message")).getText();
		String expectedTextforReview = "You submitted your review for moderation.";

		Assert.assertEquals(actualTextforReview, expectedTextforReview);
	}

}
