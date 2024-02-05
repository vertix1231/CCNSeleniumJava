Feature: AWB Concierge Product Plan

  @AWBConciergeplan-1 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq approve)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin not taking any action)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: Approve For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email (admin approve, hq not taking any action)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: Reject For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email(admin reject)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: Reject For an agent company that doesnt have any local key,  the first local key user signs up via the SSO page without an invitation email(admin approve then hq reject)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(admin invite member approve thru admin and hdq)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(admin not taking any action after invite member)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(admin invite with pending hdq approval,then hdq reject)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(hdq invite member approve)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |

  @AWBConciergeplan-1 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(hdq invite member approve then suspend)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |
      
  @AWBConciergeplan-1 @e2e
  Scenario Outline: For an agent company that doesnt have any local key, the first local key user is added by station admin with an invitation email.(hdq invite member approve then terminate)
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |
      
  @AWBConciergeplan-1 @e2e
  Scenario Outline: admin station can have multiple member for each customer code
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |
      
      @AWBConciergeplan-1 @e2e
  Scenario Outline: hdq can have multiple member for each customer code
    Given go to sqpp website

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |
