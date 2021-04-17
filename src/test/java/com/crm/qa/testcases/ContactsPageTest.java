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

public class ContactsPageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtil;
	ContactsPage contactspage;
	
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil  =new TestUtils();
		loginPage =new LoginPage();
		contactspage=new ContactsPage();
		homePage  =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactspage=homePage.clickOnContactsLink();
		
		
	}
	
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactspage.verifyContactsLabel(),"conatcs label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactsTest()
	{
		contactspage.selectContactsByName("Harry test");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest()
	{
		contactspage.selectContactsByName("Harry test");
		contactspage.selectContactsByName("hi hi");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
