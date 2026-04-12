Feature: Login Feature

Scenario Outline: Login Test
  Given User logs in with "<username>" and "<password>"
  Then Login should be "<status>"
  Then User adds product "<product>"
 
 	

Examples:
  | username        | password       | status   | product                |
  | standard_user   | secret_sauce   | success  | Sauce Labs Backpack |
 

 