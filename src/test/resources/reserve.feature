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

Feature: Reserve feature

	Background: Quotation is different in weekend charge rise application depending on a day of the week in the stay first day and stay terms. An option is extra charge. The total quotation is decided by the stay terms, head counts, and the options.


  Scenario: test config
  	  	When The browser is started in English mode
        Given The webDriver is chosen in "Chrome"
#open Hotel Planisphere TOP page
        Given Page open "https://hotel.testplanisphere.dev/en-US/index.html"
        When  Maximise Window
        Then wait "2" second

	Scenario: Guest user case

	Scenario Outline: The room charge test when being the Guest user
				When Click link "Reserve"
        Then wait "1" second

				When user chooses <Plan name>
        Then wait "1" second

				Then  Get parent and child tabs
				Then  Switch to child tab

				When  user selects the check in day of the week as <First day>
        Then wait "1" second
				When user inputs <Term> as stay
				When user inputs <Head count> as guests
				When user checks <Breakfast> as Breakfast
				When user checks <Early check in> as Early check in
				When user checks <Sight seeing> as Sight seeing
				When user inputs <username> as Name
				And  user selects <Contact> and inputs <tel> as Telephone number or inputs <email> as mail address
				When user inputs <Request> as Special request
				When record the reservation

				Then test Total-Bill <Total price>
				Then test Room-type <Room type>

				When click confirm reservation

				Then test Total-Bill <Total price>
				Then test stay dates
				Then test Guests as <Head count> person
				Then test Additional plans as <Breakfast> or <Early check in> or <Sight seeing>
				Then test Name as <username>
				Then test Confirmation as <Contact> and telephone as <tel> or mailadress as <email>
				Then test Special Request as <Request>

				When click Submit Reservation

				Then test popup message as "Thank you for reserving." and "We look forward to visiting you."
				When click close button
				Then Switch to parent tab
				Then Screen refresh

		Examples:
		|Plan name                  |First day  |Term|Head count|Breakfast|Early check in|Sight seeing|username        |Contact        |tel          |email                |Request |Room type           |Total price|
		|"With beauty salon"        |"Friday"   |"9" |"6"       |"on"     |"on"          |"off"       |"HarunobuTakeda"|"By telephone" |"12345678901"|""                   |"144chr"|"choice room freely"|"5865.00"|
