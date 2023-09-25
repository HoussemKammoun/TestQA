@UI
Feature: contact Formulaire Tests

Background:

    Given I navigate to the contact page

@checkTitle
Scenario: As a user I want to check the Title of the contact page
	Then I see Contactez-nous as a title

@saveMessage
Scenario: As a user want to check the good function of the formulaire when I send message
	And I set a message to contact purseteck
	And I click on submit btn
	Then the message is saved successfully

# Scenario: As a user I want to check that the send of the message fail when I don't select the gender
# 	When I navigate to the contact page
#     And I set a message without select the gender
#     Then the add of the message fail

# Scenario: As a user I want to check that the send of the message fail when the lastName is empty
#     When I navigate to the contact page
#     And I set a message without setting the lastname
#     Then the add of the message fail

