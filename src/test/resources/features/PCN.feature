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

	@PCN1
  Scenario Outline: 2 PM in the same Company. 3 Product.
    Given accept cookie
    When click initial sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And input the complete subscriber payment form
    And go to my icon account menu "Sign Out"
    When click initial sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    And go to my icon account menu "Sign Out"
    When click initial sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    Then open email mailinator to cek the transaction charge


    Examples: 
      | email                         | password      | product                | email2                         | productB                | productC                |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB           | Booking Concierge       |
      
  @PCN2
  Scenario Outline: 2 PM in the same Company. 4 Product.
    Given accept cookie
    When click initial sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And input the complete subscriber payment form
    And go to my icon account menu "Sign Out"
    When click initial sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan C" "<productC>"
    And Subscribe plan "<productC>"
    And input the complete subscriber payment form
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan D" "<productD>"
    And Subscribe plan "<productD>"
    And input the complete subscriber payment form
    And go to my icon account menu "Sign Out"
    When click initial sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    Then open email mailinator to cek the transaction charge


    Examples: 
      | email                         | password      | product                | email2                         | productB                | productC                | productD							|
      | sgqa-ccn-72922@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72923@mailinator.com  | Bundle BC AWB           | Booking Concierge       | CargoMart by CargoAi 	|
      
  @PCN3
  Scenario Outline: 1 PM in a Company. 1 Product.
    Given accept cookie
    When click initial sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    Then open email mailinator to cek the transaction charge


    Examples: 
      | email                         | password      | product                | 
      | sgqa-ccn-72924@mailinator.com | CCNPegasus123 | Lead Freight Solutions | 
      
  @PCN4
  Scenario Outline: 2 PM in the same Company. 2 Product.
    Given accept cookie
    When click initial sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 1 Company A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And input the complete subscriber payment form
    And go to my icon account menu "Sign Out"
    When click initial sign in button
    When input email <email2> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "PM 2 Company A" click product tab to subscribe to product
    And Select plan "Plan B" "<productB>"
    And Subscribe plan "<productB>"
    And input the complete subscriber payment form
    And go to my icon account menu "Sign Out"
    When click initial sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    Then open email mailinator to cek the transaction charge


    Examples: 
      | email                         | password      | product                | email2                         | productB                | 
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | Lead Freight Solutions | sgqa-ccn-72921@mailinator.com  | Bundle BC AWB           | 
      
  @createUserMalay
  Scenario: create user from malaysia
    Given go to main web
    Given press sign in button
    When registration with new account from malaysia <city> and <country> login
    Then will redirected to suggested company list which match with domain name of the users
    
  Examples: 
  | city         | country  |
  | KUALA LUMPUR | Malaysia |  
  
  #@createUserMalay
  #Scenario: create user from malaysia
    #Given go to main web
    #Given press sign in button
    #When registration with new account from malaysia <city> and <country> login
    #Then will redirected to suggested company list which match with domain name of the users
    #
  #Examples: 
  #| city         | country  |
  #| KUALA LUMPUR | Malaysia |     
  
  @createUserUAE
  Scenario: create user from malaysia
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
    Then will displayed pop up for post payment setup
    And click proceed pop up button for creating company to the post payment
    And click ok button from pop up confirmation that tells GIRO setup instructions has been sent to email
    Then finally successfully to the setup post payment
    And receive email notification giro setup
    #main test 1
    #Given "User A" click product tab to subscribe to product
    #And Select plan "Plan A" "<product>"
    #And Subscribe plan "<product>"
    #And go to my icon account menu "My Subscriptions"
    
    Examples: 
      | product                      | companyemail                | email                       | password      | companyName     | companyRegis | typeOfCompany | countryB       | city          | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany | product       | cityB         | country  |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | QA_CCN_Company  | MY           | GSA           | MY - MALAYSIA  | KUALA LUMPUR  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 | AWB Concierge | KUL           | Malaysia |