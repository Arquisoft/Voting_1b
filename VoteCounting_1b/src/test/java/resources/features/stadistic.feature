Feature: stadistic page 
  Scenario: client makes call to GET /stadistic
    When the client calls /
    Then the client receives status code of 200
    And the client receives the string "Resultado"
    
    Scenario: client makes call to GET /stadistic_col
    When the client calls /
    Then the client receives status code of 200
    And the client receives the string "votos"
    
    Scenario: client makes call to GET /stadistic_tab
    When the client calls /
    Then the client receives status code of 200
    And the client receives the string "partido"
    
    
    Scenario: client makes call to POST /stadistic_json
    When the client calls /
    Then the client receives status code of 200
    And the client receives the string "colegio"