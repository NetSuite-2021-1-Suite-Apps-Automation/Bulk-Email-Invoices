package com.qa.testcases;

import org.apache.commons.mail.*;
import java.io.IOException;
import java.text.ParseException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.excelreader.ExcelReaderbycolumnname;
import com.qa.pages.AuthPageNavigation;
import com.qa.pages.BEI_functions;
import com.qa.util.TestBase;
import com.qa.util.TestUtil;

public class DateRange extends TestBase {
	TestUtil testUtil;
	// ExcelReader reader;
	AuthPageNavigation authpage;
	ExcelReaderbycolumnname reader;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	String alert_text_message = null;
	String file_path = "C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx";

	public void send_email() throws EmailException {
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("./BulkEmailInvoicesReport/BulkEmailInvoicesReport_2.html");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		// attachment.setDescription("Test Report");
		// attachment.setName("Bulk Email Invoices");
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("sindhuja.b@tvarana.com", "Sindhu@123"));
		email.setSSLOnConnect(true);
		email.addTo("sindhuja.b@tvarana.com", "Sindhu");
		email.setFrom("sindhuja.b@tvarana.com", "Sindhuja");
		email.setSubject("Bulk Email Invoice Report");
		email.setMsg("Here is the report please find the attachment");
		email.attach(attachment);
		email.send();
	}

	@BeforeTest
	public void setExtent() {
		// specify location of the report
		htmlReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/BulkEmailInvoicesReport/BulkEmailInvoicesReport_2.html");

		htmlReporter.config().setDocumentTitle("Bulk Email Invoices Report"); // Tile of report
		htmlReporter.config().setReportName("Bulk Email Invoices Test Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		// Passing General information
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Sindhuja");
	}

	@AfterTest
	public void endReport() throws EmailException {
		extent.flush();
		send_email();

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, EmailException {
		if (result.getStatus() == ITestResult.FAILURE) {
			// test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add
			// name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			// test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		testUtil = new TestUtil();
		testUtil.setUp();
	}

//
//		
	@Test(priority = 1)
	public void date_validations() throws Exception
	{	
		authpage=new AuthPageNavigation();
		//authpage.required_account("BEI-AR", "Tvarana Dev Production - RP", "RELEASE PREVIEW");
		reader=new ExcelReaderbycolumnname();
		String[] alphabets=reader.excelReader(file_path, 1,"alphabets");
		String[] special_chars=reader.excelReader(file_path, 1, "special_chars");
		String[] alpha_numerics=reader.excelReader(file_path, 1, "alphanumerics");
		String[] alpha_special_chars=reader.excelReader(file_path, 1, "alpha_special_chars");
		String[] numbers_special_chars=reader.excelReader(file_path, 1, "numbers_special_chars");
		String[] testcase=reader.excelReader(file_path, 1, "testcase");
		String[] to_date_less_than_three_digits=reader.excelReader(file_path, 1, "to_date_less_than_three_digits");
		String[] to_date_greater_than_two_digits=reader.excelReader(file_path, 1, "to_date_greater_than_two_digits");
		String[] from_date=reader.excelReader(file_path, 1, "from_date");
		String[] to_date=reader.excelReader(file_path, 1, "to_date");
		String[] due_date=reader.excelReader(file_path,1, "due_date");
		BEI_functions bei=new BEI_functions();
		bei.required_role("BEI-AR", "Tvarana Dev Production");
		for(int i=0;i<to_date.length;i++)
		{
	try
	{
		test = extent.createTest("Testcase is " +testcase[i]);
		bei.date_validations(alphabets[i], special_chars[i], alpha_numerics[i], alpha_special_chars[i], numbers_special_chars[i], testcase[i], to_date_less_than_three_digits[i], to_date_greater_than_two_digits[i],from_date[i],to_date[i],due_date[i],test);
		}
		catch(Exception e)
		{
			test.fail("Exception is: "+e.fillInStackTrace());
		}
		}
	}
////////
////////	
	@Test(priority = 2)
	public void email_sourcing() throws Exception
	{
		authpage=new AuthPageNavigation();
	//	authpage.required_account("BEI-AR", "Tvarana Dev Production - RP", "RELEASE PREVIEW");
		reader=new ExcelReaderbycolumnname();
		String[] from_date=reader.excelReader(file_path, 3, "from_date");
		String[] to_date=reader.excelReader(file_path, 3, "to_date");
		String[] testcase=reader.excelReader(file_path, 3, "testcase");
		String[] customername=reader.excelReader(file_path, 3, "customername");
		BEI_functions bei=new BEI_functions();
		bei.required_role("BEI-AR", "Tvarana Dev Production");
		for(int i=0;i<from_date.length;i++)
		{
		try
		{
		
		test = extent.createTest("Testcase is " +testcase[i]);
		bei.email_sourcing(from_date[i], to_date[i], testcase[i],customername[i],test);
		}
		catch(Exception e)
		{
			test.fail("Exception is: "+e.fillInStackTrace());
		}
		}
	}
//https://tstdrv939179-rp.app.netsuite.com/app/common/search/search.nl?cu=T&e=T&id=552
//	@Test( priority = 4)

//	
//	
	@Test(priority = 4)
	public void Auto_email() throws Exception {
		authpage = new AuthPageNavigation();
		// authpage.required_account("Administrator", "Tvarana Dev Production - RP",
		// "RELEASE PREVIEW");
		reader = new ExcelReaderbycolumnname();
		String[] before = reader.excelReader(file_path, 4, "days_before_due_date");
		String[] after = reader.excelReader(file_path, 4, "days_after_due_date");
		String[] testcase = reader.excelReader(file_path, 4, "testcase");
		String[] customer = reader.excelReader(file_path, 4, "customer");
		BEI_functions bei = new BEI_functions();
		bei.required_role("Administrator", "Tvarana Dev Production");

		for (int i = 0; i < before.length; i++) {
			try {
				test = extent.createTest("Testcase is " + testcase[i]);
				bei.navigate_to_config(before[i], after[i], testcase[i], customer[i], test);
			} catch (Exception e) {
				test.fail("Exception is: " + e.fillInStackTrace());
			}
		}
	}

	@Test(priority = 3)
	public void auto_email_multi_attach() throws InterruptedException, IOException {
		authpage = new AuthPageNavigation();
		// authpage.required_account("Administrator", "Tvarana Dev Production - RP",
		// "RELEASE PREVIEW");
		reader = new ExcelReaderbycolumnname();
		String[] before = reader.excelReader(file_path, 5, "days_before_due_date");
		String[] after = reader.excelReader(file_path, 5, "days_after_due_date");
		String[] customer = reader.excelReader(file_path, 5, "customer");
		String[] no_of_invoices = reader.excelReader(file_path, 5, "no_of_invoices");
		String[] testcase = reader.excelReader(file_path, 5, "testcase");
		String[] invoices_due_date = reader.excelReader(file_path, 5, "invoices_due_date");
		BEI_functions bei = new BEI_functions();
		bei.required_role("Administrator", "Tvarana Dev Production");
		for (int i = 0; i < before.length; i++) {
			try {
				test = extent.createTest(testcase[i]);

				if (invoices_due_date[i].trim().equals("same")) {
					bei.auto_email_multi_attach_same(before[i], after[i], customer[i], no_of_invoices[i], testcase[i],
							invoices_due_date[i], test);
				} else if (invoices_due_date[i].trim().equals("combination")) {
					bei.auto_email_multi_attach_combo(before[i], after[i], customer[i], no_of_invoices[i], testcase[i],
							invoices_due_date[i], test);
				} else if (invoices_due_date[i].trim().equals("exclude")) {
					bei.auto_email_exclude(before[i], after[i], customer[i], no_of_invoices[i], testcase[i],
							invoices_due_date[i], test);
				} else if (invoices_due_date[i].trim().equals("uncheck")) {
					bei.auto_email_uncheck(before[i], after[i], customer[i], no_of_invoices[i], testcase[i],
							invoices_due_date[i], test);

				} else if (invoices_due_date[i].trim().equals("dunning")) {
					bei.auto_email_dunning(before[i], after[i], customer[i], no_of_invoices[i], testcase[i],
							invoices_due_date[i], test);

				} else {
					bei.auto_email_multi_attach_different(before[i], after[i], customer[i], no_of_invoices[i],
							testcase[i], invoices_due_date[i], test);
				}
			} catch (Exception e) {
				test.fail("Exception is: " + e.fillInStackTrace());
			}
		}

	}

	@Test(priority = 6)
	public void configuration() throws Exception {

		test = extent.createTest("Testcase is display of consolidated invoices in bei screen");
		BEI_functions bei = new BEI_functions();
		bei.consolidate_invoices(test);
	}

//
//	//}
	@Test(priority = 5)
	public void dunning_values_testing()
			throws InterruptedException, IOException, NumberFormatException, ParseException {
		BEI_functions bei = new BEI_functions();
		bei.required_role("Administrator", "Tvarana Dev Production");
		authpage = new AuthPageNavigation();
		reader = new ExcelReaderbycolumnname();
		String[] before = reader.excelReader(file_path, 9, "days_before_due_date");
		String[] after = reader.excelReader(file_path, 9, "days_after_due_date");
		String[] customer = reader.excelReader(file_path, 9, "customer");
		String[] testcase = reader.excelReader(file_path, 9, "testcase");
		for (int i = 0; i < customer.length; i++) {
			test = extent.createTest(testcase[i]);
			bei.dunning_values_functionality(before[i], after[i], customer[i], testcase[i], test);
		}
	}

}
