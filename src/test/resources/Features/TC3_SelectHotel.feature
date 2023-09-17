Feature: Verifying OMR Branch select hotel Page Automation

  Scenario Outline: Verifying select hotel and navigate to book hotel upon accepting the alert
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<selectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name, price
    And User accept the alert in selected hotel
    Then User should verify after select hotel sucess message "Book Hotel"

    Examples: 
      | userName                   | password   | selectState | selectCity | selectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 |

  Scenario Outline: Verifying select hotel and navigate to book hotel upon dismiss the alert
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<selectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name, price
    And User dismiss the alert in selected hotel
    Then User should Verify success message after search hotel "Select Hotel"

    Examples: 
      | userName                   | password   | selectState | selectCity | selectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 |
