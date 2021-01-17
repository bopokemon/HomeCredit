Feature: Deposit functionality 


Scenario Outline: Verification of Reset button 


Given Open deposit page			


When Enter deposit information
| Fields                 | Values              |
| AccountNo              | 88908               |
| Ammount                | 100                 |
| Description            | abc                 |

Then Reset the credential

Examples:
|AccountNo   |Ammount |Description|
|88908       |100     |abc        |


Scenario Outline: Verification of Submit button 


Given Open deposit page			


When Enter deposit information
| Fields                 | Values              |
| AccountNo              | 88908               |
| Ammount                | 100                 |
| Description            | abc                 |

Then Submit the credential <AccountNo>

Examples:
|AccountNo   |Ammount |Description|
|88908       |100     |abc        |


Scenario: Go back Home page 


Given Open deposit page			


When Click on Home link


Then Open home page