
Feature: Flight Search functionality

  Scenario: Search flights One-way
    Given user navigates to cleartrip site and verify search flight page
    When user click on "One way" button
    When user enter "From" location
 		When user enter "To" location	
 		When user select "Depart On" date
 		When user select "Adults" dropdown
 		When user select "Children" dropdown
 		When user select "Infants" dropdown	
 		When user click on "Search" button
 		Then user verify the searched flight
 			 
 	Scenario: Search flights Round-trip
    Given user navigates to cleartrip site and verify search flight page
    When user click on "Round Trip" button
    When user enter "From" location
 		When user enter "To" location	
 		When user select "Depart On" date
 		When user select "Return On" date
 		When user select "Adults" dropdown
 		When user select "Children" dropdown
 		When user select "Infants" dropdown	
 		When user click on "Search" button
 		Then user verify the searched flight
