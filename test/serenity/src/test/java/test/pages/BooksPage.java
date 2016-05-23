package test.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.Random;

public class BooksPage extends PageObject {

    @FindBy(id="BooksTable")
    WebElementFacade booksTable;

    @FindBy(xpath="//a[@href='/Books/Create']")
    WebElementFacade createNewBookLink;

    @FindBy(id="Genre")
    WebElementFacade genreTextbox;

    @FindBy(id="Price")
    WebElementFacade priceTextbox;

    @FindBy(id="Title")
    WebElementFacade titleTextbox;

    @FindBy(id="AuthorFirstName")
    WebElementFacade authorFirstNameTextbox;

    @FindBy(id="AuthorLastName")
    WebElementFacade authorLastNameTextbox;

    @FindBy(id="Year")
    WebElementFacade yearTextBox;

    @FindBy(xpath="//input[@value='Create']")
    WebElementFacade createBookButton;

    public boolean isPresentBooksTable(){
        return booksTable.isCurrentlyVisible();
    }

    public void clickCreateNewBookLink(){
        createNewBookLink.click();
    }

    public void createNewBookWith(String genre, int price, String title, String authorFirstName, String authorLastName, int year) {
        int randNum = new Random().nextInt(99999);

        String titleWithSuffix = title + String.valueOf(randNum);
        // Store the number so we can verify the correct book has been created in a future step
        Serenity.setSessionVariable("randTitleNumber").to(randNum);

        genreTextbox.type(genre);
        priceTextbox.type(String.valueOf(price));
        titleTextbox.type(titleWithSuffix);
        authorFirstNameTextbox.type(authorFirstName);
        authorLastNameTextbox.type(authorLastName);
        yearTextBox.type(String.valueOf(year));
    }

    public boolean bookWithTitleIsPresentOnBooksList(String title){
        String actualTitle = title + Serenity.sessionVariableCalled("randTitleNumber").toString();
        return(booksTable.containsText(actualTitle));
    }

    public void clickCreateBookButton(){
        createBookButton.click();
    }
}