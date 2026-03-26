Feature: Login Feature

Scenario Outline: Login Test
  Given User logs in with "<username>" and "<password>"
  Then Login should be "<status>"

Examples:
  | username        | password       | status   |
  | standard_user   | secret_sauce   | success  |
  | locked_out_user | secret_sauce   | failure  |