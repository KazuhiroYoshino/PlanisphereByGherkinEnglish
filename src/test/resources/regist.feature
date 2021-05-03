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
Feature: Hotel Planisphere Member Regist Feature.

    Scenario: open the regist page.
  	  	When The browser is started in English mode
        Given The webDriver is chosen in "Chrome"
#open Hotel Planisphere TOP page
        Given Page open "https://hotel.testplanisphere.dev/en-US/index.html"
        When  Maximise Window
        Then wait "2" second

		Scenario Outline: Guest user regist and login and withdrawal
    		When Click link "Sign up"
#regist
        And  input <email> into mail address area
        And  input <password> into password area
        And  input <confirm> into confirm password area
        And  input <username> into username area
        And  check <rank> in rank area
        And  input <address> into address area
        And  input <tel> into telephone number area
        And  select <gender> in gender area
        And  input <birthday> in birthday area
        And  check <notification> in notification select
        When push sign up button
        When Logout
        Then wait "1" second

#login with registed account
        When Click link "Login"
        And  input <email> into mail address area
        And  input <password> into password area
        When  push Login button
				Then  Displayed <username> in username area
				Then  Displayed <rank> in membership rank area
				Then  Displayed <address> in address area
				Then  Displayed <tel> in telephone number area
				Then  Displayed <gender> in gender area
				Then  Displayed <birthday> in birthday area
				Then  Displayed <notification> in notification area

#delete account
        When  push Delete Account button
        Then  Displayed "If you cancel your membership, all information will be deleted" by popup message
        Then  Displayed "The process has been completed. Thank you for your service." by popup message

        Then wait "2" second

				Examples:
				|email                |password  |confirm   |username         |rank     |address       |tel          |gender            |birthday    |notification  |
				|"harunobu@example.jp"|"password"|"password"|"Harunobu Takeda"|"Premium"|"Osaka Kadoma"|"01234567890"|"male"            |""          |"received"    |
				|"kagetora@example.jp"|"pass1234"|"pass1234"|"Kagetora Nagao" |"Premium"|"Osaka Kadoma"|"02345678901"|"female"          |"11/12/1960"|"not received"|
				|"kanta@example.jp"   |"passwd00"|"passwd00"|"Kanta Yamamoto" |"Normal" |""            |"03456789012"|"female"          |"11/12/1960"|"received"    |
				|"aiko@example.jp"    |"passpass"|"passpass"|"Aiko Naoe"      |"Normal" |"Osaka Kadoma"|""           |"female"          |"11/12/1960"|"not received"|
				|"masatora@example.jp"|"pass5678"|"pass5678"|"Masatora Sanada"|"Normal" |"Osaka Kadoma"|"04567890123"|"I do not answer."|"11/12/1960"|"received"    |
				|"teruhide@example.jp"|"PassWord"|"PassWord"|"Teruhide Usami" |"Normal" |"Osaka Kadoma"|"05678901234"|"female"          |""          |"not received"|
				|"nobuko@example.jp"  |"PSWORDDD"|"PSWORDDD"|"Nobuko Takeda"  |"Normal" |""            |""           |"other"           |""          |"received"    |


	Scenario Outline: Confirmation of original member
        When Click link "Login"
        And  input <email> into mail address area
        And  input <password> into password area
        When  push Login button
				Then  Displayed <username> in username area
				Then  Displayed <rank> in membership rank area
				Then  Displayed <address> in address area
				Then  Displayed <tel> in telephone number area
				Then  Displayed <gender> in gender area
				Then  Displayed <birthday> in birthday area
				Then  Displayed <notification> in notification area
        When Logout
        Then wait "1" second

					Examples:
				|email              |password   |confirm    |username         |rank     |address                    |tel          |gender            |birthday           |notification  |
				|"clark@example.com"|"password" |"password" |"Clark Evans"    |"Premium"|"Mountain View, California"|"01234567891"|"male"            |""                 |"received"    |
				|"diana@example.com"|"pass1234" |"pass1234" |"Diana Johansson"|"Normal" |"Redmond, Washington"      |""           |"female"          |"01/04/2000"    |"not received"|
				|"ororo@example.com"|"pa55w0rd!"|"pa55w0rd!"|"Ororo Saldana"  |"Premium"|"Cupertino, California"    |"01212341234"|"other"           |"17/12/1988"|"not received"|
				|"miles@example.com"|"pass-pass"|"pass-pass"|"Miles Boseman"  |"Normal" |"not answered"             |"01298765432"|"I do not answer."|"31/08/1992"  |"received"|

	Scenario: test end
#ending
        When close test scenario