#		|"With beauty salon"        |"Friday"   |"9" |"6"       |"on"     |"on"          |"off"       |"HarunobuTakeda"|"By telephone" |"12345678901"|""                   |"err"   |"choice room freely"|"5855.00"|
		|"With beauty salon"        |"Sunday"   |"1" |"6"       |"off"    |"off"         |"on"        |"MasatoraSanada"|"I don't need."|""           |""                   |"144chr"|"choice room freely"|"735.00"|
		|"With beauty salon"        |"Tuesday"  |"9" |"6"       |"off"    |"on"          |"off"       |"KantaYamamoto" |"By email"     |""           |"kanta@example.jp"   |"off"   |"choice room freely"|"5190.00"|
		|"Plan with special offers" |"Saturday" |"9" |"9"       |"off"    |"off"         |"on"        |"NobukoTakeda"  |"By email"     |""           |"nobutora@example.jp"|"off"   |"Standard Twin"     |"6390.00"|
		|"Plan with special offers" |"Thursday" |"9" |"1"       |"off"    |"off"         |"on"        |"KagetoraNagao" |"By telephone" |"23456789012"|""                   |"off"   |"Standard Twin"     |"675.00"|
		|"Plan with special offers" |"Tuesday"  |"9" |"1"       |"off"    |"on"          |"off"       |"AikoNaoe"      |"I don't need."|""           |""                   |"off"   |"Standard Twin"     |"675.00"|
		|"For honeymoon"            |"Monday"   |"2" |"2"       |"off"    |"off"         |"on"        |"KazumasaUsami" |"By telephone" |"34567890123"|""                   |"144chr"|"Premium Twin"      |"340.00"|
		|"For honeymoon"            |"Saturday" |"2" |"2"       |"off"    |"off"         |"on"        |"IetokiKakizaki"|"I don't need."|""           |""                   |"off"   |"Premium Twin"      |"420.00"|
		|"For honeymoon"            |"Thursday" |"2" |"2"       |"off"    |"off"         |"off"       |"HarunobuTakeda"|"By email"     |""           |"harunobu@example.jp"|"144chr"|"Premium Twin"      |"320.00"|
		|"For honeymoon"            |"Wednesday"|"2" |"2"       |"on"     |"off"         |"off"       |"MasatoraSanada"|"I don't need."|""           |""                   |"off"   |"Premium Twin"      |"360.00"|
		|"With complimentary ticket"|"Friday"   |"5" |"9"       |"on"     |"on"          |"off"       |"KantaYamamoto" |"By telephone" |"45678901234"|""                   |"144chr"|"choice room freely"|"5490.00"|
		|"With complimentary ticket"|"Saturday" |"5" |"1"       |"on"     |"off"         |"off"       |"NobukoTakeda"  |"By telephone" |"56789012345"|""                   |"off"   |"choice room freely"|"600.00"|
		|"With complimentary ticket"|"Tuesday"  |"5" |"1"       |"off"    |"off"         |"off"       |"KagetoraNagao" |"By email"     |""           |"kagetora@example.jp"|"144chr"|"choice room freely"|"525.00"|
		|"With complimentary ticket"|"Wednesday"|"1" |"1"       |"off"    |"off"         |"off"       |"AikoNaoe"      |"I don't need."|""           |""                   |"off"   |"choice room freely"|"100.00"|
		|"Business trip"            |"Thursday" |"1" |"1"       |"on"     |"off"         |"off"       |"KazumasaUsami" |"By email"     |""           |"kazumasa@example.jp"|"off"   |"Single"            |"85.00"|
		|"Business trip"            |"Tuesday"  |"9" |"1"       |"off"    |"off"         |"on"        |"IetokiKakizaki"|"I don't need."|""           |""                   |"144chr"|"Single"            |"722.50"|
		|"Business trip"            |"Wednesday"|"9" |"1"       |"off"    |"on"          |"off"       |"HarunobuTakeda"|"By telephone" |"67890123456"|""                   |"144chr"|"Single"            |"722.50"|
		|"Staying without meals"    |"Thursday" |"1" |"2"       |"on"     |"off"         |"on"        |"MasatoraSanada"|"I don't need."|""           |""                   |"off"   |"Single"            |"150.00"|
		|"With private onsen"       |"Sunday"   |"3" |"1"       |"on"     |"on"          |"off"       |"KantaYamamoto" |"I don't need."|""           |""                   |"144chr"|"choice room freely"|"332.50"|
 		|"With private onsen"       |"Thursday" |"3" |"6"       |"on"     |"off"         |"off"       |"NobukoTakeda"  |"By telephone" |"78901234567"|""                   |"off"   |"choice room freely"|"1935.00"|
		|"With private onsen"       |"Wednesday"|"1" |"6"       |"off"    |"off"         |"on"        |"KagetoraNagao" |"By telephone" |"89012345678"|""                   |"144chr"|"choice room freely"|"600.00"|


	Scenario: Back to the HOME
	  		When  Return to HOME


	Scenario: Normal member
        When Click link "Login"
        And  input "miles@example.com" into mail address area
        And  input "pass-pass" into password area
        When  push Login button
        And get mail address and username and telephonenumber
    		Then wait "2" second

	Scenario Outline: Normal member stay plan test case
				When Click link "Reserve"
        Then wait "1" second

				When user chooses <Plan name>
        Then wait "1" second

				Then  Get parent and child tabs
				Then  Switch to child tab

				When  user selects the check in day of the week as <First day>
        Then wait "1" second
				When user inputs <Term> as stay
				When user inputs <Head count> as guests
				When user checks <Breakfast> as Breakfast
				When user checks <Early check in> as Early check in
				When user checks <Sight seeing> as Sight seeing
				When user inputs <username> as Name
				And  user selects <Contact> and inputs <tel> as Telephone number or inputs <email> as mail address
				When user inputs <Request> as Special request
				When record the reservation

				Then test Total-Bill <Total price>
				Then test Room-type <Room type>

				When click confirm reservation

				Then test Total-Bill <Total price>
				Then test stay dates
				Then test Guests as <Head count> person
				Then test Additional plans as <Breakfast> or <Early check in> or <Sight seeing>
				Then test Name as <username>
				Then test Confirmation as <Contact> and telephone as <tel> or mailadress as <email>
				Then test Special Request as <Request>

				When click Submit Reservation

				Then test popup message as "Thank you for reserving." and "We look forward to visiting you."
				When click close button
				Then Switch to parent tab
				Then Screen refresh

		Examples:
		|Plan name                  |First day  |Term|Head count|Breakfast|Early check in|Sight seeing|username        |Contact        |tel          |email                |Request |Room type           |Total price|
		|"With beauty salon"|"Monday"|"1"|"6"|"off"|"off"|"on"|"Miles Boseman"|"By email"|""|""|"144chr"|"choice room freely"|"600.00"|
