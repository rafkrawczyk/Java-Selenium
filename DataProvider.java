package oop;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider {
	
	@Test (dataProvider = "getData")
	public void testAddition(int input, int expected) {
		int actual = input + 20;
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] getData(){
		return new Object[][]{
			{100, 120},
			{200, 220},
			{250, 270},
			{300, 310},
			{400, 420},
			};
	}
}
