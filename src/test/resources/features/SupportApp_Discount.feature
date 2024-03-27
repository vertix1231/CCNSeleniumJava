Feature: Discount in Support App

	@Support_Discount1
  Scenario Outline: 
    Given go to support app web
    When input user ID <userID> and password <password> and and submit button to continue login
    When user go to create discount menu
    
        Examples: 
    | userID   | password | 
    | helpdesk | password |
    
    
  