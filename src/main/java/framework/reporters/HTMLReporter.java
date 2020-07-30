package framework.reporters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class HTMLReporter implements IReporter {

	FileWriter fr;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		File file = new File("/Users/thinker/training/ecommerce/src/main/resources/resultTemplate.html");
		String testResult = "          <tr>\n" + "            <th scope=\"row\">$TestName</th>\n"
				+ "            <td>$TestDescription</td>\n" + "            <td>$Status</td>\n" + "          </tr>";

		try {
			fr = new FileWriter(file, true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String testResultInt = "";
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext testContext = sr.getTestContext();

				for (ITestResult resultMap : testContext.getPassedTests().getAllResults()) {
					System.out.println(resultMap.getName());
					testResultInt = "";
					testResultInt = testResult.replace("$TestName", resultMap.getTestClass().getName());
					testResultInt = testResultInt.replace("$TestDescription", resultMap.getName());
					testResultInt = testResultInt.replace("$Status", "Pass");
					try {
						fr.write(testResultInt);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				for (ITestResult resultMap : testContext.getFailedTests().getAllResults()) {
					System.out.println(resultMap.getName());
					testResultInt = "";
					testResultInt = testResult.replace("$TestName", resultMap.getTestClass().getName());
					testResultInt = testResultInt.replace("$TestDescription", resultMap.getName());
					testResultInt = testResultInt.replace("$Status", "Fail");
					try {
						fr.write(testResultInt);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

		}

		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
