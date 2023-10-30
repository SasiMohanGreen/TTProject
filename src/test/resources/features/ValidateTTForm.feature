
Feature: Validate Technical Test Form

  Scenario: [TC01] Validate Successful submission with only mandatory field-- Positive Scenario
    Given the user launches the form
    When the user fills in the mandatory details
    Then the user asserts the form is submitted successfully


  Scenario Outline: <testcase_ID> Validate Successful submission with all fields -- <upload_type> upload
    Given the user launches the form
    When the user fills the form with <upload_type> and with all details
    Then the user asserts the form is submitted successfully
    Examples:
      | testcase_ID | upload_type |
      | [TC14]      | "WITHOUT"   |
      | [TC34]      | "TEXT"      |
      | [TC35]      | "IMAGE"     |


  Scenario Outline: <testcase_ID> Validate Successful submission with different input values
    Given the user launches the form
    When the user fills in all details
    Then the user asserts the form is submitted successfully
    Examples:
      | testcase_ID |
      | [TC15]      |
      | [TC16]      |
      | [TC17]      |
      | [TC18]      |
      | [TC19]      |
      | [TC20]      |
      | [TC21]      |
      | [TC22]      |
      | [TC23]      |
      | [TC24]      |
      | [TC25]      |
      | [TC26]      |
      | [TC27]      |
      | [TC28]      |
      | [TC29]      |
      | [TC30]      |
      | [TC31]      |
      | [TC32]      |
      | [TC33]      |

  @30Oct
  Scenario Outline: <testcase_ID> Validate mandatory field -- <mandatory_field>
    Given the user launches the form
    When the user fills only given details and clicks submit button
    Then the user asserts <error_msg> mandatory fields error message is displayed
    Examples:
      | testcase_ID | mandatory_field | error_msg |
      | [TC02]      | All             | 7         |
      | [TC03]      | First Name      | 1         |
      | [TC04]      | Last Name       | 1         |
      | [TC05]      | Email           | 1         |
      | [TC06]      | Gender          | 1         |
      | [TC07]      | Mobile Number   | 1         |
      | [TC08]      | DOB             | 1         |
      | [TC09]      | Hobby           | 1         |


  Scenario Outline: <testcase_ID> Validate invalid input -- <input_field>
    Given the user launches the form
    When the user fills only given details and clicks submit button
    Then the user asserts <error_msg> invalid input error message is displayed
    Examples:
      | testcase_ID | input_field   | error_msg |
      | [TC10]      | All           | 3         |
      | [TC11]      | Email         | 1         |
      | [TC12]      | Mobile Number | 1         |
      | [TC13]      | DOB           | 1         |

