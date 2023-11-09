#!/bin/sh
echo "------ Step 01: Set project path to variable -------"
project_path="/Users/lap14153/Documents/Automation Test/03 - Hydric Framework Nopcommerce/hydric-framework-nopcommerce"
echo "------ Step 02: Go to project path folder -------"
cd "$project_path"
echo "------ Step 03: Run the testcases -------"
java -javaagent:"$project_path/libAllureReport/aspectjweaver-1.9.8.jar" -classpath "$project_path/bin:$project_path/libAllureReport/*:$project_path/libLog4jver2/*:$project_path/libExtentReport/*:$project_path/libReportNG/*:$project_path/libSelenium/*" org.testng.TestNG "$project_path/resources/RunNopCommerceWeb.xml"
echo "------ Step 04: Load allure command line setting -------"
source ~/.bash_profile
echo "------ Step 05: Generate Allure HTML Report -------"
allure serve ./allure-json/
