package testScripts;

import org.testng.annotations.Test;

import framework.BaseTest;
import framework.Encryption;
import framework.ExcelUtil;

public class EcomTest extends BaseTest{
	
	
	//New code
	@Test
	private void first_test() {
		
//		String BeforeEncryptionName = "selenium";
//		System.out.println("Before encryption: " + BeforeEncryptionName);
//		
//		Encryption.decrypt(strToDecrypt, secret)
//		
//		String AfterEncryptionName = Encryption.encrypt(BeforeEncryptionName, secretKey);
//		
//		
//		System.out.println("After encryption: " + AfterEncryptionName);
//		
//		
//		String AfterDecryptionName = Encryption.decrypt(AfterEncryptionName, secretKey);
//		
//		
//		System.out.println("After decryption: " + AfterDecryptionName);
		
		String value = ExcelUtil.ReadCellData("/Users/thinker/Documents/file_example_XLSX_10.xlsx", 1, 2);
		
		System.out.println(value);
	}
	

}
