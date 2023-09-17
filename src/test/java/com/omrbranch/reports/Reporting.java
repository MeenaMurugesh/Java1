package com.omrbranch.reports;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class Reporting {
public static void generateJvmReport(String jsonFile) {
	File file=new File("C:\\Users\\pravi\\eclipse-workspace\\OmrBranchHotelAutomation\\target");
	Configuration config=new Configuration(file, "OMR Branch Automation");
	config.addClassifications("Browser","chrome");
	config.addClassifications("Browser version","114");
	config.addClassifications("Operating System","Win11");
	config.addClassifications("Sprint","35");
	List<String> JsonFiles=new ArrayList<String>();
	JsonFiles.add(jsonFile);
	ReportBuilder builder=new ReportBuilder(JsonFiles,config);
	builder.generateReports();
}
}
