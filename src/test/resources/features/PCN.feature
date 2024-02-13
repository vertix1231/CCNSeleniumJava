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
  Scenario Outline: S1 - Subscription of the first month. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies.
    Given accept cookie
    When click initial sign in button
    When input email <email> and password <password> and press sign in to continue login
    And back to the main tab browser
    When "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"

    Examples: 
      | email                         | password      | product       |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 | AWB Concierge | 
      
  @create_user_company_sg
  Scenario Outline: create user
    Given go to main web
    Given press sign in button
    And registration with new account and try login singapore
    And will redirected to suggested company list which match with domain name of the users
    When system didn't found the suggested company matched
    And input company name "<companyName>" dynamics
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
    #main test 1
    Given "User A" click product tab to subscribe to product
    And Select plan "Plan A" "<product>"
    And Subscribe plan "<product>"
    And go to my icon account menu "My Subscriptions"
    
    Examples: 
      | product                      | companyemail                | email                       | password      | companyName             | companyRegis   | typeOfCompany | country        | city | name     | designation | mobileNo     | iataNo   | cassNo   | officeAddress       | postCode | mobileNoCompany | product       |
      | Bundle (AWB, BC) Non Company | qa-ccn-22869@mailinator.com | qa-ccn-22869@mailinator.com | CCNPegasus123 | mailinatorCCNPEGASUS_QA | CCNPEGASUS_QA1 | GSA           | SG - SINGAPORE | SIN  | gsa sg 1 | marketing   | 081234567891 | 00000001 | 11111111 | 101 Cantonment road |   089774 |      1111111111 | AWB Concierge |

  Scenario: S2 - Subscription of the subsequent month (without new subscription). PCN Configuration:  set to 10% of each subscription; PCN applies to all products, countries, cities, companies.
    Given "PM1-A" has renewed a plan A at the beginning of this month with a subscription charge $40
    And "PM2-A" has renewed a plan B at the beginning of this month with a subscription charge $40
    And "PM1-A" has renewed a plan C at the beginning of this month with a subscription charge $50
    When PCN is set to 10% of Subscription and applied to all products, countries, Cities,companies
    And Minimum PCN charge is set to $20
    Then the PCN charge for plan A, subscribed by "PM1-A" is $40*10%
    And the PCN charge for Plan B, subscribed by "PM2-A" is $40*10%
    And the PCN charge for Plan C, subscribed by "PM1-A" is $50*10%
    But since the Minimum PCN charge is set to $20, the total PCN charge for plan A,B,C dose not meet the minimum charge
    Then Total PCN charge paid by "PM1-A" for plan A is $40*10% + the difference between total PCN charge of Plan A, B, C and minimum PCN charge
    And Total PCN charge paid by "PM2-A" for plan A is $40*10%
    And Total PCN charge paid by "PM1-A" for plan C is $50*10%

  Scenario: S3 - Subscription of the subsequent month (with new subscription). PCN Configuration:  set to 10% of each subscription; PCN applies to all products, countries, cities, companies.
    Given "PM1-A" has renewed a plan A at the beginning of this month with a subscription charge $40
    And "PM2-A" has renewed a plan B at the beginning of this month with a subscription charge $40
    And "PM1-A" has renewed a plan C at the beginning of this month with a subscription charge $50
    And "PM2-A" has subscribed a new plan D at then beginning of this month with a subscription charge $50
    When PCN is set to 10% of Subscription and applied to all products, countries, Cities,companies
    And Minimum PCN charge is set to $20
    Then PCN charge for plan A,  subscribed by "PM1-A" is $40*10%
    And PCN charge for Plan B, subscribed by "PM2-A" is $40*10%
    And PCN charge for Plan C, subscribed by "PM1-A" is $50*10%
    But since Minimum PCN charge is set to $20, total PCN charge for plan A,B,C is does meet the minimum charge
    Then Total PCN charge paid by "PM1-A" for plan A is $40*10% + the difference between total PCN charge of Plan A, B, C and minimum PCN charge.
    And Total PCN charge paid by "PM2-A" for plan A is $40*10%
    And Total PCN charge paid by "PM1-A" for plan C is $50*10%
    And as Plan D is newly subscribed this month, No PCN is charged for this plan at this month

  Scenario: S4 - Subsequent month with new PM join. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies.
    Given "PM1-A" has renewed a plan A at the beginning of this month with a subscription charge $40
    And "PM2-A" has renewed a plan B at the beginning of this month with a subscription charge $40
    And "PM1-A" has renewed a plan C at the beginning of this month with a subscription charge $50
    And "PM2-A" has renewed a plan D at the beginning of this month with subscription charge $50
    And "PM1 - B" has joined the company A with a individual plan subscribed before joining the company, Subscription charge $50
    When PCN is set to 10% of Subscription and applied to all products, countries, Cities,companies
    And Minimum PCN charge is set to $20
    Then PCN charge for plan A subscribed by "PM1-A" is $40*10%
    And PCN charge for Plan B subscribed by "PM2-A" is $40*10%
    And PCN charge for Plan C subscribed by "PM1-A" is $50*10%
    And PCN charge for Plan D subscribed by "PM2-A" is $50*10%
    And the total PCN charge for Plan A, B, C, D now meets the minimum PCN charge
    Then the total PCN charge paid by "PM1-A" for plan A is $40*10%
    And the total PCN charge paid by "PM2-A" for plan B is $40*10%
    And the total PCN charge paid by "PM1-A" for plan C is $50*10%
    And the total PCN charge paid by "PM2-A" for plan D is $50*10%
    Then "PM1-B" has subscribed a individual plan before join company A
    And "PM1-B"'s individual plan has to meet the minimum PCN charge of $20
    Then the total PCN charge paid by "PM1-B" for the individual plan is $20

  Scenario: S5 - Subsequent month after new PM join. PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies.
    Given "PM1-A" has renewed a plan A at the beginning of this month with a subscription charge $40
    And "PM2-A" has renewed a plan B at the beginning of this month with a subscription charge $40
    And "PM1-A" has renewed a plan C at the beginning of this month with a subscription charge $50
    And "PM2-A" has renewed a plan D at the beginning of this month with a subscription charge $50
    And "PM3-A" ("PM1-B" after join company A)'s Individual plan, now become Plan E under company A, has been renewed at the beginning of this month with a Subscription charge $50
    When PCN is set to 10% of Subscription and applied to all products, countries, Cities,companies
    And Minimum PCN charge is set to $20
    Then the PCN charge for plan A subscribed by "PM1-A" is $40*10%
    And the PCN charge for Plan B subscribed by "PM2-A" is $40*10%
    And the PCN charge for Plan C subscribed by "PM1-A" is $50*10%
    And the PCN charge for Plan D subscribed by "PM2-A" is $50*10%
    And the PCN charge for Plan E subscribed by "PM3-A" is $50*10%
    And the total PCN charge for Plan A, B, C, D, E now meets the minimum PCN charge
    Then the total PCN charge paid by "PM1-A" for plan A is $40*10%
    And the total PCN charge paid by "PM2-A" for plan B is $40*10%
    And Total PCN charge paid by "PM1-A" for plan C is $50*10%
    And Total PCN charge paid by "PM2-A" for plan D is $50*10%
    And Totla PCN charge paid by "PM3-A" for plan E is $50*10%

  Scenario: S6 - Subscription of the subsequent month (Does not meet minimum). PCN Configuration: set to 10% of each subscription; PCN applies to all products, countries, cities, companies. A 10% discount is set for PCN.
    Given "PM1-A" has renewed Plan A at the beginning of this month with a subscription charge of $40
    And "PM2-A" has renewed Plan B at the beginning of this month with a subscription charge of $40
    And "PM1-A" has renewed Plan C at the beginning of this month with a subscription charge of $50
    When PCN is set to 10% of Subscription and applied to all products, countries, Cities,companies
    And Minimum PCN charge is set to $20, with a 10% discount applied for PCN charge
    Then the PCN charge for plan A, subscribed by "PM1-A" is $40*10%
    And the PCN charge for Plan B, subscribed by "PM2-A" is $40*10%
    And the PCN charge for Plan C, subscribed by "PM1-A" is $50*10
    But since Minimum PCN charge is set to $20, total PCN charge for plan A,B,C does not meet the minimum charge
    Then the total PCN charge paid by "PM1-A" for plan A is ($40*10% + the difference between the total PCN charge of Plan A, B, C and the minimum PCN charge)*(1-10%).
    And the total PCN charge paid by "PM2-A" for plan A is $40*10%*(1-10%)
    And the total PCN charge paid by "PM1-A" for plan C is $50*10%*(1-10%)

  Scenario: S7 - Subscription of the subsequent month (Meets minimum). PCN Configuration: set to 10% of each subscription; PCN applies to all products, countries, cities, companies. A 10% discount is set for PCN.
    Given "PM1-A" has renewed Plan A at the beginning of this month with a subscription charge of $40
    And "PM2-A" has renewed Plan B at the beginning of this month with a subscription charge of $40
    And "PM1-A" has renewed Plan C at the beginning of this month with a subscription charge of $50
    And "PM2-A" has renewed Plan D at the beginning of this month with a subscription charge of $50
    And "PM3-A" has renewed Plan E at the beginning of this month with a subscription charge of $50
    When PCN is set to 10% of Subscription and applied to all products, countries, cities, companies
    And the Minimum PCN charge is set to $20, with a 10% discount applied for PCN charge
    Then the PCN charge for Plan A, subscribed by "PM1 - A," is $40 * 10%
    And the PCN charge for Plan B, subscribed by "PM2 - A," is $40 * 10%
    And the PCN charge for Plan C, subscribed by "PM1 - A," is $50 * 10%
    And the PCN charge for Plan D, subscribed by "PM2 - A," is $50 * 10%
    And the PCN charge for Plan E, subscribed by "PM3 - A," is $50 * 10%
    But since Minimum PCN charge is set to $20, the total PCN charge for plan A,B,C,D,E meets the minimum charge
    Then the total PCN charge paid by "PM1-A" for Plan A is $40 * 10% * (1 - 10%)
    And the total PCN charge paid by "PM2-A" for Plan B is $40 * 10% * (1 - 10%)
    And the total PCN charge paid by "PM1-A" for Plan C is $50 * 10% * (1 - 10%)
    And the total PCN charge paid by "PM2-A" for Plan D is $50 * 10% * (1 - 10%)
    And the total PCN charge paid by "PM3-A" for Plan E is $50 * 10% * (1 - 10%)

  Scenario: S8 - S8 - Subscription of the subsequent month (Doesn't Meet Minimum).PCN Configuration: Set to 10% of each subscription, PCN applies to all products, countries, cities, companies. $2 discount set for PCN.
    Given "PM1-A" has renewed a plan A at the beginning of this month with a subscription charge $40
    And "PM2-A" has renewed a plan B at the beginning of this month with a subscription charge $40
    And "PM1-A" has renewed a plan C at the beginning of this month with a subscription charge $50
    When PCN is set to 10% of Subscription and applied to all products, countries, Cities,companies
    And Minimum PCN charge is set to $20,with a $2 discount applied to PCN charge.
    Then PCN charge for plan A subscribed by "PM1-A" is $40*10%
    And PCN charge for Plan B subscribed by "PM2-A" is $40*10%
    And PCN charge for Plan C subscribed by "PM1-A" is $50*10%
    But since Minimum PCN charge is set to $20, total PCN charge for plan A,B,C does not  meet the minimum charge
    Then the total PCN charge paid by "PM1-A" for plan A is ($40*10% + the difference between total PCN charge of Plan A, B, C and minimum PCN charge)-$2
    And the total PCN charge paid by "PM2-A" for plan A is $40*10%-$2
    And the total PCN charge paid by "PM1-A" for plan C is $50*10%-$2

  Scenario: S9 - Subscription of the subsequent month (meets minimum). PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. $2 discount set for PCN.
    Given "PM1-A" has renewed a plan A at the beginning of this month with a subscription charge $40
    And "PM2-A" has renewed a plan B at the beginning of this month with a subscription charge $40
    And "PM1-A" has renewed a plan C at the beginning of this month with a subscription charge $50
    And "PM2-A" has renewed a plan D at the beginning of this month with a subscription charge $50
    And "PM3-A" has renewed a plan E at the beginning of this month with a subscription charge $50
    When PCN is set to 10% of Subscription and applied to all products, countries, Cities,companies
    And Minimum PCN charge is set to $20,with a $2 discount applied to PCN charge.
    Then PCN charge for plan A subscribed by "PM1-A" is $40 * 10%
    And PCN charge for Plan B subscribed by "PM2-A" is $40 * 10%
    And PCN charge for Plan C subscribed by "PM1-A" is $50 * 10%
    And PCN charge for Plan D subscribed by "PM2-A" is $50 * 10%
    And PCN charge for Plan E subscribed by "PM3-A" is $50 * 10%
    But since Minimum PCN charge is set to $20, total PCN charge for plan A,B,C,D,E meets the minimum charge
    Then the total PCN charge paid by "PM1-A" for plan A is $40*10-$2
    And the total PCN charge paid by "PM2-A" for plan B is $40*10%-$2
    And the total PCN charge paid by "PM1-A" for plan C is $50*10%-$2
    And the total PCN charge paid by "PM2-A" for plan D is $50*10%-$2
    And the total PCN charge paid by "PM3-A" for plan E is $50*10%-$2

  Scenario: S10 - Subscription of the subsequent month (meets minimum). PCN Configuration:  set to 10% of each subscription, PCN applies to all products, countries, cities, companies. $2 discount set for PCN with validity period of 2 months.
    Given "PM1-A" has renewed a plan A at the beginning of this month with a subscription charge $40
    And "PM2-A" has renewed a plan B at the beginning of this month with a subscription charge $40
    And "PM1-A" has renewed a plan C at the beginning of this month with a subscription charge $50
    And "PM2-A" has renewed a plan D at the beginning of this month with a subscription charge $50
    And "PM3-A" has renewed a plan E at the beginning of this month with a subscription charge $50
    When PCN is set to 10% of Subscription and applied to all products, countries, Cities,companies
    And Minimum PCN charge is set to $20,with a $2 discount applied to PCN charge.
    Then PCN charge for plan A subscribed by "PM1-A" is $40 * 10%
    And PCN charge for Plan B subscribed by "PM2-A" is $40 * 10%
    And PCN charge for Plan C subscribed by "PM1-A" is $50 * 10%
    And PCN charge for Plan D subscribed by "PM2-A" is $50 * 10%
    And PCN charge for Plan E subscribed by "PM3-A" is $50 * 10%
    But since Minimum PCN charge is set to $20, total PCN charge for plan A,B,C,D,E meets the minimum charge.
    And if $2 discount is still valid for this month
    Then the total PCN charge paid by "PM1-A" for plan A is $40*10-$2
    And the total PCN charge paid by "PM2-A" for plan B is $40*10%-$2
    And the total PCN charge paid by "PM1-A" for plan C is $50*10%-$2
    And the total PCN charge paid by "PM2-A" for plan D is $50*10%-$2
    And the total PCN charge paid by "PM3-A" for plan E is $50*10%-$2
    But if $2 discount exceeds the validity in this month
    Then no discount is applied to PCN

  Scenario: S11 - PCN charges can be set a flat rate and applied to CN market
    Given company A is setup in China
    When "PM1-A" subscribed to plan A at the beginning of this month with a subscription charge $40
    When PCN is set to 0% of Subscription and applied to all products, Cities,companies in China
    And Minimum PCN charge is set to $300 and applied to all products, Cities,companies in China
    Then PCN charge for Plan A subscribed by "PM1-A" is $40 * 0%
    But since Minimum PCN charge is set to $300, total PCN charge does not meet the minimum charge
    Then the total PCN charge paid by "PM1-A" is $300

  Scenario: S12 - PCN charges can be set a flat rate and applied to CN market in a specify city
    Given company A is setup in Beijing China
    When "PM1-A" subscribed to plan A at the beginning of this month with a subscription charge $40
    When PCN is set to 0% of Subscription and applied to all products,companies in Beijing China
    And Minimum PCN charge is set to $300 and applied to all products,companies in Beijing China
    Then PCN charge for Plan A subscribed by "PM1-A" is $40 * 0%
    But since Minimum PCN charge is set to $300, total PCN charge does not meet the minimum charge
    Then the total PCN charge paid by "PM1-A" is $300

  Scenario: S13 - PCN charges can be set a flat rate and applied to CN market in a specify city for a specify company
    Given company A is setup in Beijing, China
    When "PM1-A" subscribed to plan A at the beginning of this month with a subscription charge $40
    When PCN is set to 0% of Subscription and applied to all products and company A in Beijing,China
    And Minimum PCN charge is set to $300 and applied to all products and company A in Beijing,China
    Then PCN charge for Plan A subscribed by "PM1-A" is $40 * 0%
    But since Minimum PCN charge is set to $300, total PCN charge does not meet the minimum charge
    Then the total PCN charge paid by "PM1-A" is $300

  Scenario: S14 - PCN charges can be set a flat rate and applied to CN market in a specify city for a specify company and a specify product/plan
    Given company A is setup in Beijing, China
    When "PM1-A" subscribed to plan A at the beginning of this month with a subscription charge $40
    When PCN is set to 0% of Subscription and applied to plan A and company A in Beijing,China
    And Minimum PCN charge is set to $300 and applied to plan A and company A in Beijing,China
    Then PCN charge for Plan A subscribed by "PM1-A" is $40 * 0%
    But since Minimum PCN charge is set to $300, total PCN charge does not meet the minimum charge
    Then the total PCN charge paid by "PM1-A" is $300

  Scenario: S15 - PCN charges can be set a flat rate and shared within the same company group in the CN market
    Given "DHLSHA", "DHLBJS" are from same group "DHL"
    When "PM1-DHLSHA" subscribes to a plan A at the beginning of this month with a subscription charge $40
    And PCN is set to 0% of the subscription and applied to all products, cities,companies in China
    And the minimum PCN charge is set to $300 and applied to all products, Cities,companies in China
    And PCN is set to share within the group "DHL"
    And Plan A is the first plan subscribed by the "DHL" group
    Then the total PCN charge paid by "PM1-A" is $300
    When "PM1-DHLSHA" subscribes to plan B with a subscription charge $40
    And "DHLSHA" is the same group as "DHLBJS"
    And "DHLBJS" has paid the PCN for Plan A
    Then there is no PCN charge for plan B subscribed by "PM1-DHLSHA"

  Scenario: S16 - PCN charges can be set a flat rate, applied to a specify product/plan
    Given "PM1-A" has subscribed a plan A at the beginning of this month with a subscription charge $40
    When PCN is set to 0% of Subscription and applied to plan A for all counties, cities, companies
    And Minimum PCN charge is set to $300 and applied to plan A
    Then PCN charge for Plan A subscribed by "PM1-A" is $40 * 0%
    But since Minimum PCN charge is set to $300, total PCN charge does not meet the minimum charge
    Then the total PCN charge paid by "PM1-A" is $300

  Scenario: S17 - PCN charges can be set a specify % of subscription charge, applied to a specify product/plan
    Given "PM1-A" has subscribed a plan A at the beginning of this month with a subscription charge $40
    When PCN is set to 10% of Subscription and applied to plan A for all counties, cities, companies
    Then PCN charge for Plan A subscribed by "PM1-A" is $40 * 10%
	
	Scenario: S18 - Subscription of the first month. PCN Configuration:  set to 10% of each subscription, PCN applies to CCN Product.
		Given Minimum PCN charge is set to $20 and applied to CCN Product.
		And PCN Configuration:  set to 10% of each subscription
		And "PM1-A" has subcribe a plan A of CCN Product at the begining of this month with a subscription charge $100
		And "PM1-A" has subcribe a plan B of CCN Product at the begining of this month with a subscription charge $40