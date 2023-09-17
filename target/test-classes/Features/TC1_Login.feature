Feature: Verifying OMR Branch hotel Login Automation

  Scenario Outline: Verifying login with valid Credentials
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify success message after login "Welcome Meena"

    Examples: 
      | userName                   | password   |
      | meenusakthi.2m24@gmail.com | Meena@1998 |

  Scenario Outline: Verifying login with valid Credentials using ENTER key
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>" with Enter key
    Then User should Verify success message after login "Welcome Meena"

    Examples: 
      | userName                   | password   |
      | meenusakthi.2m24@gmail.com | Meena@1998 |

  Scenario Outline: Verifying login with invalid Credentials
    Given User is on the OMR Branch hotel page
    When User login "<userName>","<password>"
    Then User should Verify error message after login "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName                   | password   |
      | meenusakthi.2m24@gmail.com | Kavya@1998 |
