Feature: SQPP

  @Sqpp-1 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website
   

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

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