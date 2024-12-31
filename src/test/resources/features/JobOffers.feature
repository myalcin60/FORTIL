Feature: Search Job Offers
  As a user
  I want to search for job offers on the website
  So that I can find job opportunities based on my search criteria
  Background:
    Given Go to url
  @jobOffers
  @fortil
  Scenario: Search Job Offers
    Given Click on the Job offers
    When Click on the Rechercher area
    Then Enter "Testeur Logiciel" in the search field and press the Enter key
    And Verify that search results are displayed