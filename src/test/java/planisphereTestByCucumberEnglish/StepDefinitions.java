package planisphereTestByCucumberEnglish;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
    private WebConnector connector = new WebConnector();

    private String reserveType;
    private String contactType;
    private int weekEnd;
    private int termValue;
    private int termValueWeekEnd;
    private String comment144 = "123456789ABC123456789ABC123456789ABC123456789ABC123456789ABC123456789ABC123456789ABC123456789ABC123456789ABC123456789ABC123456789ABC12345678";

    private static String mobileBrowserType;
    private static String mobileUrl;
    private static String id;
    private static String passwd;

    /**
     * 会員登録済みユーザーは、マイページから氏名と電話番号を確認できる
     * ただし、電話番号は任意
     */
        private static String memberName;
        private static String memberTel;
        private static String memberMail;
//    public void WebSteps(WebConnector connector) {
//        this.connector = connector;
//    }

/**
 * 使用するWebドライバを指定する
 * @param browserType　Webドライバ名称
 * 　　　　　 "IE", "Edge", "FireFox", "Opera", "Chrome"
 * 　　ただし、Edge はまともに動きません
 * @throws InterruptedException
 * @throws MalformedURLException
 */
	@Given("^The webDriver is chosen in \"([^\"]*)\"$")
    public void select_webdriver(String browserType) throws InterruptedException, MalformedURLException {
		mobileBrowserType = browserType;
		connector.selectWebDriver(browserType);
    }

/**
 * 指定したURLを表示します
 * @param url　表示するURL
 * @throws InterruptedException
 */
    @Given("^Page open \"([^\"]*)\"$")
    public void display_url(String url) throws InterruptedException {
    	mobileUrl = url;
        connector.openAndWait(url);
    }

    @When("^Maximise Window$")
    public void window_maximized() throws InterruptedException {
        connector.setWindowMax();
    }

    @When("^The browser is started in English mode$")
    public void englishMode() {
  	  connector.setLangEnglish();
    }

    @When("ブラウザを日本語モードにする$")
    public void japaneseMode() {
  	  connector.setlangJapanese();
    }

    @Then("^Screen refresh$")
    public void refresh() throws InterruptedException {
    	connector.refresh();
    }

    @When("\"([^\"]*)\"で指定できるカレンダー表示を消して")
    public void eraseCalendar(String name) throws InterruptedException {
    	connector.btnClickAndWait_X(name);
    }

    @When("^Return to HOME$")
    public void toHome() {
    	String href = "./index.html";

    	connector.clickHrefAndWait(href);
    }

    @When("^push Login button$")
    public void logIn() throws InterruptedException {
    	String selector = "login-button";

    	connector.btnClickAndWait_ID(selector);
    }

    @When("^Logout$")
    public void logOut() throws InterruptedException {
    	String selector = "#logout-form > button";

    	connector.btnClickAndWait_CSS(selector);
    }

    @When("^record the reservation$")
    public void reserveRec() throws InterruptedException {
    	String selector1 = "username";
    	String selector2 = "contact";

    	contactType = connector.getReserveUser(selector1, selector2);

        if(contactType.equals("By email")) {
        	String selector3 = "email";
        	connector.email = connector.getText(selector3);
        }else if(contactType.equals("By telephone")) {
        	String selector4 = "tel";
        	connector.tel = connector.getText(selector4);
        }

    }

    @When("^close test scenario$")
    public void close() {
        connector.destroySelenium();
    }

/**　待機 */
    @Then("^wait \"([^\"]*)\" second$")
    public void wait(int sec) {
        connector.sleep(sec);
    }

/**  Window切り替え **/
    @Then("^Get parent and child tabs$")
    public void parentAndChild() {
    	connector.setWindow();
    }

    @Then("^Switch to parent tab$")
    public void parent() {
    	connector.setParent();
    }

    @Then("^Switch to child tab$")
    public void child() {
    	connector.setChild();
    }

/**
 *  クリックイベント各種
 */

