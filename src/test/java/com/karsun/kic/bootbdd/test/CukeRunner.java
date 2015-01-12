package com.karsun.kic.bootbdd.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = "html:build/cucumber-html-report", 
	features="src/test/resources/features/")
public class CukeRunner {

}
