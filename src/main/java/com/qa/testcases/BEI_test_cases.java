package com.qa.testcases;
import org.apache.commons.mail.*;
import java.io.IOException;
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
public class BEI_test_cases extends TestBase {
	TestUtil testUtil;
	//ExcelReader reader;
	AuthPageNavigation authpage;
	ExcelReaderbycolumnname reader;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	String alert_text_message=null;
	String file_path="C:\\Users\\Sindhuja\\Desktop\\bei_testdata.xlsx";

	public void send_email() throws EmailException
	{
		EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("./BulkEmailInvoicesReport/BulkEmailInvoicesReport.html");
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
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/BulkEmailInvoicesReport/BulkEmailInvoicesReport.html");

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
			//test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			//test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		}
		driver.quit();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		testUtil = new TestUtil();
		testUtil.setUp();
	}
	@Test(priority = 4)
	public void bei_testing() throws InterruptedException, IOException
	{
		authpage=new AuthPageNavigation();
		//authpage.required_account("BEI-AR", "Tvarana Dev Production - RP", "RELEASE PREVIEW");
		reader=new ExcelReaderbycolumnname();
		String[] form_date=reader.excelReader(file_path, 7, "form_date");
		String[] to_date=reader.excelReader(file_path, 7, "to_date");
		String[] testcase=reader.excelReader(file_path, 7, "testcase");
		String[] email_ids=reader.excelReader(file_path, 7, "email_ids");
		String [] email2=reader.excelReader(file_path, 7, "email_id2");
		
		for(int i=0;i<form_date.length;i++)
		{
		try
		{
		test = extent.createTest("Testcase is " +testcase[i]);
		BEI_functions bei=new BEI_functions();
		bei.bei_test(form_date[i], to_date[i],testcase[i],email_ids[i],email2[i],test);
		}
		catch (Exception e) 
		{
			test.fail("Exception is: "+e.fillInStackTrace());
		}
		}
		
	}
	@Test( priority = 3)
	public void resend() throws Exception
	{	
		authpage=new AuthPageNavigation();
		//authpage.required_account("BEI-AR", "Tvarana Dev Production - RP", "RELEASE PREVIEW");
		reader=new ExcelReaderbycolumnname();
		String[] form_date=reader.excelReader(file_path, 8, "form_date");
		String[] to_date=reader.excelReader(file_path, 8, "to_date");
	//	String[] due_date=reader.excelReader(file_path, 7, "due_date");
		String[] testcase=reader.excelReader(file_path, 8, "testcase");
		String[] customer_name=reader.excelReader(file_path, 8, "customer_name");
		String[] department=reader.excelReader(file_path, 8, "department");
		String[] location=reader.excelReader(file_path, 8, "location");
		String[] email_ids=reader.excelReader(file_path, 8, "email_ids");
		String[] class1=reader.excelReader(file_path, 8, "class1");
		String [] email2=reader.excelReader(file_path, 8, "email_id2");
		
		for(int i=0;i<form_date.length;i++)
		{
		try
		{
		test = extent.createTest("Testcase is " +testcase[i]);
		BEI_functions bei=new BEI_functions();
		bei.date_range_invoices(form_date[i], to_date[i],testcase[i],customer_name[i],department[i],class1[i],location[i],email_ids[i],email2[i],test);
		}
		catch (Exception e) 
		{
			test.fail("Exception is: "+e.fillInStackTrace());
		}
		}
	}
//
	@Test( priority = 2)
	public void date_range() throws Exception
	{	
		authpage=new AuthPageNavigation();
		//authpage.required_account("BEI-AR", "Tvarana Dev Production - RP", "RELEASE PREVIEW");
		reader=new ExcelReaderbycolumnname();
		String[] form_date=reader.excelReader(file_path, 0, "form_date");
		String[] to_date=reader.excelReader(file_path, 0, "to_date");
		String[] testcase=reader.excelReader(file_path, 0, "testcase");
		String[] customer_name=reader.excelReader(file_path, 0, "customer_name");
		String[] department=reader.excelReader(file_path, 0, "department");
		String[] location=reader.excelReader(file_path, 0, "location");
		String[] email_ids=reader.excelReader(file_path, 0, "email_ids");
		String[] class1=reader.excelReader(file_path, 0, "class1");
		String [] email2=reader.excelReader(file_path, 0, "email_id2");
		
		for(int i=0;i<form_date.length;i++)
		{
		try
		{
		test = extent.createTest("Testcase is " +testcase[i]);
		BEI_functions bei=new BEI_functions();
		bei.date_range_invoices(form_date[i], to_date[i],testcase[i],customer_name[i],department[i],class1[i],location[i],email_ids[i],email2[i],test);
		}
		catch (Exception e) 
		{
			test.fail("Exception is: "+e.fillInStackTrace());
		}
		}
	}
		
		


	@Test(priority = 1)
	public void two_filter() throws Exception
	{	
		authpage=new AuthPageNavigation();
		//authpage.required_account("BEI-AR", "Tvarana Dev Production - RP", "RELEASE PREVIEW");
		reader=new ExcelReaderbycolumnname();	
		String[] customer_name=reader.excelReader(file_path, 6, "customer_name");
		//String[] subsidiary=reader.excelReader(file_path, 5, "subsidiary");
		String[] department=reader.excelReader(file_path, 6, "department");
		String[] location=reader.excelReader(file_path, 6, "location");
		String[] from_date=reader.excelReader(file_path, 6, "from_date");
		String[] to_date=reader.excelReader(file_path, 6, "to_date");
		String[] testcase=reader.excelReader(file_path, 6, "testcase");
		//String[] due_date=reader.excelReader(file_path, 4, "due_date");
		String[] class1=reader.excelReader(file_path, 6, "class");

		for(int i=0;i<customer_name.length;i++)
		{
			try
			{
		test = extent.createTest("Testcase is " +testcase[i]);
		BEI_functions bei=new BEI_functions();
		bei.two_filters(customer_name[i], department[i], class1[i], location[i], from_date[i], to_date[i],testcase[i],test);
		}
			catch(Exception e)
			{
				test.fail("Exception is: "+e.fillInStackTrace());
			}
		}
	}
	@Test(priority = 5)
	public void dashboard() throws Exception
	{		
		authpage=new AuthPageNavigation();
		//authpage.required_account("BEI-AR", "Tvarana Dev Production - RP", "RELEASE PREVIEW");
		reader=new ExcelReaderbycolumnname();
		String[] from_date=reader.excelReader(file_path, 2, "from_date");
		String[] to_date=reader.excelReader(file_path, 2, "to_date");
		String[] testcase=reader.excelReader(file_path, 2, "testcase");
		for(int i=0;i<from_date.length;i++)
		{
		try
		{
		test = extent.createTest("Testcase is " +testcase[i]);
		BEI_functions bei=new BEI_functions();
		bei.dashboard(from_date[i], to_date[i], testcase[i],test);
		}
		catch(Exception e)
		{
			test.fail("Exception is: "+e.fillInStackTrace());
		}
		}
	}





}
				