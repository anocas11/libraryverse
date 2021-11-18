#### Libraryverse  

###### Feito por: Ana Bernardino e Marta Sousa
 
***

## UCs:

Projeto de Desenvolvimento Móvel, Programação Orientada a Objetos, Programação de Dispositivos Móveis, Bases de Dados, Competências Comunicacionais,  

*** 

## Resumo  

O nosso projeto de desenvolvimento móvel contribuirá para o interesse de fãs acerca de filmes/séries que se baseiam em livros. Esta aplicação também servirá para os fãs se conhecerem entre eles como também descobrir novos interesses em diferentes universos de filmes. Esta aplicação tem como público-alvo os cinéfilos hardcore de universos de filmes/séries que existem.  

***

## Palavras-chave:  

Filmes, Séries, Localização de filmagens, trivia.  

***

## Contexto:  

Hoje em dia, com o aumento dos universos de filmes como a Marvel, DC, senhor dos anéis, faz com que as pessoas se interessem por diferentes tipos de filmes. Com isto, estão a ser criadas fanbases em que estes fãs podem falar e discutir com outros fãs acerca destes filmes. Mas apesar de tudo, nem todos os fãs conseguem discutir tais assuntos ou então são fãs com interesses em diferentes universos causando alguma dificuldade em partilhar interesses.  

*** 

## Objetivo:  

Para solucionar este problema, pretendemos desenvolver uma aplicação que ajude estes fãs a discutirem os seus interesses e ao mesmo tempo criando um lugar seguro e aberto para falarem entre eles. Ao mesmo tempo também criámos esta aplicação para aumentar o interesse dos utilizadores que ainda não descobriram estes universos ou então não conhecem o suficiente para se interessarem por eles. Com isto, queremos criar também uma parte que mostre as localizações dos sítios onde foram filmados estes filmes para aqueles fãs hardcore que gostem de seguir tudo sobre os filmes. E, ainda, vai haver uma zona com factos interessantes e trivia para aumentar o conhecimento sobre estes filmes/universos.  

*** 

## Funcionalidades:  

