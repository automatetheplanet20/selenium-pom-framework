package testScripts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import framework.base.BaseTest;

//Test cases are executed in sequence for each row in test data file
@Test(groups = "buyProduct")
public class EcomTest2 extends BaseTest{
	private static final Logger log = Logger.getLogger(EcomTest2.class);

	@DataProvider(name = "TD_Ecom")
	public static Iterator<Object[]> TestData_Test_Ecom() {

	}

	private HashMap<String, String> data;

	@Factory(dataProvider = "TD_Ecom")
	public void Test_Ecom(HashMap<String, String> data) {
		log.info("Factory method for Test_Ecom invoked and data about to be initialized");
		this.data = data;
	}

	@Parameters({ "URL" })
	@Test
	public void verifyLaunchEcomApp(String url) {

	}

	@Test(dependsOnMethods = { "verifyLaunchEcomApp" })
	public void verifyNavigationToACategoryUsingMenu() {

	}

	@Test(dependsOnMethods = { "verifyNavigationToACategoryUsingMenu" })
	public void verifyMouseOverParticularDressShowsQuickView() {

	}

	@Test(dependsOnMethods = { "verifyMouseOverParticularDressShowsQuickView" })
	public void verifyProductConfigurationAndAddingToCart() {


	}

	@Test(dependsOnMethods = { "verifyProductConfigurationAndAddingToCart" })
	public void verifyNavigationToCheckoutPage() {


	}

	@Test(dependsOnMethods = { "verifyNavigationToCheckoutPage" })
	public void verifyAccountCreation() {


	}

	@Test(dependsOnMethods = { "verifyAccountCreation" })
	public void verifyOrder() {
	}

}




