package calculatortesting;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import calc.Calculator;

public class CalcTest {
	
  static Calculator calculator = new Calculator();
	
  @Test
  @Parameters({"owner"})
  public void showOwner(String owner) {
	  Calculator adamCalc = new Calculator();
	  adamCalc.owner = owner;
	  System.out.println(owner);
	  Assert.assertEquals(adamCalc.owner, "Adam");
	  
  }
	
  @Test(groups = "four function")
  public void addTest() {
	  
	  Assert.assertEquals(calculator.add(10, 5), 15);
	  
  }
  
  @Test(groups = "four function")
  public void  subtractTest() {
	  
	  Assert.assertEquals(calculator.subtract(10, 5), 5);
	  	  
  }
  
  @Test(groups = "four function")
  public void  multiplyTest() {
	  
	  Assert.assertEquals(calculator.multiply(10, 5), 50);

  }
  
  @Test(groups = "four function")
  public void  divideTest() {
	  
	  Assert.assertEquals(calculator.divide(10, 5), 2);

  }
  
  @Test(expectedExceptions = ArithmeticException.class)
  public void  divideByZero() {
	  calculator.divide(80, 0);
  }
  
  @Test
  public void hardAssert() {
	  Assert.fail();
	  System.out.println("This will not print");
	  
  }
  
  @Test
  public void softAssertTest() {
	 
	  // In some frameworks softAssert is called a verify
	  SoftAssert softAssertion= new SoftAssert();
	  softAssertion.assertTrue(false);
	  System.out.println("This will continue to run but the test is a failure");
  
	  softAssertion.assertTrue(true);
	  
	  softAssertion.assertEquals("Hello", "not Hello");
	  softAssertion.assertAll();
  }
  
  
  
  
  
}