Criar um groupchat para fãs falarem entre eles. Criar uma página para os utilizadores escolherem que universo de filmes querem seguir. Acesso a uma página de trivia e a um trivia quiz. Para aqueles que gostam de visitar os sítios das gravações, vai haver um mapa com os sítios onde as cenas foram gravadas. Para obter as informações sobre os filmes vamos utilizar a API [The Movie Database (TMDB)](https://www.themoviedb.org/) e para obter informações sobre os livros vamos utilizar a API [Google Books](https://developers.google.com/books/docs/overview).

 

## Guiões de Teste  
  
### Guião de teste nº1:  

#### Fazer login/Criar conta:  
   1. Inserir o nome de utilizador;  
   2. Inserir a palavra-passe;  
   3. Opção para criar conta caso o utilizador ainda não tenha conta:  
        1. Inserir um username;  
        2. Inserir o nome do utilizador;  
        3. Inserir o e-mail do utilizador;  
        4. Inserir uma password;  
        5. Repetir a password;  
   4. Após fazer login ou de criar uma conta, o utilizador é redirecionado para a página inicial onde irá ver:  
   5. Os filmes que o utilizador adicionou e pelo qual se interessa;  
   6. As próximas estreias dos filmes que vão sair desse universo ou novos episódios;  
   7. O groupchat onde o utilizador falou em último lugar;  

  

### Guião de teste nº2:  

#### Procurar filme:  
 1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas a pesquisa;  
 2. Ao clicar no ícone da lupa, o utilizador é redirecionado para uma página diferente que tem uma barra de pesquisa;  
 3. Nessa barra de pesquisa o utilizador insere o nome do:  
    1. filme
    2. Produtor
    3. Autor
    4. Ator
    5. Nome do livro 
 4. Aparece uma lista de sugestões relacionadas com a pesquisa (informações fornecidas pela API The MovieDB para filmes);  
 5. O utilizador seleciona o item que quer;  
 6. A aplicação mostra informações sobre o item selecionado (informações fornecidas pelas API's The MovieDB para filmes).  

  

### Guião de teste nº3:  

#### Menu:  
 1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas o menu que se encontra no canto superior esquerdo do ecrã, onde o utilizador tem acesso à sua lista de:  
    1. Filmes do universo que segue.  
    2. Próximas estreias desses universos.  

### Guião de teste nº4:  

#### Localização:  
 1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas a localização que se encontra no canto superior esquerdo do ecrã,  
 2. Ao selecionar, o utilizador tem acesso a um mapa onde pode ver diferentes localizações de onde os filmes foram filmados. 
    
    
***

## Personas:
 
### André (12 anos):
O André tem 12 anos e anda no 7º ano da escola Vasco da Gama. Desde de pequeno que ele gosta de ver filmes com o seu pai, e desde de aí que ganhou um gosto por filmes da MARVEL. Então ele tornou-se num fã desses filmes, colecionando bandas desenhadas e merchandising. À medida que ele foi crescendo, a sua coleção foi aumentando, como também as plataformas de comunicação com os fãs. Por isso, ele começou a precisar de um sítio não só para organizar como também para comunicar com outros fãs. Ao aderir ao Libraryverse, o André conseguiu organizar os seus filmes e banda desenhada, como também comunicar com outros fãs sem ter que mudar de aplicação.
 
### Catarina(16 anos):
A Catarina atualmente frequenta o 11º ano no Liceu Camões, em Lisboa. Aos 12 anos descobriu o seu gosto por fantasia e magia devido aos livros que os seus pais lhe ofereciam no natal. Estes livros eram a coleção do Harry Potter.  Sendo a Catarina uma leitora compulsiva, ela devorou os livros em poucos meses. Após acabar a coleção, ela queria saber mais então foi ver os filmes, tornando-se assim uma PotterHead. Quando passou para o décimo ano e passou a focar-se mais na escola, Catarina ficou sem tempo para Harry Potter e para os novos filmes/livros que iam saindo. Com isto, ela aderiu ao Libraryverse não só para organizar a sua coleção como também para se manter informada em relação aos novos filmes/livros que iam saindo e para ir falando com outros fãs para obter novas informações.
 
### Francisco (21 anos):
No seu último ano da faculdade, foi pedido ao Francisco para fazer um trabalho sobre livros que ele leu quando era mais novo. O único livro que lhe veio a cabeça foram as aventuras de TinTim. No entanto, ele tinha pouco tempo até ter que entregar o trabalho, daí não ter tido tempo para procurar os livros na garagem, que era onde a mãe dele tinha guardado a caixa com livros antigos. Então ele aí lembrou-se de uma aplicação que tinha ouvido falar chamada Libraryverse, que lhe facilitava a pesquisa e organização de livros, juntamente com outras informações. Assim, depois de aderir à aplicação, o Francisco pesquisou e organizou a sua coleção de livros do TinTim, a série e o filme, ajudando-o assim a completar o seu trabalho a tempo do prazo de entrega.
 
### Joana (34 anos):
Há já algum tempo que a Joana trabalha no jornal da cidade onde vive. E apesar de o jornal servir para partilhar informações importantes sobre o que está a acontecer na sociedade no momento, ela achava que podia servir também para outras coisas. Com o Covid, houve tempos em que as pessoas que tiveram que ficar em casa já estavam fartas de fazer nada e, sendo estes tempos difíceis, a Joana pensou numa maneira que pudesse animar as pessoas nestes tempos difíceis. Assim, ela lembrou-se do quanto adorava o Asterix e Obélix. Depois de falar com o chefe, a Joana juntou na sua aplicação Libraryverse as bandas desenhadas do Asterix e Obélix juntamente com os filmes. Criou também uma sala de chat para os fãs puderem dar sugestões para novos conteúdos. Após organizar as coisas, todas as semanas um pedaço das bandas desenhadas aparecia no jornal juntamente com o link da aplicação para as pessoas se puderem juntar a sala chat, mas também para pesquisarem outros livros e filmes, tornando assim estes tempos difíceis mais toleráveis.
 
### Hugo (45 anos):
Todos os anos o Hugo via os filmes do Senhor dos Anéis, mas nunca foi o mesmo que ler os livros. Com isto, ele foi à procura dos livros que se lembrava de ler em pequeno, mas após tanto tempo ele já não sabia onde estavam, nem como é que os livros eram. Então, ele aderiu a aplicação Libraryverse para pesquisar os filmes do Senhor dos Anéis e assim chegou a informação dos livros. Com esta informação ele conseguiu ir procurar os livros e encontrou-os. Ao mesmo tempo, quando ele pesquisou os filmes, a aplicação também lhe sugeriu o Hobbit que era um filme que ele nunca tinha visto mas tinha lido o livro, o que o levou a ver o filme mais tarde. Com a aplicação conseguiu organizar os seus livros e filmes e estar a par das novas informações relacionadas com este universo devido aos chats entre os fãs.

***

## Conclusão:  

Com esta aplicação, os cinéfilos hardcore vão poder saber tudo sobre os universos que seguem ou sobre outros. Será possível saber que filmes abrange esse universo, onde foram filmadas as cenas e outras curiosidades.  
