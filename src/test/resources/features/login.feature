#language:pt
@regressao
Funcionalidade: Realizar Login
  Testes de Login na API Plataforma Filmes

  @login
  Cenario: Realizar Login com Sucesso
    Dado que tenha um payload valido de login da API PlataformaFilmes
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 200 no response
    E armazeno o token que recebo do response de Login

  @loginInvalido
  Esquema do Cenario: Realizar Login com <Cenario>
    Dado que tenha um payload de Login da API PlataformaFilmes com as seguintes informacoes
      | email | <email> |
      | senha | <senha> |
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 400 no response

    Exemplos:
      | Cenario          | email              | senha    |
      | Usuario Invalido | invalido@email.com | 123456   |
      | Senha Invalida   | aluno@email.com    | invalida |