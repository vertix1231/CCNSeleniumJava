Feature: PCN
PCN subscription

PCN applies to company level and individual
PCN charge different by countries, (e.g. Price, or Bundle including)
PCN only applies to CCN products and CCN bundle for now.
PCN applies to different products subscription (e.g. x% of each subscription. % can be different by different country)
PCN applies to plan level
PCN applies after discounted subscription amount
Discount applicable to PCN
Minimum charge applicable 
PCN charge monthly (1st day of each month based on Subscription of previous month)
PCN charge flat fee across in city or company in CN market
PCN charges can be shared within the same company group in the CN market (e.g., DHLSHA & DHLBJS). The first company of the group that subscribes to the initial plan will be responsible for paying the PCN charges.
PCN Discount

Discount can be % or absolute amount 
Discount has validity period 
Discount apply as discount code by PM via subscription
Discount can be applied across to the whole region/country/cities (configurable at the backend)
Discount can be applied to the product plan by default

	@PCNS1
  Scenario Outline: Subscription of the first month. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
        Examples: 
    | email                       | password      | product                                        | email2                       | productB                                         | productC      |
    | qa-ccn-75754@mailinator.com | CCNPegasus123 | test awbconcierge premium multicurrencysandbox | qa-ccn-75754@mailinator.com  | test iata tact rate premium multicurrencysandbox | test bc premium multicurrencysandbox |
    
    
  @PCNS2
  Scenario Outline: Subscription with different multi currency plan. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
        Examples: 
    | email                         | password      | product                | email2                         | productB      | productC   |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | AWB Editor |

	@PCNS3
  Scenario Outline: Subscription of the subsequent month (with new subscription). PCN Configuration:  set to 10% of each subscription; PCN applies to all products, countries, cities, companies.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan D" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form


    Examples: 
      | email                         | password      | product                                        | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | test awbconcierge premium multicurrencysandbox |   
	
	@PCNS4
  Scenario Outline: Subscription of the subsequent month (with new PM Join). PCN Configuration:  set to 10% of each subscription; PCN applies to all products, countries, cities, companies.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 3 Company A" click product tab to subscribe to product
    And Select plan "Plan D" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form


    Examples: 
      | email                         | password      | product                | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | Lead Freight Solutions |   
	
	@PCNS5
	Scenario Outline: Subscription Does not meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
    
  @PCNS6
	Scenario Outline: Subscription meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
  
  @PCNS7
	Scenario Outline: Subscription Does not meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. A 10% discount is set for PCN.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
    
  @PCNS8
	Scenario Outline: Subscription meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. A 10% discount is set for PCN.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
	
	
	@PCNS9
	Scenario Outline: Subscription Does not meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. $2 discount set for PCN.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
    
  @PCNS10
	Scenario Outline: Subscription meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. $2 discount set for PCN.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
    
  @PCNS11
	Scenario Outline: Subscription Does not meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. A 10% discount is set for PCN with validity period of 2 months.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
    
  @PCNS12
	Scenario Outline: Subscription meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. A 10% discount is set for PCN with validity period of 3 months.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
	
	
	@PCNS13
	Scenario Outline: Subscription Does not meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. $2 discount set for PCN with validity period of 3 months.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    
  Examples: 
    | email                         | password      | product                | email2                         | productB      | productC      |
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB | Booking Queue |
  
  @PCNS14
  Scenario Outline: Subscription Does not meet minimum PCN Charge. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    And wait for response
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan D" "<productD>"
    And Subscribe plan "<productD>"
    And click subscriber payment form

    Examples: 
      | email                         | password      | product                | email2                         | productB                | productC                | productD							|
      | sgqa-ccn-72922@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72923@mailinator.com  | Bundle BC AWB           | Booking Concierge       | CargoMart by CargoAi 	|
  
    
  @PCNS14_DiscountBCAWB
	Scenario Outline: Subscribe AWB & BC premium plan with .
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    
  Examples: 
    | email                         | password      | product                                       | productB                                   | 
    | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | test bc premium multicurrencysandbox discount | awbconcierge multicurrencysandbox discount |
	
	@PCN15
  Scenario Outline: PCN charges can be set a flat rate and applied to CN market in a specify city
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form


    Examples: 
      | email                         | password      | product                | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | Lead Freight Solutions | 
      
  @PCN16
  Scenario Outline: PCN charges can be set a flat rate and applied to CN market in a specify city for a specify company
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form


    Examples: 
      | email                         | password      | product                | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | Lead Freight Solutions | 
      
  @PCN17
  Scenario Outline: PCN charges can be set a flat rate and applied to CN market in a specify city for a specify company and a specify product/plan
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form


    Examples: 
      | email                         | password      | product                | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | Lead Freight Solutions | 
      
	@PCN18
  Scenario Outline: PCN charges can be set a flat rate and shared within the same company group in the CN market
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe second plan "<productB>"
    And input the complete subscriber payment form
    And go to my icon account to Sign Out
	
    Examples: 
      | email                       | password      | product       | email2                       | productB                    | 
      | qa-ccn-83833@mailinator.com | CCNPegasus123 | Bundle BC AWB | qa-ccn-50226@mailinator.com  | qa-ccn-83833@mailinator.com | 
    
    
  @PCN19
  Scenario Outline: PCN charges can be set a flat rate, applied to a specify product/plan
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form


    Examples: 
      | email                         | password      | product                | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | Lead Freight Solutions |     	
	
	@PCN20
  Scenario Outline: PCN charges can be set a specify % of subscription charge, applied to a specify product/plan
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form


    Examples: 
      | email                         | password      | product                | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | Lead Freight Solutions |     	
	
	@PCN1
  Scenario Outline: 2 PM in the same Company. 3 Product.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form

    Examples: 
      | email                         | password      | product                | email2                         | productB                | productC                |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB           | Booking Concierge       |
      
  @PCN2
  Scenario Outline: 2 PM in the same Company. 4 Product.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    And wait for response
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And click subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan D" "<productD>"
    And Subscribe plan "<productD>"
    And click subscriber payment form

    Examples: 
      | email                         | password      | product                | email2                         | productB                | productC                | productD							|
      | sgqa-ccn-72922@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72923@mailinator.com  | Bundle BC AWB           | Booking Concierge       | CargoMart by CargoAi 	|
      
  @PCN3
  Scenario Outline: 1 PM in a Company. 1 Product.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form


    Examples: 
      | email                         | password      | product                | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | Lead Freight Solutions | 
      
  @PCN4
  Scenario Outline: 2 PM in the same Company. 2 Product.
    Given go to main web
    Given press sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    And go to my icon account to Sign Out
    Given press sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe second plan "<productB>"
    And input the complete subscriber payment form
    And go to my icon account to Sign Out
    #When click initial sign in button
    #When input email <email> and password <password> and press sign in to continue login
    #And back to the main tab browser
    #Then open email mailinator to cek the transaction charge


    Examples: 
      | email                       | password      | product       | email2                       | productB                    | 
      | qa-ccn-83833@mailinator.com | CCNPegasus123 | Bundle BC AWB | qa-ccn-50226@mailinator.com  | qa-ccn-83833@mailinator.com | 
    
    #qa-ccn-95169@mailinator.com
    #qa-ccn-04346@mailinator.com
    #qa-ccn-46551@mailinator.com
      
  @createUserMalay
  Scenario: create user from malaysia
    Given go to main web
    Given press sign in button
    When registration with new account from malaysia <city> and <country> login
    Then will redirected to suggested company list which match with domain name of the users
    
  Examples: 
  | city         | country  |
  | KUALA LUMPUR | Malaysia | 
  
  
  @create_user_INDO
  Scenario Outline: create user from indonesia
    Given go to main web
    Given press sign in button
    When registration with new account from INDO <city> and <country> login
    Then will redirected to suggested company list which match with domain name of the users 
  
  Examples: 
  | city         | country   |
  | YOGYAKARTA    | Indonesia |  
  
  @createUserUAE
  Scenario Outline: create user from united arab emirates
    Given go to main web
    Given press sign in button
    When registration with new account from UAE <city> and <country> login
    Then will redirected to suggested company list which match with domain name of the users
    
  Examples: 
  | city      | country              |
  | ABU DHABI | United Arab Emirates |   
      
  
  @create_user_company_my
  Scenario Outline: create user company malaysia
    Given go to main web
    Given press sign in button
    When registration with new account from malaysia <city> and <country> login
    Then will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>" from "<country>" dynamics
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<countryB>"
    And input city "<cityB>"
    And theres button to create company with the status was enabled to create company
    Then the user was able to create a new company
    When press create company button
    And input contact details IATA membership number "<iataNo>"
    And input contact details CASS number "<cassNo>"
    And input registered office address "<officeAddress>" for company detail
    And input post code "<postCode>" for company detail
    And input company email "<companyemail>" for company detail
    And input mobile number detail company "<mobileNoCompany>" for company detail
    And input mailing address complete from same as registered company address
    And input contact details name "<name>"
    And input contact details designation "<designation>"
    And input contact details mobile no "<mobileNo>"
    And input contact details email "<email>"
    And press submit create company
    
    Examples: 
      | companyemail   | email             | password      | companyName  | companyRegis | typeOfCompany | countryB       | city          | name    | designation | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | product       | cityB         | country  |
      | my@yopmail.com | myper@yopmail.com | CCNPegasus123 | Test         | MY           | GSA           | MY - MALAYSIA  | KUALA LUMPUR  | my test | marketing   | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      1111111111 | AWB Concierge | KUL           | Malaysia |
      
  @create_user_company_UAE
  Scenario Outline: create user company united arab emirates
    Given go to main web
    Given press sign in button
    When registration with new account from UAE <city> and <country> login
    Then will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>" from "<companyRegis>" dynamics
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<countryB>"
    And input city "<cityB>"
    And theres button to create company with the status was enabled to create company
    Then the user was able to create a new company
    When press create company button
    And input contact details IATA membership number "<iataNo>"
    And input contact details CASS number "<cassNo>"
    And input registered office address "<officeAddress>" for company detail
    And input post code "<postCode>" for company detail
    And input company email "<companyemail>" for company detail
    And input mobile number detail company "<mobileNoCompany>" for company detail
    And input mailing address complete from same as registered company address
    And input contact details name "<name>"
    And input contact details designation "<designation>"
    And input contact details mobile no "<mobileNo>"
    And input contact details email "<email>"
    And press submit create company
    
    Examples: 
      | companyemail    | email              | password      | companyName  | companyRegis | typeOfCompany | countryB                   | city       | name     | designation    | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | product       | cityB           | country              |
      | uae@yopmail.com | uaeper@yopmail.com | CCNPegasus123 | Test         | UAE          | GSA           | AE - UNITED ARAB EMIRATES  | ABU DHABI  | uae comp | plan manager   | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      1111111111 | AWB Concierge | AUH - ABU DHABI | United Arab Emirates |
  
  @create_user_company_INA
  Scenario Outline: create user company from indonesia
    Given go to main web
    Given press sign in button
    When registration with new account from INDO <city> and <country> login
    Then will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>" from "<country>" dynamics
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<countryB>"
    And input city "<cityB>"
    And theres button to create company with the status was enabled to create company
    Then the user was able to create a new company
    When press create company button
    And input contact details IATA membership number "<iataNo>"
    And input contact details CASS number "<cassNo>"
    And input registered office address "<officeAddress>" for company detail
    And input post code "<postCode>" for company detail
    And input company email "<companyemail>" for company detail
    And input mobile number detail company "<mobileNoCompany>" for company detail
    And input mailing address complete from same as registered company address
    And input contact details name "<name>"
    And input contact details designation "<designation>"
    And input contact details mobile no "<mobileNo>"
    And input contact details email "<email>"
    And press submit create company
    
    Examples: 
      | companyemail    | email              | password      | companyName  | companyRegis | typeOfCompany | countryB        | city     | name                 | designation | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | product       | cityB            | country   |
      | ina@yopmail.com | inawon@yopmail.com | CCNPegasus123 | Test         | INA          | GSA           | ID - INDONESIA  | JAKARTA  | perusahaan indonesia | marketing   | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      1111111111 | AWB Concierge | JOG - YOGYAKARTA | Indonesia |
      
  @create_user_company_SG
  Scenario Outline: create user company from singapore
    Given go to main web
    Given press sign in button
    When registration with new account yopmail and login
    Then will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>" from "<country>" dynamics
    And input company registration "<companyRegis>"
    And input company type "<typeOfCompany>"
    And input country "<country>"
    And input city "<city>"
    And theres button to create company with the status was enabled to create company
    Then the user was able to create a new company
    When press create company button
    And input contact details IATA membership number "<iataNo>"
    And input contact details CASS number "<cassNo>"
    And input registered office address "<officeAddress>" for company detail
    And input post code "<postCode>" for company detail
    And input company email "<companyemail>" for company detail
    And input mobile number detail company "<mobileNoCompany>" for company detail
    And input mailing address complete from same as registered company address
    And input contact details name "<name>"
    And input contact details designation "<designation>"
    And input contact details mobile no "<mobileNo>"
    And input contact details email "<email>"
    And press submit create company
    Then will displayed pop up for post payment setup
    And click proceed pop up button for creating company to the post payment
    And click ok button from pop up confirmation that tells GIRO setup instructions has been sent to email
    Then finally successfully to the setup post payment
    And receive email notification giro setup
    
    Examples: 
      | companyemail   | email             | password      | companyName | companyRegis | typeOfCompany | country        | city             | name              | designation | mobileNo     | iataNo  | cassNo | officeAddress       | postCode | mobileNoCompany | 
      | sg@yopmail.com | sgsin@yopmail.com | CCNPegasus123 | Test        | SGCOM        | GSA           | SG - SINGAPORE | SIN - SINGAPORE  | singapore admin   | admin       | 081234567891 | 1234567 | 1234   | 101 Cantonment road |   089774 |      1111111111 | 