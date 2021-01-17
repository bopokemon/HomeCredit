Feature: Add account functionality 


Scenario Outline: Verification of Reset button 


Given Open add account page			


When Enter account information
| Fields                 | Values              |
| CustomerID             | 57693               |
| AccountType            | Savings             |
| Deposit                | 1000                |

Then Reset the credential

Examples:
|CustomerID  |AccountType|Deposit|
|57693       |Savings    |1000   |


Scenario Outline: Verification of Submit button 


Given Open add account page			


When Enter account information
| Fields                 | Values              |
| CustomerID             | 57693               |
| AccountType            | Savings             |
| Deposit                | 1000                |

Then Submit the credential

Examples:
|CustomerID  |AccountType|Deposit|
|57693       |Savings    |1000   |


Scenario: Go back Home page 


Given Open add account page		


When Click on Home link


Then Open home page