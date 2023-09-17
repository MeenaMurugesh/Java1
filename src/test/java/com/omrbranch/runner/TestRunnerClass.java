package com.omrbranch.runner;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.omrbranch.base.BaseClass;
import com.omrbranch.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(tags="@hotel",publish=true, snippets=SnippetType.CAMELCASE ,plugin = {"pretty", "json:target/index.json" }, stepNotifications= false, dryRun=false, monochrome = true, features="src\\test\\resources\\Features", glue= "com.omrbranch.stepdefinition" )
public class TestRunnerClass extends BaseClass{
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		Reporting.generateJvmReport(getProjectPath()+ getPropertyFileValue("jsonPath"));
	}
}
