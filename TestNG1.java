package oop;

import org.testng.annotations.*;

public class TestNG1 {
	
	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("Executing before suite");
	}
	
	@AfterSuite
	public void afterSuiteMethod() {
		System.out.println("Executing after suite");
	}

}
