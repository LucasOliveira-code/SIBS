Feature: Preencher formulario para novo cliente loja fisica
  Eu como novo cliente de loja fisica
  quero preencher o formulario
  para começar a aceitar MBWay na minha loja fisica

  Scenario: Preechendo formulario para loja fisica
    Given que estou no portal MBWay
    When seleciono a opcao "EMPRESAS"
    And seleciono a opcao "EM LOJA FÍSICA"
    Then clico no botao "ADERIR"
    And preencher no campo "nome" meu nome completo "SIBS QA TESTE"
    And preencher no campo "telefone" meu numero de telefone "219230083"
    And preencher no campo "email" meu email "teste@teste.com"
    And seleciono no campo "pais-p1" o pais "Portugal"
    And preencher no campo "nif-empresa" meu NIF "268435308"
    And seleciono no campo "solucoes" uma solucao "Aceitar pagamentos em loja física"
    And seleciono no campo "banco" o "Novo Banco"
    And aceito a politica de privacidade
    And clico no botao Submeter
    Then visualizo a mensagem Obrigado pela Submissao