/**
 * 予約内容を確認するボタン
 * @throws InterruptedException
 */
    @When("^click confirm reservation$")
    public void confirmReserveButton() throws InterruptedException {
    	String selector = "submit-button";

    	connector.btnClickAndWait_ID(selector);
    }

/**
 * この内容で確認するボタン
 * @throws InterruptedException
 */
    @When("^click Submit Reservation$")
    public void clickReserveButton() throws InterruptedException {
    	String selector = "//button[@type='button']";

    	connector.btnClickAndWait_X(selector);
    }

/**
 * 閉じるボタン
 * @throws InterruptedException
 */
    @When("^click close button$")
    public void clickCloseButton() throws InterruptedException {
    	String selector = "(//button[@type='button'])[3]";

    	connector.btnClickAndWait_X(selector);
    }

    /**
     * spanタグセレクタのクリックイベント
     * @param text spanタグで括られたテキストを指定する
     */
    @When("ラベル\"([^\"]*)\"をクリックする$")
    public void span_click(String text) {
        connector.spanClickAndWait("span", text);
    }

    @When("^Click link \"([^\"]*)\"$")
    public void link_click(String text) throws InterruptedException {
//		System.out.println(text);
        connector.linkClickAndWait(text);
    }

    @When("^push sign up button$")
    public void clickRegistButton() throws InterruptedException {
    	String selector = "button.btn.btn-primary.btn-block";

    	connector.btnClickAndWait_CSS(selector);
    }

    @When("^push Delete Account button$")
    public void clickWithdrawal() throws InterruptedException {
    	String selector = "button.btn.btn-danger.btn-block.my-3";

    	connector.btnClickAndWait_CSS(selector);
    }

    /**
     * aタグセレクタのクリックイベント
     * @param href aタグの アンカー(href)を指定する
     */
//    @When("アンカー\"([^\"]*)\"をクリックする$")
//    public void anchor_click(String href) {
//        connector.clickHrefAndWait(href);
//    }

    /**
     * input type="button"タグセレクタのクリックイベント
     * @param name ボタンのテキスト(value)を指定する
     */
//    @When("ボタン\"([^\"]*)\"をクリックする$")
//    public void button_click(String name) {
//        connector.btnClickAndWait(name);
//    }

    /**
     * input type="button"タグセレクタのクリックイベント
     * @param name ボタンのテキスト(value)を指定する
     */
//    @And("Andボタン\"([^\"]*)\"をクリックする$")
//    public void and_button_click(String name) {
//        connector.btnClickAndWait(name);
//    }

    /**
     * 複数のinput type="submit" or "button"タグセレクタのnameの名前を持つ
     * ボタンクリックイベント
     * @param name ボタンのテキスト(value)を指定する
     * @param type ボタンのタイプ(button or submitを期待)を指定する
     */
//    @When("名前が\"([^\"]*)\"のボタン\"([^\"]*)\"をクリックする$")
//    public void something_button_click(String name, String type) {
//        connector.btnClickAndWait(type, name);
//    }

    /**
     * 規則的に並ぶ複数のinput type="submit" or "button"タグセレクタのnameの名前を持つ
     * ボタンクリックイベント
     * @param name ボタンのテキスト(value)を指定する
     * @param type ボタンのタイプ(button or submitを期待)を指定する
     * @param index ボタンの配列の順番を指定する(1 origin)
     */
//    @When("名前が\"([^\"]*)\"の\"([^\"]*)\"番目のボタンをクリックする$")
//    public void index_button_click(String value, String type, int index ) {
//        connector.btnByblockClickAndWait(type, value, index-1);
//    }

//    @Then("CSSセレクタ名が\"([^\"]*)\"のボタンをクリックする$")
//    public void css_button_click(String commandLocater) throws InterruptedException {
//    	connector.btnClickAndWait_CSS(commandLocater);
//    }

//    @Then("IDセレクタ名が\"([^\"]*)\"のボタンをクリックする$")
//    public void css_button_clickID(String commandLocater) throws InterruptedException {
//    	connector.btnClickAndWait_ID(commandLocater);
//    }

