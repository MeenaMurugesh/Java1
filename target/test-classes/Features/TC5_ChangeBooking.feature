Feature: Verifying OMR Branch hotel Change Booking Page Automation

  Scenario Outline: Book hotel change the checkIn date
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<SelectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name, price
    And User accept the alert in selected hotel
    Then User should verify after select hotel sucess message "Book Hotel"
    When User add the guest details "<salutation>","<firstName>","<lastName>","<mobileNo>" and "<email>"
    And User add the GST details "<regNo>","<companyName>" and "<companyAddress>"
    And User add the special request "<specialRequestComments>"
    And User add the payment details proceed with "<cardType>"
      | CardName   | CardNo           | NameonCard | Month | Year | CVV |
      | Visa       | 5555555555552223 | Meena      | May   | 2027 | 987 |
      | MasterCard | 5555555555552223 | priya      | May   | 2027 | 987 |
      | Amex       | 5555555555552223 | Meena      | May   | 2027 | 987 |
      | Discover   | 5555555555552223 | priya      | May   | 2027 | 987 |
    Then User should verify after booking success message "Booking is confirmed" and save the order id
    Then User should verify same selected hotel booked or NOT
    When User navigate to My Account page
    Then User should verify after navigate success msg "My Booking"
    When User search the order id
    Then User should verify same selected hotel is booked
    And User should verify same order id is present
    And User should verify same price is present
    When User change the checkin date "<checkInDate>"
    Then User should verify after change the checkIn date success msg "Booking updated successfully"

    Examples: 
      | userName                   | password   | selectState | selectCity | SelectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                      | regNo      | companyName            | companyAddress | specialRequestComments | cardType |checkInDate |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 | Ms.        | Priya     | Sri      | 9876543210 | meenusakthi.2m24@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Need early check in    | Credit   |2023-08-31 |

  Scenario Outline: Book hotel change the checkin date for existing order id pass the order id in examples
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User navigate to My Account page
    Then User should verify after navigate success msg "My Booking"
    When User search the order Id "<orderId>"
    And User change the checkin date "<checkInDate>"
    Then User should verify after change the checkIn date success msg "Booking updated successfully"

    Examples: 
      | userName                   | password   | orderId    |checkInDate |
      | meenusakthi.2m24@gmail.com | Meena@1998 | VHCSD47564 |2023-08-31 |

  Scenario Outline: Book hotel change the checkInDate for 1st order id
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User navigate to My Account page
    Then User should verify after navigate success msg "My Booking"
    When User search the order id
    And User change the checkin date "<checkInDate>"
    Then User should verify after change the checkIn date success msg "Booking updated successfully"

    Examples: 
      | userName                   | password   |checkInDate|
      | meenusakthi.2m24@gmail.com | Meena@1998 |2023-08-31 |
