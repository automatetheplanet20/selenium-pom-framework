package testScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.base.BaseTest;
import framework.utils.ExcelUtil;
import pageObjects.HomePage;


//all test cases will be executed for all the test data once
public class EcomTest extends BaseTest{
	
	public HomePage hp;
	//New code
	
	@DataProvider(name="DP")
	public Iterator<Object[]> getTestData(Method method) {
		
		String testName = method.getName(); 
		List<HashMap<String,String>> dataMap = new ArrayList<HashMap<String, String>>();
		
		switch (testName) {
		case "test1":
			//dataMap is almost equal to excel
			dataMap = ExcelUtil.loadDataIntoMap("/Users/thinker/Documents/testdatapertest1.xlsx", testName);
			break;

		case "test2":
			dataMap = ExcelUtil.loadDataIntoMap("/Users/thinker/Documents/testdatapertest2.xlsx", testName);
			
			break;
			
		default:
			break;
		}
		
//		System.out.println(testName);

		//iterator is only present on collection. That's why we are creating collection of type object[]
		Collection<Object[]> dp = new ArrayList<Object[]>();
		for (HashMap<String, String> map : dataMap) {
			dp.add(new Object[] { map });
		}
		return dp.iterator();
	}
	
	@Test(dataProvider = "DP")
	public void test1(HashMap<String, String> data) {
//		System.out.println(data);
		hp = new HomePage(driver);
		List<String> searchResults = hp.searchProduct(data.get("SearchString"));
		for(String str:searchResults) {
			assertTrue(str.contains(data.get("SearchString")),"Actual Value: " + str);
		}
		
		
//		System.out.println("one");
		
	}
	
	
	@Test(dataProvider = "DP")
	public void test2(HashMap<String, String> data) {
		assertEquals(data.get("Phone"), hp.getShopPhoneNumber());
		
//		System.out.println(data);
//		System.out.println("two");
		
	}
	

}