//    @When("CSSセレクタ名が\"([^\"]*)\"のボタンをクリックしてポップアップ表示を出す$")
//    public void css_buttonClickAndPopUp(String commandLocater) throws InterruptedException {
//    	connector.cssButtonClickAndPopUp(commandLocater);
//    }

/**
 * 画面から取得系
 * @throws InterruptedException
 */
    @And("^get mail address and username and telephonenumber$")
    public void getMemberInfo() throws InterruptedException {
      	String selector;

       	selector = "username";
       	memberName = connector.getString(selector);

       	selector = "email";
       	memberMail = connector.getString(selector);

       	selector = "tel";
       	memberTel = connector.getString(selector);
       	if(memberTel.equals("not answered")) {
       		memberTel = null;
       	}
    }

/** 入力系 */

    @When("^user chooses \"([^\"]*)\"$")
    public void planSelect(String plan) {
    	String commandLocater;
    	switch(plan) {
    	case("Plan with special offers"):
    		commandLocater = "./reserve.html?plan-id=0";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "Plan with special offers";
    		break;
    	case("Premium plan"):
    		commandLocater = "./reserve.html?plan-id=1";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "Premium plan";
    		break;
    	case("With dinner"):
    		commandLocater = "./reserve.html?plan-id=2";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "With dinner";
    		break;
    	case("Economical"):
    		commandLocater = "./reserve.html?plan-id=3";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "Economical";
    		break;
    	case("Staying without meals"):
    		commandLocater = "./reserve.html?plan-id=4";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "Staying without meals";
    		break;
    	case("Business trip"):
    		commandLocater = "./reserve.html?plan-id=5";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "Business trip";
    		break;
    	case("With beauty salon"):
    		commandLocater = "./reserve.html?plan-id=6";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "With beauty salon";
    		break;
    	case("With private onsen"):
    		commandLocater = "./reserve.html?plan-id=7";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "With private onsen";
    		break;
    	case("For honeymoon"):
    		commandLocater = "./reserve.html?plan-id=8";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "For honeymoon";
    		break;
    	case("With complimentary ticket"):
    		commandLocater = "./reserve.html?plan-id=9";
    		connector.clickHrefAndWait(commandLocater);
    		reserveType = "With complimentary ticket";
    		break;
    	default:
    		commandLocater = "./reserve.html?plan-id=0";
    		connector.clickHrefAndWait(commandLocater);
    	}
    }

    @When("^user selects the check in day of the week as \"([^\"]*)\"$")
    public void fromDay(String startDay) throws InterruptedException {
    	String commandLocater = "date";

    	switch(startDay) {
    	case("Sunday"):
            connector.sundayEN(commandLocater);
            weekEnd = 0;
            connector.dateFromSet();
            break;
    	case("Monday"):
            connector.mondayEN(commandLocater);
            weekEnd = 0;
            connector.dateFromSet();
            break;
    	case("Tuesday"):
            connector.tuesdayEN(commandLocater);
            weekEnd = 0;
            connector.dateFromSet();
            break;
    	case("Wednesday"):
            connector.wednesdayEN(commandLocater);
            weekEnd = 0;
            connector.dateFromSet();
            break;
    	case("Thursday"):
            connector.thursdayEN(commandLocater);
            weekEnd = 0;
            connector.dateFromSet();
            break;
    	case("Friday"):
            connector.fridayEN(commandLocater);
            weekEnd = 0;
            connector.dateFromSet();
            break;
    	case("Saturday"):
            connector.saturdayEN(commandLocater);
            weekEnd = 0;
            connector.dateFromSet();
            break;
        default:
    	}

    	String commandLocater2 = "//div[@id='ui-datepicker-div']/div[2]/button";
    	connector.btnClickAndWait_X(commandLocater2);
    }

    @When("^user inputs \"([^\"]*)\" as stay$")
    public void termSetting(String termText) {
    	String commandLocater = "term";

        termValue = Integer.valueOf(termText) - weekEnd;
        termValueWeekEnd = weekEnd;
        int term = termValue + termValueWeekEnd;
        connector.inputAndWait(commandLocater, termText);
        connector.termSetEN(term);
    }

    @When("^user inputs \"([^\"]*)\" as guests$")
    public void headSetting(String headText) {
    	String commandLocater = "head-count";

    	connector.headCountValue = Integer.valueOf(headText);
    	connector.inputAndWait(commandLocater, headText);
    }

    @When("^user checks \"([^\"]*)\" as Breakfast$")
    public void breakFastSetting(String breakfast) throws InterruptedException {
    	String commandLocater = "breakfast";

    	connector.checkBoxClick(commandLocater, breakfast);
    }

    @When("^user checks \"([^\"]*)\" as Early check in$")
    public void earlySetting(String earlyset) throws InterruptedException {
    	String commandLocater = "early-check-in";

    	connector.checkBoxClick(commandLocater, earlyset);
    }

    @When("^user checks \"([^\"]*)\" as Sight seeing$")
    public void sightSeeingSetting(String seeing) throws InterruptedException {
    	String commandLocater = "sightseeing";

    	connector.checkBoxClick(commandLocater, seeing);
    }

    @When("^user inputs \"([^\"]*)\" as Name$")
    public void nameSetting(String name) throws InterruptedException {
    	String commandLocater = "username";

    	connector.inputAndWait(commandLocater, name);
    }

    @And("^user selects \"([^\"]*)\" and inputs \"([^\"]*)\" as Telephone number or inputs \"([^\"]*)\" as mail address$")
    public void contactSet(String contact, String tel, String email) throws InterruptedException {
    	String selector1 = "contact";
    	String selector2 = "tel";
    	String selector3 = "email";
    	String existChr;

    	connector.dropDownSelect(selector1, contact);
    	contactType = contact;
    	Thread.sleep(1000);
    	switch(contact) {
    	case("By telephone"):
    		existChr = connector.getText(selector2);
    		if((tel.length() != 0)&&(existChr.length() == 0)) {
    			connector.inputAndWait(selector2, tel);
    		}
    		break;
    	case("By email"):
    		existChr = connector.getText(selector3);
        	if((email.length() != 0)&&(existChr.length() == 0)) {
        		connector.inputAndWait(selector3, email);
        	}
    		break;
    	default:
    	}
    }

    @And("連絡手段を\"([^\"]*)\"にして$")
    public void contactSetting(String contact) throws InterruptedException {
    	String commandLocater = "contact";

    	connector.dropDownSelect(commandLocater, contact);
    	contactType = contact;
    }

    @And("電話番号を\"([^\"]*)\"にして$")
    public void telSetting(String tel) {
    	String commandLocater = "tel";

    	connector.inputAndWait(commandLocater, tel);
    }

    @And("^input \"([^\"]*)\" into mail address area$")
    public void mailSetting(String email) {
    	String selector = "email";

    	id = email;
    	connector.inputAndWait(selector, email);
    }

    @And("^input \"([^\"]*)\" into password area$")
    public void passSetting(String pass) {
    	String selector = "password";

    	passwd = pass;
    	connector.inputAndWait(selector, pass);
    }

    @And("^input \"([^\"]*)\" into confirm password area$")
    public void passReSetting(String pass) {
    	String selector = "password-confirmation";

    	connector.inputAndWait(selector, pass);
    }

    @And("^input \"([^\"]*)\" into username area$")
    public void inputName(String name) {
    	String selector = "username";

    	connector.inputAndWait(selector, name);
    }

    @And("^check \"([^\"]*)\" in rank area$")
    public void setRank(String rank) throws InterruptedException {
    	String selector = null;

    	switch(rank) {
    	case("Premium"):
    		selector = "rank-premium";
    		break;
    	case("Normal"):
    		selector = "rank-normal";
    		break;
    	default:
    	}

    	connector.btnClickAndWait_ID(selector);
    }

    @And("^input \"([^\"]*)\" into address area$")
    public void setAddress(String address) {
    	String selector = "address";

    	connector.inputAndWait(selector, address);
    }

    @And("^input \"([^\"]*)\" into telephone number area$")
    public void setTel(String tel) {
    	String selector = "tel";

    	connector.inputAndWait(selector, tel);
    }

    @And("^select \"([^\"]*)\" in gender area$")
    public void setGender(String gender) throws InterruptedException {
    	String selector = "gender";

    	connector.dropDownSelect(selector, gender);
    }

    @And("^input \"([^\"]*)\" in birthday area$")
    public void inputBirthday(String birthday) throws InterruptedException {
    	String selector = "birthday";

    	connector.birthdayInputEN(selector, birthday);
    }

    @And("^check \"([^\"]*)\" in notification select$")
    public void setNoyification(String notice) throws InterruptedException {
    	String selector = "notification";
    	String state = null;

    	switch(notice) {
    	case("received"):
    		state = "on";
    		break;
    	case("not received"):
    		state = "off";
    		break;
    	default:
    	}

    	connector.checkBoxClick(selector, state);
    }

    @When("^user inputs \"([^\"]*)\" as Special request$")
    public void comentSetting(String comment) {
    	String selector = "comment";

    	if(comment.equals("144chr")) {
    		comment = comment144;
        	connector.inputAndWait(selector, comment);
    	}
    }

    /**
     * id or nameのセレクタに文字を入力する
     * @param selector id or name セレクタ名
     * @param val 入力する値
     */
