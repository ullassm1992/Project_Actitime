package com.actiTime.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage 
{
	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addnew;
	
	@FindBy(xpath="//div[@class='item createNewCustomer ellipsis']")
	private WebElement newcustomer;
	
	@FindBy(xpath="//div[@class='item createNewProject ellipsis']")
	private WebElement project;
	
	@FindBy(xpath="//input[@id='customerLightBox_nameField']")
	private WebElement customer;
	
	@FindBy(xpath="(//div[@class='buttonIcon'])[2]")
	private WebElement create;
	
	@FindBys(value = { @FindBy(xpath="//div[@class='node customerNode notSelected']/../../div[2]") })
	private List<WebElement> allcustomers;
	
	public TaskListPage(WebDriver wd)
	{
		PageFactory.initElements(wd, this);
	}
	
	public void clickonaddnew()
	{
		addnew.click();
	}
	
	public void clickonnewcustomer()
	{
		newcustomer.click();
	}
	
	public void entercustomer(String cname)
	{
		customer.sendKeys(cname);
	}
	public void createcustomer()
	{
		create.click();
	}
	
	public void checkcustomer(String cname)
	{
		int count = allcustomers.size();
		System.out.println("Customers count:"+ count);
		for(WebElement customer:allcustomers)
		{
			String cust=customer.getText();
			if(cust.equals(cname))
			{
				System.out.println(cname +":Customer added successfully");
				System.out.println("Test case pass");
				break;
			}
		}
		System.out.println("Test case fail customer not added");
	}
	
	
	
	
	

}
