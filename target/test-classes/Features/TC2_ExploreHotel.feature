Feature: Verifying OMR Branch hotel Home Page Automation

  Scenario Outline: Verifying all enter field and verify select hotel
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<selectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"

    Examples: 
      | userName                   | password   | selectState | selectCity | selectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-09-17 | 2023-09-20 | 1-One     | 1-One      |            1 |
 
  Scenario Outline: Verifying mandatory field and verify select hotel
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<checkIn>","<checkOut>","<noOfRooms>" and "<noOfAdults>"
    Then User should Verify success message after search hotel "Select Hotel"

    Examples: 
      | userName                   | password   | selectState | selectCity | checkIn    | checkOut   | noOfRooms | noOfAdults |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  |  Madurai | 2023-09-17 | 2023-09-20 | 1-One     | 1-One      |

  Scenario Outline: Verifying without enter field and verify select hotel
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User Search Hotels without selecting any fields
    Then User should verify error message after search hotel "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | userName                   | password   |
      | meenusakthi.2m24@gmail.com | Meena@1998 |
@hotel

  Scenario Outline: Verifying all enter field and verify filter room and select hotel
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<selectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"
    And User should only selected room type are visible in the header "<SelectRoomType>"

    Examples: 
      | userName                   | password   | selectState | selectCity | selectRoomType                      | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Standard/Deluxe/Suite/Luxury/Studio | 2023-09-17 | 2023-09-20 | 1-One     | 1-One      |            1 |

  Scenario Outline: Verifying hotel price high to low
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<selectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"
    When User click the hotel price sort high to low
    Then User should verify sorted in high to low

    Examples: 
      | userName                   | password   | selectState | selectCity | selectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-09-17 | 2023-09-20 | 1-One     | 1-One      |            1 |

  Scenario Outline: Verifying sort name by Ascending order
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<selectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"
    When User click the hotel name sort Ascending order
    Then User should verify sorted in the Ascending order

    Examples: 
      | userName                   | password   | selectState | selectCity | selectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-09-17 | 2023-09-20 | 1-One     | 1-One      |            1 |
