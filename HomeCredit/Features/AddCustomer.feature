Feature: Add customer functionality 


Scenario Outline: Verification of Reset button 


Given Open add customer page			


When Enter customer information
| Fields                 | Values              |
| CustomerName           | Tom                 |
| Gender                 | Male                |
| DateOfBirth            | 09/13/1993          |
| Address                | abc                 |
| City                   | abc                 |
| State                  | 01                  |
| Pin                    | 123                 |
| Mobile                 | 123456789           |
| email                  | a@gmail.com         |
| password               | 123                 |

Then Reset the credential

Examples:
|CustomerName|Gender|DateOfBirth|Address|City|State|Pin|Mobile   |email      |password|
|Cat         |Male  |09/13/1993 |abc    |abc |abc  |123|123456789|a@gmail.com|123     |


Scenario Outline: Verification of Submit button 


Given Open add customer page			


When Enter customer information
| Fields                 | Values              |
| CustomerName           | Tom                 |
| Gender                 | Male                |
| DateOfBirth            | 09/13/1993          |
| Address                | abc                 |
| City                   | abc                 |
| State                  | abc                 |
| Pin                    | 123456              |
| Mobile                 | 123456789           |
| email                  | catna4@gmail.com    |
| password               | 123                 |

Then Submit the credential

Examples:
|CustomerName|Gender|DateOfBirth|Address|City|State|Pin   |Mobile   |email           |password|
|Cat         |Male  |09/13/1993 |abc    |abc |abc  |123456|123456789|catna4@gmail.com|123     |


Scenario: Go back Home page 


Given Open add customer page			


When Click on Home link


Then Open home page