package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtils;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtil;
	ContactsPage contactspage;
	
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil  =new TestUtils();
		contactspage=new ContactsPage();
		loginPage =new LoginPage();
		homePage  =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homepagepage=homePage.verifyHomePageTitle();
		Assert.assertEquals(homepagepage, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserLink());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactspage=homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
