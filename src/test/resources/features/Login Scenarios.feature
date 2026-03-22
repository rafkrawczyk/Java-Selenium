Feature: Login Scenarios

  @Smoke
  Scenario: Login
    Given the user is on the login page of "https://chroma.mexil.it/site/login"
    When user enters username "general@teacher.com" in the username text box and enters password "123456" in the password text box
    And clicks the Sign In button
    Then the user is directed to the dashboard page with url "https://mexil.it/chroma/admin/admin/dashboard"