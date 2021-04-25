Feature: Add Contacts
  In order to improve my profession network
  As a keen employee, I want to be able to add new contacts in my Android phone
  Created By: Arun Kumar
  Version: 1.0

  Scenario Outline:  Add new contacts to my phone
    Given I have an contacts app open
    And I enter <name> and <number>
    When I tap save
    Then Contact <name> should be saved in the contact list

    Examples:
      | name           | number   |
      | "testname"     | "123456" |
      | "testname2"    | "987654" |
      | ""             | "345678" |


    Scenario: Add new contacts by importing VCF file
      Given I enter contacts setting
      When I import "contacts.vcf" file
      Then Contacts should be imported to the contact list
