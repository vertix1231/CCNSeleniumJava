Feature: Freight Management System  - LEAD Freight Solutions Product Plan

  @lfstrial-1 @e2e
  Scenario Outline: Subscribe LEAD Freight Solutions trial plan
    Given accept cookie
    When click initial sign in button
    When input email <Email> and password <Password> and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples: 
      | Email                         | Password      | product                               |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Freight Management System - LFS Trial |

  @lfstrial-2 @e2e
  Scenario Outline: plan manager try to subscribe secondt time lfs free trial plan company level, but the plan said already have subscription and cant be subscribe again
    Given accept cookie
    When click initial sign in button
    When input email <Email> and password <Password> and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples: 
      | Email                         | Password      | product                               |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Freight Management System - LFS Trial |

  @lfsmulti @e2e
  Scenario Outline: Subscribe LEAD Freight Solutions trial plan
    Given accept cookie
    When click initial sign in button
    When input email <Email> and password <Password> and press sign in to continue login
    And back to the main tab browser
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"
    And open email mailinator after login

    #And Subscribe plan "<product>"
    #Irsyadm.a@ccn.com.sg
    Examples: 
      | Email                         | Password      | product                               |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Freight Management System - LFS Multi |
