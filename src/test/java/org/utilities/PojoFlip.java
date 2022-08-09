package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoFlip extends BaseClass {
	
	public PojoFlip() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "pincodeInputId")
	private WebElement pincode;

	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closepop;

	@FindBy(className = "_3704LK")
	private WebElement searchbox;

	@FindBy(className = "L0Z3Pu")
	private WebElement search;

	@FindBy(xpath = "(//a[@class='ge-49M'])[1]")
	private WebElement nextPage;

	@FindBy(xpath = "//*[text()='KARDECK Aqua Diffuser']/..//div//*[name()='svg']")
	private WebElement wishList;


	@FindBy(xpath = "//div[text()='Please login for wishlisting a product']")
	private WebElement message1;


	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closePop;


	@FindBy(xpath = "//*[text()='KARDECK Aqua Diffuser']")
	private WebElement Productpage;

	@FindBy(xpath = "//span[@class='_2P_LDn']")
	private WebElement check;

	@FindBy(xpath = "//span[@class='_1TPvTK']")
	private WebElement date;

	@FindBy(xpath = "//button[text()='ADD TO CART']")
	private WebElement cart;

	@FindBy(xpath = "(//button[@class='_23FHuj'])[2]")
	private WebElement qty;

	@FindBy(xpath = "//div[@class='_2sKwjB']")
	private WebElement message2;

	@FindBy(xpath = "//input[@class='_253qQJ']")
	private WebElement message3;

	@FindBy(xpath = "//div[text()='Save for later']")
	private WebElement later;

	@FindBy(xpath = "//div[@class='_2sKwjB']")
	private WebElement message4;
	
	@FindBy(xpath = "//div[text()='Remove']")
	private WebElement remove;

	@FindBy(xpath = "//div[text()='Cancel']//following-sibling::div")
	private WebElement removed;

	@FindBy(xpath = "//div[text()='KARDECK Aqua Diffuser has been removed from your saved list.']")
	private WebElement message5;

	public WebElement getClosepop() {
		return closepop;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getNextPage() {
		return nextPage;
	}

	public WebElement getWishList() {
		return wishList;
	}

	public WebElement getMessage1() {
		return message1;
	}

	public WebElement getClosePop() {
		return closePop;
	}

	public WebElement getProductpage() {
		return Productpage;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getCheck() {
		return check;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getQty() {
		return qty;
	}

	public WebElement getMessage2() {
		return message2;
	}

	public WebElement getMessage3() {
		return message3;
	}

	public WebElement getLater() {
		return later;
	}

	public WebElement getMessage4() {
		return message4;
	}

	public WebElement getRemove() {
		return remove;
	}

	public WebElement getRemoved() {
		return removed;
	}

	public WebElement getMessage5() {
		return message5;
	}

	



}
