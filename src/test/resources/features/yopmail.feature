@yopmailall
Feature: Login Cubeforall

  @yopmail1
  Scenario Outline: Login yopmail
    Given go to yopmail
    When enter yopmail email to login
    When open yopmail email "Je viens de t'ajouter dans mes favoris"

    Examples: 
      | Email                         | Password      |
      | sgqa-ccn-72920@mailinator.com | CCNPegasus123 |
