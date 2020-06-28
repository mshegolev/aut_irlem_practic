package io.cucumber.zituorden;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigationHelper extends HelperBase {

    String btnLoginName = "authButton";
    String btnExitXpath = "//span[text()='Выйти']/..";


    public NavigationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openMainPage() {
        openMainPage("");
    }


    public void openMainPage(String url) {
        driver.get(String.format("%s%s", manager.baseUrl, url));
    }

    public void openUrl(String url) {
        driver.get(String.format("%s", url));
    }

    public boolean clickButtonLogin() {
        return click(By.name(btnLoginName));
    }

    public boolean clickButtonByName(String name) {
        if (name.equals("Войти")) {
            return clickButtonLogin();
        } else if (name.equals("Выйти")) {
            return exit();
        }
        return false;
    }

    public boolean clickButtonExit() {
        long startTime = System.currentTimeMillis();
        while (!isElementPresent(By.xpath(btnExitXpath)) && (System.currentTimeMillis() - startTime) < 10000) {
        }
        if (!click(By.xpath(btnExitXpath))) {
            return false;
        }
        startTime = System.currentTimeMillis();
        while (!isElementPresent(By.name(btnLoginName)) && (System.currentTimeMillis() - startTime) < 10000) {
        }
        return isElementPresent(By.name(btnLoginName));

    }

    public boolean exit() {
        if (!clickButtonExit()) {
            clickButtonNavbarToggle();
            return clickButtonExit();
        }
        return isLoginPageOpen();
    }

    public void clickButtonNavbarToggle() {
        click(By.cssSelector("button.navbar-toggle"));
    }

    public void clickCheckBoxRemember() {
        click(By.id("USER_REMEMBER_frm"));
    }

    public boolean checkWarrningMessage() {
        return driver.findElements(By.id("id__4_2")).get(0).getText() != null;
    }

    public boolean getScheduleValue(String row, String column) {
        if (driver.findElement(By.xpath("//*[@id='id__5_15']/div/div[3]/table/tbody/tr[" + row + "]/td[" + column + "]/div/div[1]")).getText() == null) {
            try {
                throw new NullPointerException("нет таблицы");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public WebElement getScheduleEvents() {
        WebElement Webtable = driver.findElement(By.xpath("//*[@id='id__5_15']"));
        List<WebElement> TotalRowCount = Webtable.findElements(By.xpath("id('id__5_15')/div/div[3]/table/tbody/tr"));
        //System.out.println("No. of Rows in the WebTable: "+TotalRowCount.size());
        int RowIndex = 1;
        for (WebElement rowElement : TotalRowCount) {
            List<WebElement> TotalColumnCount = rowElement.findElements(By.xpath("td"));
            int ColumnIndex = 1;

            for (WebElement colElement : TotalColumnCount) {
                //System.out.println("Row "+RowIndex+" Column "+ColumnIndex+" Data "+colElement.getText());
                ColumnIndex = ColumnIndex + 1;
            }
            RowIndex = RowIndex + 1;
        }
        return Webtable;
    }


    public String getScheduleEventValue(int row, int column) {
        String value = driver.findElement(By.xpath("//*[@id='id__5_15']/div/div[3]/table/tbody/tr[" + row + "]/td[" + column + "]/div/div[1]")).getText();
        return value;
    }


    public boolean gettableSheduleFirstRow() {
        if (driver.findElement(By.xpath("//*[@id='id__5_15']/div/div[3]/table/tbody/tr[1]/td[1]/div/div[1]")).getText() == null) {
            try {
                throw new NullPointerException("нет таблицы");
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    public boolean checkAbonentType(String foundText) {
        return getAbonentType().contains(foundText);
    }

    public String getAbonentType() {
        return driver.findElement(By.id("abonementType")).getText();
    }

    //public  void getPlayerContainer() { driver.findElement(By.id("videoArchivePlayer")).findElement(By.tagName("iframe"));}
    public String getPlayerContainer() {
        return driver.findElement(By.id("videoArchivePlayer")).getTagName();
    }

    public String getabonementTypeContent() {
        return driver.findElement(By.id("abonementType")).findElement(By.tagName("h4")).getText();
    }

    public String getPlayerVideoContainer() {
        return driver.findElement(By.id("playerVideo")).getTagName();
    }

    public boolean gettableSheduleLightFirstRow() {
        return driver.findElements(By.xpath(".//*[@id='tableSheduleLight']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }

    public String getstatus1Content() {
        return driver.findElement(By.id("status1")).getText();
    }

    public String getProductId() {
        return driver.findElement(By.xpath(".//*[@name='tableArchiveEvents']/tbody/tr[1]")).getAttribute("data-product-id");
    }

    public void openPageForSetPayment() {
        driver.get(String.format("%s%s", manager.urlForSetPayment, ""));
    }

    public void fillFormForSetPayment(ApplicationManager applicationManager,
                                      AccountData accountData, String productId) {
        type(By.id("user_login"), accountData.login);
        type(By.id("product_id"), productId);
        driver.findElement(By.id("add_payment")).click();
    }

    public void fillFormForUnsetPayment(ApplicationManager applicationManager,
                                        AccountData accountData, String productId) {
        type(By.id("user_login"), accountData.login);
        type(By.id("product_id"), productId);
    }

    public void clickButtonSetPayment() {
        driver.findElement(By.id("submitForm")).click();
    }


    public String getGiftBlockWithoutGiftContent() {
        return driver.findElement(By.id("paramList")).getText();
    }

    public void clickGiftBlockMenu() {
        //click(By.id("paramsRadastv"));
        WebElement element = driver.findElement(By.xpath(".//*[@id='paramsRadastv']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public String getFirstRowContentGiftTable() {
        return driver.findElement(By.xpath("//*[@id='jan2016RadasTVTable']/tbody/tr[1]/td[1]")).getText();
    }


    public void clickIdPersoanlSubscribe() {
        click(By.id("personalSubscribe"));
    }

    public void clickOpenPhoneSubscribeButton() {
        click(By.id("OpenPhoneSubscribeButton"));
    }

    public String checkInputPhoneExistence() {
        return driver.findElement(By.id("phone")).getTagName();
    }

    public void fillPhone(String phone) {
        type(By.id("phone"), phone);
    }

    public String getVideoNamePersonalArchiveEventsCatalog() {
        return driver.findElement(By.xpath("//*[@id='archiveEventsPurchases']/table/tbody/tr/td[2]/div")).getAttribute("data-name");
    }

    public void clickpersonalArchiveEventsHeaderControl() {
        WebElement rateElement = driver.findElement(By.id("liveShedule"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rateElement);

        //WebElement element = driver.findElement(By.xpath("//*[@id='liveShedule']/a"));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().perform();
    }

    public void clickPersonalArchiveEventsCatalogControl() {
        WebElement rateElement = driver.findElement(By.id("personalArchiveEventsCatalogControl"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rateElement);

        //WebElement element = driver.findElement(By.id("personalArchiveEventsCatalogControl"));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().perform();
    }

    public String getArchiveCatalogName() {
        return driver.findElement(By.xpath("//*[@id='contentPersonal']/div/h3/span")).getText();
    }

    public String getEmptyBoughtCatalogText() {
        return driver.findElement(By.xpath("//*[@id='contentPersonal']/div/div[3]")).getText();
    }


    public void clickpersonalArchiveEventsCatalogControl() {
        WebElement element = driver.findElement(By.id("personalArchiveEventsCatalogControl"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void clickpersonalArchiveEventsPurchasesControl() {
        WebElement rateElement = driver.findElement(By.id("personalArchiveEventsPurchasesControl"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rateElement);
        //click(By.id("personalArchiveEventsPurchasesControl"));
        //WebElement element = driver.findElement(By.id("personalArchiveEventsPurchasesControl"));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().perform();
    }

    public void clickPersonalArchiveEventsCatalogControlFromPurchases() {
        WebElement rateElement = driver.findElement(By.xpath("//*[@id='contentPersonal']/div/div[3]/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rateElement);

        //WebElement element = driver.findElement(By.xpath("//*[@id='contentPersonal']/div/div[3]/span"));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().perform();
    }

    public boolean gettableArchiveEventsFirstRow() {

        return driver.findElements(By.xpath(".//*[@id='archiveEvents']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }

    public boolean gettableArchiveEventsPurchasesFirstRow() {
        return driver.findElements(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]")).get(0).getText() != null;
    }

    public void clicktableArchiveEventsFirstRow() {
        WebElement rateElement = driver.findElement(By.xpath("//*[@name='tableArchiveEvents']/tbody/tr[1]/td[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rateElement);

        //WebElement element = driver.findElement(By.xpath(".//*[@name='tableArchiveEvents']/tbody/tr[1]/td[1]"));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().perform();
    }

    public void clicktableArchiveEventsPurchasesFirstRow() {
        click(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr/td[1]"));
        //WebElement element = driver.findElement(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr/td[1]"));
        //Actions actions = new Actions(driver);
        //actions.moveToElement(element).click().perform();

    }

    public Map getUserData() {
        String data = getText(By.xpath("//span[@class='item-delimiter']"));
        Map<String, String> map = new HashMap<String, String>();
        String[] array = data.split(" ");
        map.put("name", array[0]);
        map.put("surname", array[1]);
        return map;
    }

    public void clickBuyLink() {
        click(By.xpath("//*[@name='linkToBuy']"));
    }

    public String getArchiveEventsModalName() {
        return driver.findElement(By.xpath("//*[@name='modalArchiveEventsName']")).getText();
    }

    public String getNameFirstVideoInCatalog() {
        return driver.findElement(By.xpath("//*[@name='tableArchiveEvents']/tbody/tr[1]/td[3]/div[1]")).getText();
    }

    public String getIpProductName() {
        driver.switchTo().frame(0);
        return driver.findElement(By.id("product_name")).getText();

    }

    public void navigate_back() {
        driver.navigate().back();
    }


    public String getNameArchiveEventsPurchasesFirstRow() {
        return driver.findElement(By.xpath(".//*[@id='archiveEventsPurchases']/table/tbody/tr[1]/td[1]/div")).getText();
    }

    public String getTextArchiveEventsPurchasesName() {
        //driver.switchTo().frame(0);
//String a = driver.findElement(By.id("archiveEventsBlockPurchases")).findElement(By.tagName("h4")).getText();
        return driver.findElement(By.xpath("//*[@id='modalArchiveEventsWarning']/div/div/div[2]/div/p")).getText();
    }

    public void clickarchiveEventsPurchasesVideo() {
        //driver.switchTo().frame(0);
        click(By.xpath(".//*[@id='archiveEventsPurchasesVideo']/div/div"));
    }

    public void clickCloseLightbox() {
        //driver.switchTo().frame(0);
        click(By.xpath(".//*[@id='modal-archiveEventsPurchases']/div/div/div[1]/button"));
    }

    public String getvideoNameLightbox() {
        return driver.findElement(By.xpath("//*[@id='modalArchiveEventsCatalog']/div/div/div[1]/h4")).getText();
    }

    public void clickCloseLightboxButton() {
        click(By.xpath("//*[@id='modal-archiveEventsPurchases']/div/div/div[1]/button"));
    }

    public void clickAgreeWatchingButton() {
        click(By.xpath("//*[@id='modalArchiveEventsWarning']/div/div/div[3]/div/button"));
    }

    public String getRestTimeText() {
        return driver.findElement(By.xpath("//*[@id='modalArchiveEventsPurchases']/div/div/div[3]/div[1]/div[2]/h4/span")).getText();
    }

    public void clickBodyElement() {
        click(By.id("personalContent"));
    }


    public void clickSendConfirmCode() {
        click(By.id("sendConfirmCode"));
    }

    public String getTextInsendCodeFailBlock() {
        return driver.findElement(By.id("sendCodeFail")).getText();
    }

    public String getTextInAgainCodeSendedBlock() {
        return driver.findElement(By.id("againCodeSended")).getText();
    }

    public void clickPersonalCioroicControl() {
        click(By.id("personalCioroicControl"));
    }

    public String getTextInPersonalTsioroits() {
        return driver.findElement(By.className("block_cont")).findElement(By.tagName("p")).getText();
    }

    public String getTextButtonCioroic() {
        return driver.findElement(By.id("buttonCioroic")).getText();
    }

    public void clickButtonCioroic() {
        click(By.id("buttonCioroic"));
    }


    //test for users roles
    public String getNextInRtv() {
        return driver.findElement(By.xpath(".//*[@id='status1d']/div/h4")).getText();
    }

    public String getClassAccessButton() {
        return driver.findElement(By.xpath(".//*[@id='tableShedule']/table/tbody/tr[1]/td[4]/span")).getClass().toString();
    }

    public String getEventId() {
        return driver.findElement(By.xpath(".//*[@id='id__5_15']/div/div[3]/table/tbody/tr[1]/td[4]/div[1]/a[contains(@class, 'icon-pay glyphicon glyphicon-shopping-cart')]")).getAttribute("id");
    }

    public String getEventById(String eventId) {
        return driver.findElement(By.id(eventId)).getText();
    }

    public String getEventDateInTable() {
        return driver.findElement(By.xpath("//*[@id='tableShedule']/table/tbody/tr[1]/td[1]")).getText();
    }

    public String getTagNameVideoPlayer() {
        return driver.findElement(By.id("player_video")).getTagName();
    }

    public String getStatusRowText() {
        return driver.findElement(By.id("status1")).getText();
    }

    public String getBlockTag(String block_id) {
        return driver.findElement(By.id(block_id)).getTagName();
    }

    public String getStatus1dText() {
        return driver.findElement(By.xpath("//*[@id='status1d']/div/h3")).getText();
    }
    //public boolean existenceOfPlayer(){return driver.findElement(By.id("player_video")).getSize().toString();}

    public String getFirstGiftBlockContent() {
        return driver.findElement(By.xpath("//*[@id='blockParams1']/div/h4")).getText();
    }

    public void clickGiftBlockFirstTable() {
        WebElement element = driver.findElement(By.id("newParam"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        click(By.id("newParam"));
    }

    public void clickPersonalSubscribeBlock() {
        WebElement element = driver.findElement(By.id("personalSubscribeControl"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        click(By.xpath("//*[@id='personalSubscribeControl']/a"));
    }

    public String getNamePersonalSubscribeBlock() {
        WebElement element = driver.findElement(By.id("subscribeEmailBlock"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
        return driver.findElement(By.xpath("//*[@id='subscribeEmailBlock']/h3[1]")).getText();
    }

    public boolean isUserLogged() {
        String text = getText(By.xpath("//a[text()='Личный кабинет']"));
        return text.equals("Личный кабинет");
    }

    public boolean isLoginPageOpen() {
        try {
            return isElementEnabled(By.name(btnLoginName));
        } catch (NoSuchElementException | ElementNotVisibleException e) {
            return false;
        }
    }
}
