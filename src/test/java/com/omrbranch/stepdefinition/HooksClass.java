package com.omrbranch.stepdefinition;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.omrbranch.base.BaseClass;

import io.cucumber.java.*;

public class HooksClass extends BaseClass {
@Before
public void beforeScenario() throws FileNotFoundException, IOException {
	browserLaunch(getPropertyFileValue ("browser"));
	enterAppUrl(getPropertyFileValue("url"));
	maximizeWindow();
	implicity();
	
}
@After
public void afterScnario1(Scenario scenario) throws IOException {
	 if(!scenario.isFailed()) {
		scenario.attach(screenshot(),"images/PNG","Every Scenario");
		
        
	}
	quitWindow();
}

}
