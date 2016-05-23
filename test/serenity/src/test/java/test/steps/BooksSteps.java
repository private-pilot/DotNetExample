package test.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import test.steps.serenity.EndUserSteps;

public class BooksSteps {

    @Steps
    EndUserSteps user;

    @Given("the user is on the site's home page")
    public void givenTheUserIsOnTheHomePage() {
        user.is_the_home_page();
    }

    @When("the user clicks on the '(.*)' tab")
    public void whenTheUserClicksOnTheTab(String tabName) {
        user.clicks_tab(tabName);
    }

    @Then("they should see the list of available books")
    public void thenTheUserShouldSeeTheListOfAvailableBooks() {
        user.should_see_books_list();
    }

    @Given("the user is on the Books Listing page")
    public void givenTheUserIsOnBooksListingPage() {
        user.should_see_books_list();
    }

    @When("the user clicks on the Create New Book link")
    public void whenTheUserClicksCreateNewBookLink() {
        user.click_create_new_book_link();
    }

    @When("the user creates a new book with '(.+)', '(\\d+)', '(.+)', '(.+)', '(.+)', and '(\\d+)'")
    public void whenTheUserCreatesNewBookWith(String genre, int price, String title, String authorFirstName, String authorLastName, int year){
        user.create_new_book_with(genre, price, title, authorFirstName, authorLastName, year);
    }

    @When("the user clicks the Create book button")
    public void whenTheUserClicksCreateBookButton(){
        user.click_create_book_button();
    }

    @Then("the book with title '(.+)' should be visible on the Books Listing page")
    public void bookWithTitleIsVisibleOnBooksListingPage(String title){
        user.should_see_book_with_title_on_books_list(title);
    }
}
