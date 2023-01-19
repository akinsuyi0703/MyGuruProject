package com.myguruproject.utilities;

import java.awt.Desktop;
//Listener class used to generate extent reports
import java.io.File;
import java.io.IOException;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting extends TestListenerAdapter{
	
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest logger;
	
	
	public static void setUp() throws IOException {
		extent = new ExtentReports();
		File file = new File("report.html");
		spark = new ExtentSparkReporter(file);
		spark.loadXMLConfig(new File("./src/test/resources/extent-config.xml"));
	    extent.attachReporter(spark);
	    //Capabilities capabilities = (()).getCapabilities(); //method for getting the browser name
		
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Java", System.getProperty("java.version"));
		//extent.setSystemInfo("Browser", capabilities.getBrowserName() + ""+capabilities.getBrowserVersion());
		extent.setSystemInfo("OS", System.getProperty("os.name"));



	
	    extent.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());
	
	
}
	
	/*
	 * public void onstart(ITestContext testContext) {
	 * 
	 * ExtentReports extentReports = new ExtentReports();
	 * 
	 * 
	 * 
	 * String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
	 * time stamp String repName="Test-Report-"+timeStamp+".html";
	 * 
	 * spark=new ExtentSparkReporter(System.getProperty("user.dir")+
	 * "/test-output/"+repName);//specify location spark=new
	 * ExtentSparkReporter(System.getProperty("user.dir")+ "/extent-config.xml");
	 * 
	 * extent=new ExtentReports();
	 * 
	 * extent.attachReporter(spark); extent.setSystemInfo("Host name", "localhost");
	 * extent.setSystemInfo("Environment", "QA");
	 * extent.setSystemInfo("user","paul");
	 * 
	 * spark.config().setDocumentTitle("Guru Test Project");// title of report
	 * spark.config().setReportName("Functional Test Automation Report");//name of
	 * the report spark.config().setTheme(Theme.DARK);
	 * 
	 * }
	 * 
	 * public void onTestSuccess(ITestResult tr) {
	 * logger=extent.createTest(tr.getName());//create new entry in the report
	 * logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),
	 * ExtentColor.GREEN));//send the passed information }
	 * 
	 * public void onTestFailure(ITestResult tr) {
	 * //logger=extent.createTest(tr.getName());//create new entry in the report
	 * //logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),
	 * ExtentColor.RED));//send the passed information
	 * 
	 * String screenshotPath=System.getProperty("user.dir")+
	 * "\\Screenshots\\"+tr.getName()+".png";
	 * 
	 * File f = new File(screenshotPath);
	 * 
	 * if(f.exists()) { try { logger.fail("Screenshot is below:" +
	 * logger.addScreenCaptureFromPath(screenshotPath)); } catch(Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * } public void onTestSkipped(ITestResult tr) {
	 * 
	 * logger=extent.createTest(tr.getName());//create new entry in the report
	 * logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),
	 * ExtentColor.ORANGE));//send the passed information }
	 * 
	 * public void onTestFinish(ITestContext testContext) {
	 * 
	 * extent.flush(); Desktop.getDesktop().browse(new File("report.html").toURI());
	 * }
	 */
}

