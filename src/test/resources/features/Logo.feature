Feature: Site Navigation and Logo Verification
  As a user
  I want to verify the site logo is visible on all pages
  And ensure clicking it returns to the homepage

  Background:
    Given Go to url
    Then User should see the site logo

    @logo
    @fortil
  Scenario Outline: Navigate to each page and verify the logo redirects to the homepage
    Given User is on the "<pages>" "<linkPage>" page
    When User clicks on the site logo
    Then User shoulds be redirected to the homepage
    Examples:
      | pages                 |linkPage|
      | Our model             |https://fortil.group/en/our-model/|
      | Social responsibility |https://fortil.group/en/responsabilite-sociale-en/|
      | Key Issues            |https://fortil.group/en/key-issue-en/|
      | Careers               |https://fortil.group/en/careers/|
      | Insights              |https://fortil.group/en/insights-en/|
      | Contact               |https://fortil.group/en/contact-2/|


