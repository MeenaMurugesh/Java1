Feature: Verifying OMR Branch Book Hotel Page Automation
  Scenario Outline: Book hotel including GST and debit card with special request
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
      | Visa       | 5555555555552222 | Meena      | May   | 2027 | 987 |
      | MasterCard | 5555555555552222 | priya      | May   | 2027 | 987 |
      | Amex       | 5555555555552222 | Meena      | May   | 2027 | 987 |
      | Discover   | 5555555555552222 | priya      | May   | 2027 | 987 |
    Then User should verify after booking success message "Booking is confirmed" and save the order id
    And User should verify same selected hotel booked or NOT

    Examples: 
      | userName                   | password   | selectState | selectCity | SelectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                      | regNo      | companyName            | companyAddress | specialRequestComments | cardType |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 | Ms.        | Priya     | Sri      | 9876543210 | meenusakthi.2m24@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Need early check in    | Debit    |

  Scenario Outline: Book hotel including GST and credit card with special request
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
    And User should verify same selected hotel booked or NOT

    Examples: 
      | userName                   | password   | selectState | selectCity | SelectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                      | regNo      | companyName            | companyAddress | specialRequestComments | cardType |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 | Ms.        | Priya     | Sri      | 9876543210 | meenusakthi.2m24@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Need early check in    | Credit   |

  Scenario Outline: Book hotel including GST and debit card without special request
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
    And User add the payment details proceed with "<cardType>"
      | CardName   | CardNo           | NameonCard | Month | Year | CVV |
      | Visa       | 5555555555552222 | Meena      | May   | 2027 | 987 |
      | MasterCard | 5555555555552222 | priya      | May   | 2027 | 987 |
      | Amex       | 5555555555552222 | Meena      | May   | 2027 | 987 |
      | Discover   | 5555555555552222 | priya      | May   | 2027 | 987 |
    Then User should verify after booking success message "Booking is confirmed" and save the order id
    And User should verify same selected hotel booked or NOT

    Examples: 
      | userName                   | password   | selectState | selectCity | SelectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                      | regNo      | companyName            | companyAddress | cardType |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 | Ms.        | Priya     | Sri      | 9876543210 | meenusakthi.2m24@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Debit    |

  Scenario Outline: Book hotel including GST and credit card without special request
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
    And User add the payment details proceed with "<cardType>"
      | CardName   | CardNo           | NameonCard | Month | Year | CVV |
      | Visa       | 5555555555552223 | Meena      | May   | 2027 | 987 |
      | MasterCard | 5555555555552223 | priya      | May   | 2027 | 987 |
      | Amex       | 5555555555552223 | Meena      | May   | 2027 | 987 |
      | Discover   | 5555555555552223 | priya      | May   | 2027 | 987 |
    Then User should verify after booking success message "Booking is confirmed" and save the order id
    And User should verify same selected hotel booked or NOT

    Examples: 
      | userName                   | password   | selectState | selectCity | SelectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                      | regNo      | companyName            | companyAddress | cardType |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 | Ms.        | Priya     | Sri      | 9876543210 | meenusakthi.2m24@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Credit   |

  Scenario Outline: Book hotel without GST and debit card with special request
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<SelectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name, price
    And User accept the alert in selected hotel
    Then User should verify after select hotel sucess message "Book Hotel"
    When User add the guest details "<salutation>","<firstName>","<lastName>","<mobileNo>" and "<email>"
    And User add the special request "<specialRequestComments>"
    And User add the payment details proceed with "<cardType>"
      | CardName   | CardNo           | NameonCard | Month | Year | CVV |
      | Visa       | 5555555555552222 | Meena      | May   | 2027 | 987 |
      | MasterCard | 5555555555552222 | priya      | May   | 2027 | 987 |
      | Amex       | 5555555555552222 | Meena      | May   | 2027 | 987 |
      | Discover   | 5555555555552222 | priya      | May   | 2027 | 987 |
    Then User should verify after booking success message "Booking is confirmed" and save the order id
    And User should verify same selected hotel booked or NOT

    Examples: 
      | userName                   | password   | selectState | selectCity | SelectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                      | specialRequestComments | cardType |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 | Ms.        | Priya     | Sri      | 9876543210 | meenusakthi.2m24@gmail.com | Need early check in    | Debit    |

  Scenario Outline: Book hotel without GST and credit card with special request
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"
    When User search hotel "<selectState>","<selectCity>","<SelectRoomType>","<checkIn>","<checkOut>","<noOfRooms>","<noOfAdults>" and "<noOfChildren>"
    Then User should Verify success message after search hotel "Select Hotel"
    When User select first hotel name and save the hotel name, price
    And User accept the alert in selected hotel
    Then User should verify after select hotel sucess message "Book Hotel"
    When User add the guest details "<salutation>","<firstName>","<lastName>","<mobileNo>" and "<email>"
    And User add the special request "<specialRequestComments>"
    And User add the payment details proceed with "<cardType>"
      | CardName   | CardNo           | NameonCard | Month | Year | CVV |
      | Visa       | 5555555555552223 | Meena      | May   | 2027 | 987 |
      | MasterCard | 5555555555552223 | priya      | May   | 2027 | 987 |
      | Amex       | 5555555555552223 | Meena      | May   | 2027 | 987 |
      | Discover   | 5555555555552223 | priya      | May   | 2027 | 987 |
    Then User should verify after booking success message "Booking is confirmed" and save the order id
    And User should verify same selected hotel booked or NOT

    Examples: 
      | userName                   | password   | selectState | selectCity | SelectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                      | specialRequestComments | cardType |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 | Ms.        | Priya     | Sri      | 9876543210 | meenusakthi.2m24@gmail.com | Need early check in    | Credit    |

  Scenario Outline: Book hotel without entering payment details book hotel and verify error message
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
    Then User should verify after booking error message "Please select your card type","Please select your card","Please provide your card number","Please provide name on your card","Please provide your Card Expiry Date" and "Please provide your Card's security code"

    Examples: 
      | userName                   | password   | selectState | selectCity | SelectRoomType | checkIn    | checkOut   | noOfRooms | noOfAdults | noOfChildren | salutation | firstName | lastName | mobileNo   | email                      | regNo      | companyName            | companyAddress | specialRequestComments |
      | meenusakthi.2m24@gmail.com | Meena@1998 | Tamil Nadu  | Madurai    | Deluxe         | 2023-08-17 | 2023-08-20 | 1-One     | 1-One      |            1 | Ms.        | Priya     | Sri      | 9876543210 | meenusakthi.2m24@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam     | Need early check in    |
