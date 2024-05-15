package Pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BaseUtils.BaseUtils;

public class SearchJobsPage extends BaseUtils {

	BaseUtils baseUtils = new BaseUtils();
	String pageTitle = "Search for jobs in the NHS";
	By jobTitleOrSkillsInput = By.id("keyword");
	By locationInput = By.id("location");
	By distanceInput = By.id("distance");
	By serachButton = By.id("search");
	By searchResult = By.xpath("//ul[@class='nhsuk-list search-results']");
	By results = By.xpath("//h3[@class='nhsuk-heading-m nhsuk-u-margin-bottom-2']/a");
	By noResults = By.xpath("//h3[text()='No result found']");
	By sortBy = By.id("sort");
	By heading = By.id("heading");
	By moreSearchOptions = By.id("searchOptionsBtn");
	By jobReference = By.id("jobReference");
	By employer = By.id("employer");
	By payRange = By.id("payRange");
	By clearFiltersButton = By.id("clearFilters");

	public void verifyPageDisplayed() {
		Assert.assertTrue(pageTitle.equalsIgnoreCase(driver.getTitle()));
		String header = driver.findElement(heading).getText();
		Assert.assertEquals(pageTitle, header);
	}

	public void provideSearchDetails(String what, String location, String distance) {
		baseUtils.enterText(jobTitleOrSkillsInput, what);
		baseUtils.enterText(locationInput, location);
		baseUtils.selectDropdown(distanceInput, distance);
	}

	public void serach() {
		baseUtils.click(serachButton);
	}

	public void provideMoreSearchOptionDetails(String reference, String employerDetails, String payRangeDetails) {
		baseUtils.click(moreSearchOptions);
		baseUtils.enterText(jobReference, reference);
		baseUtils.enterText(employer, employerDetails);
		baseUtils.selectDropdown(payRange, payRangeDetails);
	}

	public void getResults() {
		List<WebElement> ele = new ArrayList<WebElement>();
		ele = driver.findElements(results);
		List<String> role = new ArrayList<String>();
		for (WebElement e : ele) {
			String text = e.getText();
			role.add(text);
		}
		System.out.println("Matches found with Job titles as:" + role);
	}

	public void validateNoResultsMessage() {
		Assert.assertTrue("Message not displayed", driver.findElement(noResults).isDisplayed());
	}

	public void sortJobs() throws InterruptedException {
		driver.findElement(sortBy).click();
		Select sort = new Select(driver.findElement(sortBy));
		sort.selectByVisibleText("Date Posted (newest)");
		Thread.sleep(1000);
	}

	public void clearInputFilters() {
		baseUtils.click(clearFiltersButton);
	}

	public void validatePreferenceOptionsisEmpty() {
		String what = driver.findElement(jobTitleOrSkillsInput).getAttribute("value");
		Assert.assertTrue(what.isEmpty());

		String where = driver.findElement(locationInput).getAttribute("value");
		Assert.assertTrue(where.isEmpty());

		String distance = driver.findElement(distanceInput).getAttribute("value");
		Assert.assertTrue(distance.isEmpty());

	}
}
