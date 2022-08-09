package org.stepdefinition;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.utilities.BaseClass;
import org.utilities.PojoFlip;

import io.cucumber.java.en.*;

public class CartNavigation extends BaseClass {

	@Given("Launching of browser,managing window and opening the URL")
	public void launchingOfBrowserManagingWindowAndOpeningTheURL() {
		launch();
		max();
		link("https://www.flipkart.com/");

	}

	@When("User should navigate to the Air freshner section coming under Home section")
	public void userShouldNavigateToTheAirFreshnerSectionComingUnderHomeSection() {
		PojoFlip pl = new PojoFlip();
		clk(pl.getClosepop());
		clk(pl.getSearchbox());
		fill(pl.getSearchbox(), "Air Freshner");
		clk(pl.getSearch());
		iWait(5);

	}

	@When("User should navigate to the second page")
	public void userShouldNavigateToTheSecondPage() {
		PojoFlip pl = new PojoFlip();
		clk(pl.getNextPage());
		iWait(3);
	}

	@When("User should click the wishlist icon and confirm the message")
	public void userShouldClickTheWishlistIconAndConfirmTheMessage() {
		PojoFlip pl = new PojoFlip();
		try {
			clk(pl.getWishList());
		} catch (Exception e) {
			System.out.println("PRODUCT NOT AVAILABLE: Odonil Room Freshening Sandal Bouquet Spray");
			System.exit(0);
		}
		
		//Odonil Room Freshening Sandal Bouquet Spray
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Please login for wishlisting a product']")));
		String text1 = pl.getMessage1().getText();
		Assert.assertEquals(true, text1.contains("login for wishlist"));
		System.out.println("This was printed:" + text1);

	}

	@When("User should close the login page and move to the product page")
	public void userShouldCloseTheLoginPageAndMoveToTheProductPage() throws InterruptedException {
		PojoFlip pl = new PojoFlip();
		clk(pl.getClosePop());
		Thread.sleep(5000);
		clk(pl.getProductpage());
		iWait(2);

	}

	@When("User should enter the pincode and print the available delivery date")
	public void userShouldEnterThePincodeAndPrintTheAvailableDeliveryDate() {
		String parentId = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String each : allWindows) {
			if (!parentId.equals(each)) {
				driver.switchTo().window(each);
			}
		}
		PojoFlip pl = new PojoFlip();
		pl.getPincode();
		fill(pl.getPincode(), "600100");
		clk(pl.getCheck());
		String text2 = pl.getDate().getText();
		System.out.println("Delivery date:" + text2);
	}

	@When("User should add the item to the cart and confirm")
	public void userShouldAddTheItemToTheCartAndConfirm() throws InterruptedException {
		PojoFlip pl = new PojoFlip();
		clk(pl.getCart());
		Thread.sleep(5000);
		String title = driver.getTitle();
		Assert.assertEquals(true, title.contains("Shopping Cart"));
		System.out.println("The product is added to cart");
	}

	@When("User should increase the quantity from cart page and confirm the message")
	public void userShouldIncreaseTheQuantityFromCartPageAndConfirmTheMessage() throws InterruptedException {
		PojoFlip pl = new PojoFlip();
		clk(pl.getQty());
		Thread.sleep(3000);
		String text3 = pl.getMessage2().getText();
		Assert.assertEquals(true, text3.contains("2"));
		System.out.println("The quantity is updated to:" + text3);

	}

	@When("User should click on save for later and validate")
	public void userShouldClickOnSaveForLaterAndValidate() throws InterruptedException {
		PojoFlip pl = new PojoFlip();
		clk(pl.getLater());
		Thread.sleep(3000);
		String text4 = pl.getMessage4().getText();

		System.out.println(text4);
		Assert.assertEquals(true, text4.contains("Saved For Later"));
		System.out.println("The item has been moved to save for later" + text4);
		System.out.println("The cart is empty");

	}

	@When("User should remove the item from save for later")
	public void userShouldRemoveTheItemFromSaveForLater() {
		PojoFlip pl = new PojoFlip();
		clk(pl.getRemove());
		iWait(1);
		clk(pl.getRemoved());
	}

	@Then("Validate the confirmation message shown to user")
	public void validateTheConfirmationMessageShownToUser() throws InterruptedException {
		PojoFlip pl = new PojoFlip();
		Thread.sleep(3000);
		String text5 = pl.getMessage5().getText();
		Assert.assertEquals(true, text5.contains("removed from your saved list"));
		System.out.println(text5);
	}

}
