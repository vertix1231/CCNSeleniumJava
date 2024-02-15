Feature: SQPP

  @Sqpp-0-1 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website
    Given click member login sqpp
    Given input login sqpp email "<email>" and password "<password>"
    Given go to yopmail
    When enter yopmail email to login "<email>"
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp
    Then continue sign in sqpp
    When click agent managament sqpp

    Examples: 
      | email                             | password |
      | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-0-2 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website
    Given click member login sqpp
    Given input login sqpp email "<email>" and password "<password>"
    Given go to yopmail
    When enter yopmail email to login "<email>"
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp
    Then continue sign in sqpp
    When click agent managament sqpp

    Examples: 
      | email                      | password |
      | headquarter_sq@yopmail.com | P@55w0rd |

  @Sqpp-0-3 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website
    Given click member login sqpp
    Given click sign up sqpp
    Given go to yopmail
    When enter yopmail email to register
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp registration
    Then continue sign up sqpp
    When click agent managament sqpp

    # negatif regis
    Examples: 
      | email                      | password |
      #| testbrancha_member_12@yopmail.com | P@55w0rd |
      | headquarter_sq@yopmail.com | P@55w0rd |

  @Sqpp-0-4 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website
    Given click member login sqpp
    Given click sign up sqpp
    Given go to yopmail
    When enter yopmail email to register
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp registration
    Then continue sign up sqpp
    When click agent managament sqpp

   
    Examples: 
      | email                      | password |
      #| testbrancha_member_12@yopmail.com | P@55w0rd |
      | headquarter_sq@yopmail.com | P@55w0rd |

  @Sqpp-0-5 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website
    Given click member login sqpp
    Given input login sqpp email "<email>" and password "<password>"
    Given go to yopmail
    When enter yopmail email to login "<email>"
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp
    Then continue sign in sqpp
    When click agent managament sqpp

    Examples: 
      | email                      | password      |
      | testsqppppd@yopmail.com | CCNPegasus123 |

  @Sqpp-1 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website
    Given click member login sqpp
    Given input login sqpp email "<email>" and password "<password>"
    Given go to yopmail
    When enter yopmail email to login
    When open yopmail email "CUBEforall by CCN account email verification code"
    When get verification code sqpp
    When back to login page after get verification code sqpp
    Then continue sign in sqpp

    Examples: 
      | email                             | password |
      | testbrancha_member_12@yopmail.com | P@55w0rd |

  @Sqpp-2 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin not taking any action)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-3 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq not taking any action)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-4 @e2e
  Scenario Outline: Reject For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email(admin reject)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-5 @e2e
  Scenario Outline: Reject For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email(admin approve then hq reject)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-6 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(admin invite member approve thru admin and hdq)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-7 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(admin not taking any action after invite member)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-8 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(admin invite with pending hdq approval,then hdq reject)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-9 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(hdq invite member approve)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-10 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(hdq invite member approve then suspend)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-11 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(hdq invite member approve then terminate)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-12 @e2e
  Scenario Outline: admin station can have multiple member for each customer code
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @Sqpp-13 @e2e
  Scenario Outline: hdq can have multiple member for each customer code
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |
      #CUBEforall by CCN account email verification code
