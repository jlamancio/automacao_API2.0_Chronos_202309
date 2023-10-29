#language: pt

@filme
Funcionalidade: CRUD Filme

  Contexto:
    Dado que tenha realizado o login com dados validos
    E que tenha um payload valido de login da API de Filme

  @cadastroFilme
  Cenario: Cadastro Filme
    Quando envio uma requisicao do tipo POST de Filme
    Então valido que recebo status 201 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Comedia"
    E armazeno o id que recebo do response de Filme

  @consultaFilme
  Cenario: Consulta Filme
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Comedia"

  @alteracaoFilme
  Cenario: Alteracao Filme
    E altero o indice 1 da lista de categorias do filme com os valores
      | tipo | Terror |
    Quando realizo uma requisição do tipo PUT de filme
    Então valido que recebo status 200 no response
    E valido que no campo "categorias.tipo[1]" possui o valor "Terror"

  @consultaAposAlteracao
  Cenario: Consulta Filme apos Alteracao
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido que no campo "categorias[0].tipo[1]" possui o valor "Terror"

  @exclusaofilme
  Cenario: Exclusão filme
    Quando realizo uma requisicao do tipo Delete de Filme
    Entao valido que recebo status 200 no response

  @consultaFilmeAposExclusao
  Cenario: Consulta filme após a exclusão
    Quando realizo uma requisicao do tipo GET de Filme atraves do nome
    Entao valido que recebo status 200 no response
    E valido uma que recebo uma lista vazia no response
