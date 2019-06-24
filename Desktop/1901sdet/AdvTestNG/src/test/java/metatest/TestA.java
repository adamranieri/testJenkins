package metatest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestA {

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("@BeforeMethod :Before Each test method in test A");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("@AfterMethod : After Each test method in test A");  
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("@BeforeClass : Runs once at the start of class A");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("@AfterClass : Runs once at the end of Class A");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("@BeforeTest : Runs once in at the start of the test tag Class A");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("@AfterTest : Runs once at the end of the Test Tag Class A");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("@BeforeSuite : Runs at the start of the suite Class A");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("@AfterSuite : Runs once at the end of the suite Class A");
  }
  
  
  @Test
  public void test1A() {
	  System.out.println("Test1A is being tested");
	  Assert.assertEquals(true, true);
  }
  
  @Test
  public void test2A() {
	  
	  System.out.println("Test2A is being tested");
	  Assert.assertEquals(true, true);
	  
  }
  

}
