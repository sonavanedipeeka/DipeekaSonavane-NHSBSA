@Search
Feature: NHS Job Search

  Scenario Outline: Validate NHS jobs search is showing list of jobs according to the provided job preferences
    Given I am a jobseeker on NHS Jobs website
    When I put my preferences into the search options with "<JobTitleOrSkills>","<Location>" and "<DistanceInMiles>"
    And I search for job results
    Then I should get a list of jobs which matches my preferences
    And sort my search results with the newest Date Posted

    Examples: 
      | JobTitleOrSkills         | Location | DistanceInMiles |
      | Automation Test Engineer | London   |              20 |
      | Senior Developer         | Wales    |              10 |

  Scenario: Validate NHS Jobs search when positions are not open for the provided job preferences
    Given I am a jobseeker on NHS Jobs website
    When I put my preferences into the search options with "xyz","London" and "20"
    And I search for job results
    Then I should see no results found message

  Scenario Outline: Validate more search options on NHS jobs search page
    Given I am a jobseeker on NHS Jobs website
    When I put my preferences into the search options with "<JobTitleOrSkills>","<Location>" and "<DistanceInMiles>"
    And I provide more search options with "<JobReference>","<Employer>","<PayRangeInThousand>"
    And I search for job results
    Then I should get a list of jobs which matches my preferences

    Examples: 
      | JobTitleOrSkills         | Location | DistanceInMiles | JobReference | Employer | PayRangeInThousand |
      | Automation Test Engineer | London   |              20 |              | NHS      | 10-20              |

  Scenario Outline: Validate more search options on NHS jobs search page when positions are not open
    Given I am a jobseeker on NHS Jobs website
    When I put my preferences into the search options with "<JobTitleOrSkills>","<Location>" and "<DistanceInMiles>"
    And I provide more search options with "<JobReference>","<Employer>","<PayRangeInThousand>"
    And I search for job results
    Then I should see no results found message

    Examples: 
      | JobTitleOrSkills         | Location | DistanceInMiles | JobReference | Employer | PayRangeInThousand |
      | Automation Test Engineer | London   |              20 | JDF-122      | NHS      | 10-20              |

  Scenario Outline: Validate clear filters options on NHS jobs search page
    Given I am a jobseeker on NHS Jobs website
    When I put my preferences into the search options with "<JobTitleOrSkills>","<Location>" and "<DistanceInMiles>"
    And I clear the filters
    Then I should see no preference values are present in search options

    Examples: 
      | JobTitleOrSkills         | Location | DistanceInMiles |
      | Automation Test Engineer | London   |              20 |