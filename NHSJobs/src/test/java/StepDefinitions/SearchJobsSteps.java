package StepDefinitions;

import java.io.IOException;

import BaseUtils.BaseUtils;
import Pages.SearchJobsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchJobsSteps{

	SearchJobsPage searchJob = new SearchJobsPage();
	BaseUtils baseUtils = new BaseUtils();
	
	@Before
	public void startUp() {
		baseUtils.launchBrowser();
	}

	@Given("I am a jobseeker on NHS Jobs website")
	public void viewJobSearchPage() throws IOException {
		searchJob.verifyPageDisplayed();
	}

	@When("I put my preferences into the search options with {string},{string} and {string}")
	public void enterJobPreferences(String what, String where, String distance) throws InterruptedException {
		searchJob.provideSearchDetails(what, where, distance);
	}
	
	@And("I search for job results")
	public void searchResults(){
		searchJob.serach();
	}

	@Then("I should get a list of jobs which matches my preferences")
	public void viewListOfJobs() {
		searchJob.getResults();
	}

	@Then("sort my search results with the newest Date Posted")
	public void sortWithNewestDatePosted() throws InterruptedException {
		searchJob.sortJobs();
	}

	@Then("I should see no results found message")
	public void validateMessage() {
		searchJob.validateNoResultsMessage();
	}
	
	@And("I provide more search options with {string},{string},{string}")
	public void validateMoreSearchOptions(String jobReference,String employee,String payRange) {
		searchJob.provideMoreSearchOptionDetails(jobReference, employee, payRange);
	}
	
	@And("I clear the filters")
	public void clearFilters(){
		searchJob.clearInputFilters();
	}
	
	@Then("I should see no preference values are present in search options")
	public void validateClearFilters()
	{
		searchJob.validatePreferenceOptionsisEmpty();
	}
	
	@After
	public void tearDown() {
		baseUtils.closeBrowser();
	}

}
