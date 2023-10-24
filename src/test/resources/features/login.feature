#language:pt
Funcionalidade: Realizar Login
  Testes de Login na API Plataforma Filmes

  Cenario: Realizar Login com Sucesso
    Dado que tenha um payload valido de login da API PlataformaFilmes
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 200 no response
    E armazeno o token que recebo do response de Login

  Cenario: Realizar Login com usuario invalido
    Dado que tenha um payload de Login da API PlataformaFilmes com as seguintes informacoes
      | email | invalido@email.com |
      | senha | 123456             |
    Quando envio uma requisicao do tipo POST de Login
    Entao valido que recebo status 400 no response

