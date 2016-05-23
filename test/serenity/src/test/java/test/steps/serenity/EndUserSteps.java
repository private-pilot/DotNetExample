package test.steps.serenity;

import test.pages.BooksPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import test.pages.NavBar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EndUserSteps extends ScenarioSteps {

    NavBar navBar;
    BooksPage booksPage;

    @Step
    public void is_the_home_page() {
        navBar.open();
    }

    @Step
    public void clicks_tab(String tabName) {
        navBar.clickTab(tabName);
    }

    @Step
    public void should_see_books_list() {
        assertThat(booksPage.isPresentBooksTable(), is(true));
    }

    @Step
    public void click_create_new_book_link(){
        booksPage.clickCreateNewBookLink();
    }

    @Step
    public void create_new_book_with(String genre, int price, String title, String authorFirstName, String authorLastName, int year){
        booksPage.createNewBookWith(genre, price, title, authorFirstName, authorLastName, year);
    }

    @Step
    public void should_see_book_with_title_on_books_list(String title){
        assertThat(booksPage.bookWithTitleIsPresentOnBooksList(title), is(true));
    }

    @Step
    public void click_create_book_button(){
        booksPage.clickCreateBookButton();
    }
}