//    @When("\"([^\"]*)\"要素に\"([^\"]*)\"と入力する$")
//    public void input_element(String selector, String val) {
//        connector.inputAndWait(selector,val);
//    }

    /**
     * 入力要素に Enter キーを入力する
     * @param selector id or name セレクタ名
     */
//    @When("\"([^\"]*)\"要素にEnterを入力する$")
//    public void input_enter_element(String selector) {
//        connector.inputEnterAndWait(selector);
//    }

    /**
     * 入力要素に Enter キーを入力する
     * @param selector id or name セレクタ名
     */
//    @And("And\"([^\"]*)\"要素にEnterを入力する$")
//    public void and_enter_element(String selector) {
//        connector.inputEnterAndWait(selector);
//    }

    /**
     * id or nameのセレクタに文字を入力する
     * @param selector id or name セレクタ名
     * @param val 入力する値
     */
//    @And("And\"([^\"]*)\"要素に\"([^\"]*)\"と入力する$")
//    public void and_input_element(String selector, String val) {
//        connector.inputAndWait(selector,val);
//    }

//    @When("年月日要素\"([^\"]*)\"に\"([^\"]*)\"を入力する$")
//    public void birthdayInput(String selector, String birthday) throws InterruptedException {
//    	connector.birthdayInput(selector, birthday);
//    }



