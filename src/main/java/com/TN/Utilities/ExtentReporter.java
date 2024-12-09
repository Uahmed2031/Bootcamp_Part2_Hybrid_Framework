package com.TN.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() throws Exception {

		ExtentReports extentReport = new ExtentReports();

		File extentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentreporter.html");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TN Automation Hybrid Results");
		sparkReporter.config().setDocumentTitle("ReportTitle | BootCamp_Part2_Hybrid_Framework");

		extentReport.attachReporter(sparkReporter);

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\TN\\Config\\config.properties");
		prop.load(ip);

		extentReport.setSystemInfo("application url", prop.getProperty("url"));
		extentReport.setSystemInfo("email", prop.getProperty("validEmail"));
		extentReport.setSystemInfo("password", prop.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System", prop.getProperty("os.name"));
		extentReport.setSystemInfo("application url", prop.getProperty("url"));
		extentReport.setSystemInfo("Tester Responsible", prop.getProperty("user.name"));
		extentReport.setSystemInfo("Java version", prop.getProperty("java.version"));

		return extentReport;

	}
}
