package test.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://localhost:5000")
public class NavBar extends PageObject {

    private String mainTabs_XPATH = "//ul[@class='nav navbar-nav']//a[@href='/%s']";

    public void clickTab(String tabName){
        String actualMainTabs_XPATH = mainTabs_XPATH.replace("%s", tabName);
        find(By.xpath(actualMainTabs_XPATH)).click();
    }
}