/** チェックボックスのクリックイベント
 * @throws InterruptedException */
    @When("チェックボックス\"([^\"]*)\"をクリックする$")
    public void checkBox_click(String check) throws InterruptedException {
//    	connector.checkBoxClick(check);
    }

/** ドロップダウンメニュー */
    @When("ドロップダウン\"([^\"]*)\"から\"([^\"]*)\"を選択する$")
    public void dropDown_select(String dropDown, String selText) throws InterruptedException {
    	connector.dropDownSelect(dropDown, selText);;
    }


/** スクリーンショット */
//    @Then("ファイル名「([^\"]*)」でスクリーンショットを保存する$")
//    public void screen_shot(String filename) {
//        connector.getScreenShot(filename);
//    }

//    @When("画面に「([^\"]*)」と表示されていなければ、ファイル名「([^\"]*)」でスクリーンショットを保存する$")
//    public void not_indicated_check(String pattern, String filename) {
//        if(!connector.isTextPresent(pattern)) {
//            connector.getScreenShot(filename);
//            connector.destroySelenium();
//        }
//    }

/**
 * 検証系
 */

/**
* 表示結果のチェック
     * @param pattern 検索するテキスト
     */
    @Then("画面に\"([^\"]*)\"と表示されていること$")
    public void search_text(String pattern) {
        assertTrue(connector.isTextPresent(pattern));
    }

	@Then("^Displayed \"([^\"]*)\" in username area$")
	public void checkName(String username) throws InterruptedException {
		String selector = "username";

		assertTrue(connector.testText(selector, username));
	}

	@Then("^Displayed \"([^\"]*)\" in membership rank area$")
	public void checkRank(String rank) throws InterruptedException {
		String selector = "rank";

		assertTrue(connector.testText(selector, rank));
	}

	@Then("^Displayed \"([^\"]*)\" in address area$")
	public void checkAddress(String address) throws InterruptedException {
		String selector = "address";

		if(address.length() != 0) {
			assertTrue(connector.testText(selector, address));
		}
	}

	@Then("^Displayed \"([^\"]*)\" in telephone number area$")
	public void checkTel(String tel) throws InterruptedException {
		String selector = "tel";

		if(tel.length() != 0) {
			assertTrue(connector.testText(selector, tel));
		}else {
			assertTrue(connector.testText(selector, "not answered"));
		}
	}

	@Then("^Displayed \"([^\"]*)\" in gender area$")
	public void checkGender(String gender) throws InterruptedException {
		String selector = "gender";

		if(gender.length() != 0) {
			if(gender.equals("I do not answer.")) {
				gender = "not answered";
			}
			assertTrue(connector.testText(selector, gender));
		}
	}

	@Then("^Displayed \"([^\"]*)\" in birthday area$")
	public void checkBirthday(String birthday) throws InterruptedException {
		String selector = "birthday";
		String testBirthday;
		int birthYear;
		int birthMonth;
		String birthMonthChr = null;
		int birthDate;

		if(birthday.length() != 0) {
			birthDate = Integer.valueOf(birthday.substring(0, 2));
			birthMonth = Integer.valueOf(birthday.substring(3, 5));
			birthYear = Integer.valueOf(birthday.substring(6, 10));

			switch(birthMonth) {
			case(1):
				birthMonthChr = "January";
				break;
			case(2):
				birthMonthChr = "Feburary";
				break;
			case(3):
				birthMonthChr = "March";
				break;
			case(4):
				birthMonthChr = "April";
				break;
			case(5):
				birthMonthChr = "May";
				break;
			case(6):
				birthMonthChr = "June";
				break;
			case(7):
				birthMonthChr = "July";
				break;
			case(8):
				birthMonthChr = "August";
				break;
			case(9):
				birthMonthChr = "September";
				break;
			case(10):
				birthMonthChr = "October";
				break;
			case(11):
				birthMonthChr = "Novenber";
				break;
			case(12):
				birthMonthChr = "December";
				break;
			}

			testBirthday = birthMonthChr + " " + String.valueOf(birthDate) + ", " + String.valueOf(birthYear);
			assertTrue(connector.testText(selector, testBirthday));
		}else {
			assertTrue(connector.testText(selector, "not answered"));
		}

	}

	@Then("^Displayed \"([^\"]*)\" in notification area$")
	public void checkNotice(String notice) throws InterruptedException {
		String selector = "notification";

		assertTrue(connector.testText(selector, notice));
	}

    @Then("^Displayed \"([^\"]*)\" by popup message$")
    public void search_popUp(String pattern) throws InterruptedException {
    	assertTrue(connector.isPopUpPresent(pattern));
    }

    @Then("ページタイトルが\"([^\"]*)\"である$")
    public void test_page_title(String title) {
  	  assertTrue(connector.isTitlePresent(title));
    }

    @Then("^Plan name is \"([^\"]*)\" indicated about \"([^\"]*)\"$")
    public void test_ContentsList(String hyouji, String planName) throws InterruptedException {
    	String selector = "card-title";

    	assertTrue(connector.checkContensList(selector, planName, hyouji));
    }

    @Then("^test Total-Bill \"([^\"]*)\"$")
    public void testPrice(String price) throws InterruptedException, MalformedURLException {
    	String selector = "total-bill";
    	boolean res;

        res = connector.testPriceEN(selector, Double.valueOf(price));
        if(res == true) {
        	assertTrue(res);
        }else {
        	connector.destroySelenium();
        	Thread.sleep(2000);
        	connector.setLangEnglish();
        	connector.rebootBrowser(mobileBrowserType,mobileUrl);
        	connector.setWindowMax();
        	if(id != null) {
        		connector.linkClickAndWait("Login");
        		Thread.sleep(1000);
        		selector = "email";
        		connector.inputAndWait(selector, id);
        		selector = "password";
        		connector.inputAndWait(selector, passwd);
            	selector = "login-button";
            	connector.btnClickAndWait_ID(selector);
        	}
        	Thread.sleep(1000);
        	connector.linkClickAndWait("Reserve");
        	assertTrue(res);
        }
        	Thread.sleep(1000);
    }

    @Then("^test Room-type \"([^\"]*)\"$")
    public void testRoomType(String roomType) throws InterruptedException {
    	String selector = "room-info";
    	String commandLocater;

        	switch(reserveType) {
        	case("Plan with special offers"):
        		commandLocater = "room";
        		selector = "/html/body/div/div[1]/div/h5";
        		connector.switchFrame(commandLocater);
        		assertTrue(connector.testTextX(selector, roomType));
        		connector.switchDefaultFrame();
        		break;
        	case("Premium plan"):
        		commandLocater = "room";
        		selector = "/html/body/div/div[1]/div/h5";
        		connector.switchFrame(commandLocater);
        		assertTrue(connector.testTextX(selector, roomType));
        		connector.switchDefaultFrame();
        		break;
        	case("With dinner"):
        		commandLocater = "room";
        		assertTrue(connector.testText(selector, roomType));
        		break;
        	case("Economical"):
        		commandLocater = "room";
        		assertTrue(connector.testText(selector, roomType));
        		break;
        	case("Staying without meals"):
        		commandLocater = "room";
        		selector = "/html/body/div/div[1]/div/h5";
        		connector.switchFrame(commandLocater);
        		assertTrue(connector.testTextX(selector, roomType));
        		connector.switchDefaultFrame();
        		break;
        	case("Business trip"):
        		commandLocater = "room";
        		selector = "/html/body/div/div[1]/div/h5";
        		connector.switchFrame(commandLocater);
        		assertTrue(connector.testTextX(selector, roomType));
        		connector.switchDefaultFrame();
        		break;
        	case("With beauty salon"):
        		commandLocater = "room";
        		assertTrue(connector.testText(selector, roomType));
        		break;
        	case("With private onsen"):
        		commandLocater = "room";
        		assertTrue(connector.testText(selector, roomType));
        		break;
        	case("For honeymoon"):
        		commandLocater = "room";
        		selector = "/html/body/div/div[1]/div/h5";
        		connector.switchFrame(commandLocater);
        		assertTrue(connector.testTextX(selector, roomType));
        		connector.switchDefaultFrame();
        		break;
        	case("With complimentary ticket"):
        		commandLocater = "room";
        		assertTrue(connector.testText(selector, roomType));
        		break;
        	default:
        		commandLocater = "./reserve.html?plan-id=0";
        		connector.clickHrefAndWait(commandLocater);
        	}

    }

    @Then("^test stay dates$")
    public void testReserveTerm() throws InterruptedException {
    	String selector = "term";

    	try {
        	assertTrue(connector.testTermEN(selector, termValue + termValueWeekEnd));
    	}catch(Exception e) {
    		System.out.println(connector.dateFrom);
    		System.out.println(connector.dateTo);
    		connector.destroySelenium();
    	}
    }

    @Then("^test Guests as \"([^\"]*)\" person$")
    public void testHeadCount(String headcount) throws InterruptedException {
    	String selector = "head-count";

    	headcount = headcount + " person(s)";
    	assertTrue(connector.testText(selector, headcount));
    }

    /**
     * 追加プランの検証
     */
    @Then("^test Additional plans as \"([^\"]*)\" or \"([^\"]*)\" or \"([^\"]*)\"$")
    public void testOption1(String plan1, String plan2, String plan3) throws InterruptedException {
    	String planText;

    	String selector1 = "//*[@id=\"plans\"]";
    	String selector2 = "//*[@id=\"plans\"]/ul/li";
    	String selector3 = "//*[@id=\"plans\"]/ul/li[1]";
    	String selector4 = "//*[@id=\"plans\"]/ul/li[2]";
    	String selector5 = "//*[@id=\"plans\"]/ul/li[3]";

    	if((plan1.equals("off"))&&(plan2.equals("off"))&&(plan3.equals("off"))) {
    		planText = "none";
    		assertTrue(connector.testTextX(selector1, planText));
    	}

    	if((plan1.equals("on"))&&(plan2.equals("off"))&&(plan3.equals("off"))) {
    		planText = "Breakfast";
    		assertTrue(connector.testTextX(selector2, planText));
    	}
    	if((plan1.equals("off"))&&(plan2.equals("on"))&&(plan3.equals("off"))) {
    		planText = "Early check-in";
    		assertTrue(connector.testTextX(selector2, planText));
    	}
    	if((plan1.equals("off"))&&(plan2.equals("off"))&&(plan3.equals("on"))) {
    		planText = "Sightseeing";
    		assertTrue(connector.testTextX(selector2, planText));
    	}

    	if((plan1.equals("on"))&&(plan2.equals("on"))&&(plan3.equals("off"))) {
    		planText = "Breakfast";
    		assertTrue(connector.testTextX(selector3, planText));
    		planText = "Early check-in";
    		assertTrue(connector.testTextX(selector4, planText));
    	}
    	if((plan1.equals("on"))&&(plan2.equals("off"))&&(plan3.equals("on"))) {
    		planText = "Breakfast";
    		assertTrue(connector.testTextX(selector3, planText));
    		planText = "Sightseeing";
    		assertTrue(connector.testTextX(selector4, planText));
    	}
    	if((plan1.equals("off"))&&(plan2.equals("on"))&&(plan3.equals("on"))) {
    		planText = "Early check-in";
    		assertTrue(connector.testTextX(selector3, planText));
    		planText = "Sightseeing";
    		assertTrue(connector.testTextX(selector4, planText));
    	}

    	if((plan1.equals("on"))&&(plan2.equals("on"))&&(plan3.equals("on"))) {
    		planText = "Breakfast";
    		assertTrue(connector.testTextX(selector3, planText));
    		planText = "Early check-in";
    		assertTrue(connector.testTextX(selector4, planText));
    		planText = "Sightseeing";
    		assertTrue(connector.testTextX(selector5, planText));
    	}

    }

    @Then("^test Name as \"([^\"]*)\"$")
    public void testUsername(String username) throws InterruptedException {
    	String selector = "username";

//    	username = username + "様";
    	assertTrue(connector.testText(selector, username));
    }

    /**
     * 確認のご連絡検証
     */
    @Then("^test Confirmation as \"([^\"]*)\" and telephone as \"([^\"]*)\" or mailadress as \"([^\"]*)\"$")
    public void testContact(String contactText, String telText, String emailText) throws InterruptedException {
    	String selector = "contact";

    	switch(contactText) {
    	case("I don't need."):
    		contactText = "not required";
    		assertTrue(connector.testText(selector, contactText));
    		break;
    	case("By telephone"):
    		if(telText.length() == 0) {
    			telText = connector.tel;
    		}
    		contactText = "Tel" + ": " + telText;
			assertTrue(connector.testText(selector, contactText));
    		break;
    	case("By email"):
    		if(emailText.length() == 0) {
    			emailText = connector.email;
    		}
    		contactText = "Email" + ": " + emailText;
			assertTrue(connector.testText(selector, contactText));
    		break;
    	}
    }

    @Then("^test Special Request as \"([^\"]*)\"$")
    public void testComment(String comment) throws InterruptedException {
    	String selector = "comment";

    	if(comment.equals("144chr")) {
    		comment = comment144;
    		assertTrue(connector.testText(selector, comment));
    	}
    }

    @Then("^test popup message as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void testPopUp(String message1, String message2) throws InterruptedException {
    	String selector1 = "//div[@id='success-modal']/div/div/div/h5";
    	String selector2 = "//div[@id='success-modal']/div/div/div[2]/p";

    	assertTrue(connector.testTextX(selector1, message1));
    	assertTrue(connector.testTextX(selector2, message2));
    }

}
