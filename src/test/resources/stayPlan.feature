#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#language: en

Feature: Reserve Plan List Page

	Background: Guest user can not use premium plan and dinner plan and ecomical plan different from member.

    Scenario: open the regist page.
  	  	When The browser is started in English mode
        Given The webDriver is chosen in "Chrome"
#open Hotel Planisphere TOP page
        Given Page open "https://hotel.testplanisphere.dev/en-US/index.html"
        When  Maximise Window
        Then wait "2" second

	  Scenario: Guest user case
				When Click link "Reserve"
        Then wait "1" second

		Scenario Outline: test of reserve menu list by guest user
				Then Plan name is <displayed> indicated about <Plan name>
			Examples:
				|Plan name                  |displayed|
				|"Plan with special offers" |"yes"|
				|"Premium plan"             |"no"|
				|"With dinner"              |"no"|
				|"Economical"               |"no"|
				|"Staying without meals"    |"yes"|
				|"Business trip"            |"yes"|
				|"With beauty salon"        |"yes"|
				|"With private onsen"       |"yes"|
				|"For honeymoon"            |"yes"|
				|"With complimentary ticket"|"yes"|

		Scenario: return to home
	  		When  Return to HOME


		Scenario: Normal member case
        When Click link "Login"
        And  input "diana@example.com" into mail address area
        And  input "pass1234" into password area
        When  push Login button
    		Then wait "2" second
				When Click link "Reserve"
        Then wait "1" second

		Scenario Outline: test of reserve menu list by Normal member
				Then Plan name is <displayed> indicated about <Plan name>
			Examples:
				|Plan name                  |displayed|
				|"Plan with special offers" |"yes"|
				|"Premium plan"             |"no"|
				|"With dinner"              |"yes"|
				|"Economical"               |"yes"|
				|"Staying without meals"    |"yes"|
				|"Business trip"            |"yes"|
				|"With beauty salon"        |"yes"|
				|"With private onsen"       |"yes"|
				|"For honeymoon"            |"yes"|
				|"With complimentary ticket"|"yes"|

		Scenario: return to home
	  		When  Return to HOME
        When Logout
        Then wait "1" second


		Scenario: Premium member case
        When Click link "Login"
        And  input "clark@example.com" into mail address area
        And  input "password" into password area
        When  push Login button
    		Then wait "2" second
				When Click link "Reserve"
        Then wait "1" second

		Scenario Outline: test of reserve menu list by Premium member
				Then Plan name is <displayed> indicated about <Plan name>
			Examples:
				|Plan name                  |displayed|
				|"Plan with special offers" |"yes"|
				|"Premium plan"             |"yes"|
				|"With dinner"              |"yes"|
				|"Economical"               |"yes"|
				|"Staying without meals"    |"yes"|
				|"Business trip"            |"yes"|
				|"With beauty salon"        |"yes"|
				|"With private onsen"       |"yes"|
				|"For honeymoon"            |"yes"|
				|"With complimentary ticket"|"yes"|

		Scenario: return to home
	  		When  Return to HOME
        When Logout
        Then wait "1" second
				When close test scenario