#		|"With beauty salon"|"Monday"|"1"|"6"|"off"|"off"|"on"|"Miles Boseman"|"By email"|""|""|"err"|"choice room freely"|"400.00"|
		|"With beauty salon"|"Saturday"|"9"|"6"|"off"|"off"|"off"|"Miles Boseman"|"By email"|""|""|"off"|"choice room freely"|"5400.00"|
		|"With beauty salon"|"Thursday"|"9"|"1"|"on"|"on"|"off"|"Miles Boseman"|"I don't need."|""|""|"off"|"choice room freely"|"955.00"|
		|"Economical"|"Friday"|"9"|"1"|"on"|"on"|"off"|"Miles Boseman"|"By email"|""|""|"off"|"choice room freely"|"685.00"|
		|"Economical"|"Monday"|"1"|"9"|"on"|"on"|"off"|"Miles Boseman"|"I don't need."|""|""|"144chr"|"choice room freely"|"720.00"|
		|"Economical"|"Thursday"|"9"|"1"|"off"|"off"|"on"|"Miles Boseman"|"By email"|""|""|"144chr"|"choice room freely"|"580.00"|
		|"Economical"|"Tuesday"|"1"|"9"|"on"|"on"|"off"|"Miles Boseman"|"I don't need."|""|""|"144chr"|"choice room freely"|"720.00"|
		|"Economical"|"Wednesday"|"1"|"9"|"off"|"off"|"off"|"Miles Boseman"|"By email"|""|""|"off"|"choice room freely"|"540.00"|
		|"Plan with special offers"|"Friday"|"9"|"1"|"on"|"off"|"off"|"Miles Boseman"|"By telephone"|""|""|"off"|"Standard Twin"|"772.50"|
		|"Plan with special offers"|"Sunday"|"1"|"9"|"off"|"on"|"off"|"Miles Boseman"|"I don't need."|""|""|"off"|"Standard Twin"|"877.50"|
		|"Plan with special offers"|"Wednesday"|"9"|"9"|"on"|"off"|"off"|"Miles Boseman"|"By email"|""|""|"off"|"Standard Twin"|"6795.00"|
		|"For honeymoon"|"Sunday"|"2"|"2"|"off"|"off"|"off"|"Miles Boseman"|"By email"|""|""|"144chr"|"Premium Twin"|"360.00"|
		|"For honeymoon"|"Tuesday"|"1"|"2"|"on"|"on"|"on"|"Miles Boseman"|"I don't need."|""|""|"off"|"Premium Twin"|"220.00"|
		|"With dinner"|"Friday"|"3"|"4"|"on"|"off"|"on"|"Miles Boseman"|"I don't need."|""|""|"off"|"choice room freely"|"1350.00"|
		|"With dinner"|"Monday"|"1"|"4"|"off"|"off"|"off"|"Miles Boseman"|"By email"|""|""|"144chr"|"choice room freely"|"340.00"|
		|"With dinner"|"Saturday"|"1"|"1"|"on"|"off"|"on"|"Miles Boseman"|"I don't need."|""|""|"144chr"|"choice room freely"|"126.25"|
		|"With dinner"|"Sunday"|"1"|"4"|"off"|"on"|"on"|"Miles Boseman"|"By email"|""|""|"144chr"|"choice room freely"|"505.00"|
		|"With dinner"|"Tuesday"|"3"|"4"|"off"|"off"|"on"|"Miles Boseman"|"I don't need."|""|""|"144chr"|"choice room freely"|"1060.00"|
		|"With dinner"|"Wednesday"|"3"|"4"|"off"|"on"|"off"|"Miles Boseman"|"I don't need."|""|""|"off"|"choice room freely"|"1060.00"|
		|"With complimentary ticket"|"Sunday"|"5"|"9"|"on"|"on"|"on"|"Miles Boseman"|"By telephone"|""|""|"off"|"choice room freely"|"5355.00"|
		|"Business trip"|"Saturday"|"1"|"1"|"on"|"on"|"off"|"Miles Boseman"|"I don't need."|""|""|"144chr"|"Single"|"113.75"|
		|"Business trip"|"Sunday"|"1"|"1"|"on"|"on"|"off"|"Miles Boseman"|"I don't need."|""|""|"144chr"|"Single"|"113.75"|
		|"Staying without meals"|"Friday"|"1"|"2"|"off"|"off"|"on"|"Miles Boseman"|"By email"|""|""|"144chr"|"Single"|"130.00"|
		|"Staying without meals"|"Monday"|"9"|"1"|"off"|"off"|"off"|"Miles Boseman"|"By telephone"|""|""|"144chr"|"Single"|"522.50"|
		|"Staying without meals"|"Sunday"|"9"|"1"|"off"|"on"|"on"|"Miles Boseman"|"I don't need."|""|""|"144chr"|"Single"|"556.25"|
		|"Staying without meals"|"Wednesday"|"1"|"2"|"off"|"on"|"on"|"Miles Boseman"|"By email"|""|""|"144chr"|"Single"|"150.00"|
		|"With private onsen"|"Friday"|"1"|"6"|"off"|"off"|"on"|"Miles Boseman"|"By telephone"|""|""|"144chr"|"choice room freely"|"600.00"|
		|"With private onsen"|"Monday"|"3"|"6"|"off"|"off"|"on"|"Miles Boseman"|"By email"|""|""|"144chr"|"choice room freely"|"1680.00"|
		|"With private onsen"|"Tuesday"|"1"|"1"|"on"|"on"|"on"|"Miles Boseman"|"I don't need."|""|""|"off"|"choice room freely"|"120.00"|

	Scenario: Normal member Logout
        When Logout
        Then wait "1" second

	Scenario: Back to the HOME
	  		When  Return to HOME


	Scenario: Premium member
        When Click link "Login"
        And  input "clark@example.com" into mail address area
        And  input "password" into password area
        When  push Login button
        And get mail address and username and telephonenumber
    		Then wait "2" second

	Scenario Outline: Premium member stay plan test case
				When Click link "Reserve"
        Then wait "1" second

				When user chooses <Plan name>
        Then wait "1" second

				Then  Get parent and child tabs
				Then  Switch to child tab

				When  user selects the check in day of the week as <First day>
        Then wait "1" second
				When user inputs <Term> as stay
				When user inputs <Head count> as guests
				When user checks <Breakfast> as Breakfast
				When user checks <Early check in> as Early check in
				When user checks <Sight seeing> as Sight seeing
				When user inputs <username> as Name
				And  user selects <Contact> and inputs <tel> as Telephone number or inputs <email> as mail address
				When user inputs <Request> as Special request
				When record the reservation

				Then test Total-Bill <Total price>
				Then test Room-type <Room type>

				When click confirm reservation

				Then test Total-Bill <Total price>
				Then test stay dates
				Then test Guests as <Head count> person
				Then test Additional plans as <Breakfast> or <Early check in> or <Sight seeing>
				Then test Name as <username>
				Then test Confirmation as <Contact> and telephone as <tel> or mailadress as <email>
				Then test Special Request as <Request>

				When click Submit Reservation

				Then test popup message as "Thank you for reserving." and "We look forward to visiting you."
				When click close button
				Then Switch to parent tab
				Then Screen refresh

		Examples:
		|Plan name                  |First day  |Term|Head count|Breakfast|Early check in|Sight seeing|username        |Contact        |tel          |email                |Request |Room type           |Total price|
		|"With beauty salon"        |"Wednesday"|"9" |"1"       |"on"     |"on"          |"off"       |"Clark Evans"   |"By telephone" |"01234567891"|""                   |""      |"choice room freely"|"955.00"|
#		|"With beauty salon"|"Wednesday"|"9"|"1"|"on"|"on"|"off"|"Clark Evans"|"By telephone"|""|""|"err"|"choice room freely"|"905.00"|
		|"Economical"|"Saturday"|"1"|"9"|"off"|"on"|"on"|"Clark Evans"|"I don't need."|""|""|"off"|"choice room freely"|"855.00"|
		|"Economical"|"Sunday"|"9"|"1"|"on"|"on"|"off"|"Clark Evans"|"By telephone"|""|""|"off"|"choice room freely"|"685.00"|
		|"Plan with special offers"|"Monday"|"1"|"1"|"on"|"on"|"on"|"Clark Evans"|"I don't need."|""|""|"144chr"|"Standard Twin"|"100.00"|
		|"For honeymoon"|"Friday"|"2"|"2"|"off"|"on"|"on"|"Clark Evans"|"I don't need."|""|""|"144chr"|"Premium Twin"|"400.00"|
		|"For honeymoon"|"Tuesday"|"2"|"2"|"on"|"on"|"on"|"Clark Evans"|"By telephone"|""|""|"144chr"|"Premium Twin"|"400.00"|
		|"With dinner"|"Saturday"|"1"|"4"|"off"|"off"|"on"|"Clark Evans"|"By email"|""|""|"off"|"choice room freely"|"465.00"|
		|"With dinner"|"Thursday"|"3"|"4"|"on"|"on"|"off"|"Clark Evans"|"By telephone"|""|""|"off"|"choice room freely"|"1265.00"|
		|"With complimentary ticket"|"Monday"|"5"|"1"|"on"|"on"|"off"|"Clark Evans"|"By email"|""|""|"144chr"|"choice room freely"|"560.00"|
		|"With complimentary ticket"|"Thursday"|"5"|"1"|"off"|"off"|"off"|"Clark Evans"|"I don't need."|""|""|"144chr"|"choice room freely"|"550.00"|
		|"With complimentary ticket"|"Wednesday"|"5"|"1"|"off"|"off"|"on"|"Clark Evans"|"By telephone"|""|""|"144chr"|"choice room freely"|"560.00"|
		|"Premium plan"|"Friday"|"9"|"9"|"on"|"on"|"off"|"Clark Evans"|"I don't need."|""|""|"144chr"|"Premium Twin"|"9675.00"|
		|"Premium plan"|"Monday"|"1"|"9"|"on"|"on"|"on"|"Clark Evans"|"By email"|""|""|"off"|"Premium Twin"|"1170.00"|
		|"Premium plan"|"Saturday"|"1"|"9"|"on"|"off"|"on"|"Clark Evans"|"By telephone"|""|""|"144chr"|"Premium Twin"|"1305.00"|
		|"Premium plan"|"Sunday"|"9"|"9"|"on"|"off"|"off"|"Clark Evans"|"By telephone"|""|""|"off"|"Premium Twin"|"9585.00"|
		|"Premium plan"|"Thursday"|"1"|"9"|"off"|"on"|"off"|"Clark Evans"|"I don't need."|""|""|"144chr"|"Premium Twin"|"990.00"|
		|"Premium plan"|"Tuesday"|"1"|"2"|"off"|"off"|"on"|"Clark Evans"|"By telephone"|""|""|"off"|"Premium Twin"|"220.00"|
		|"Premium plan"|"Wednesday"|"9"|"9"|"off"|"on"|"off"|"Clark Evans"|"By email"|""|""|"144chr"|"Premium Twin"|"8640.00"|
		|"Business trip"|"Friday"|"1"|"1"|"off"|"on"|"on"|"Clark Evans"|"By email"|""|""|"144chr"|"Single"|"95.00"|
		|"Business trip"|"Monday"|"9"|"2"|"on"|"on"|"off"|"Clark Evans"|"By email"|""|""|"off"|"Single"|"1625.00"|
		|"Staying without meals"|"Saturday"|"9"|"2"|"off"|"off"|"off"|"Clark Evans"|"By email"|""|""|"144chr"|"Single"|"1100.00"|
		|"Staying without meals"|"Tuesday"|"1"|"1"|"off"|"off"|"on"|"Clark Evans"|"I don't need."|""|""|"144chr"|"Single"|"65.00"|
		|"With private onsen"|"Saturday"|"3"|"6"|"on"|"on"|"off"|"Clark Evans"|"By telephone"|""|""|"off"|"choice room freely"|"2130.00"|

	Scenario: Premium member Logout
        When Logout
        Then wait "1" second

	Scenario: Back to the HOME
	  		When  Return to HOME


	Scenario: test end
        #終了処理
				When close test scenario
