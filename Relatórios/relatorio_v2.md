### Libraryverse

###### Feito por: Ana Bernardino e Marta Sousa

***


## UCs: 
Projeto de Desenvolvimento Móvel, Programação Orientada a Objetos, Programação de Dispositivos Móveis, Bases de Dados, Competências Comunicacionais.


***


## Resumo: 
Ultimamente temos vindo a comprar mais livros, filmes e a certa altura começamos a perder a noção daquilo que já temos e não temos, por isso, o nosso projeto de desenvolvimento móvel contribuirá para a organização de livros, filmes, cujo o nome será Libraryverse. O público-alvo que tencionamos atingir são os bibliófilos e cinéfilos.


***


## Palavras-Chave: 
Livros, Organização, Biblioteca, ISBN, Acessibilidade.


***


## Contexto: 
Hoje em dia, temos a casa desorganizada e cheia de livros e filmes. É mais fácil comprá-los do que organizá-los, por isso acabamos por os amontoar em prateleiras sem qualquer tipo de ordem. Com isto, torna-se fácil de perder a noção de onde estão os livros ou de quantos livros ou filmes se tem ou até os que emprestamos. Apesar de serem feitas listas para manter a organização, nem sempre é fácil pois com o aumento de livros ou filmes torna-se difícil de manter as listas organizadas.


***


## Objetivos: 
Para solucionar este problema, pretendemos desenvolver uma aplicação que ajude os bibliófilos ou cinéfilos na organização dos seus livros, filmes. Pretendemos criar um catálogo digital que permita saber aquilo que o utilizador tem de uma forma fácil, tornando a experiência do utilizador mais apreciativa. Com esta aplicação também vem a facilidade de organização de livros e filmes sendo mais fácil inserir os dados para tornar a lista mais organizada.


***


## Funcionalidades:
Criar diversas listas de livros/filmes, assim como, uma lista de já vistos/lidos/jogados, lista para ler/ver/jogar e fazer uma listagem daquilo que tem ou não em casa, de maneira a conseguir ter noção de quantos livros/filmes tem e se existem repetições. Caso o utilizador empreste ou peça emprestado a alguém também poderá guardar essa informação na Libraryverse.  

A aplicação poderá ainda mostrar informações sobre os livros/filmes, ou seja, haverá sempre a possibilidade de o utilizador procurar o título, autor, ator, editor, produtor, entre outros e de obter os dados que procura. Devido ao ISBN, os livros terão a particularidade de, ao apontar a câmara do seu dispositivo móvel para o código ISBN, o utilizador obterá logo os detalhes do livro em questão. Para obter as informações sobre os filmes vamos utilizar a API [The Movie Database (TMDB)](https://www.themoviedb.org/) e para obter informações sobre os livros vamos utilizar a API [Google Books](https://developers.google.com/books/docs/overview).

A Libraryverse contará ainda com a utilização da localização tendo em conta o Regulamento Geral da Proteção de Dados e com este recurso poderemos mostrar os eventos por perto, relacionados com livros, filmes e jogos com a ajuda da API [Eventbrite](https://www.eventbrite.com/platform/api)

***

## Outras ferramentas já existentes:
As ferramentas que já existem não englobam todos estes temas juntos (livros/filmes). A aplicação Goodreads mostra informações sobre os livros, tem uma listagem de livros lidos, para ler e favoritos, também há a possibilidade de falar com pessoas, seguir listas de outras pessoas e também manda emails com sugestões de livros para ler. Na base de dados IMDB podemos obter dados sobre os filmes, séries e atores, podemos fazer listas, ver as próximas estreias e ainda ver as próximas estreias.

***

## Guiões de teste
### Fazer login:
1. Fazer login: 
    1. Caso o utilizador não tenha uma conta, basta clicar em criar conta e seguir os passos. 
2. Criar uma conta:
    3. Inserir um username.
    4. Inserir o nome do utilizador.
    5. Inserir o email do utilizador.
    6. Inserir uma password e logo a seguir repetir a tal password.
4. Após criar uma conta, o utilizador é redirecionado para a página inicial:
    1. Na página inicial encontra:
      1. Os Livros que o utilizador está a ler ou os últimos 3 livros que o utilizador leu.
      2. As séries que o utilizador está a ver ou as últimas 3 séries que o utilizador viu.
      3. Os últimos 3 filme que o utilizador viu.
 
### Procurar filme: 
1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas a pesquisa.
2. Ao clicar no icon da lupa, o utilizador é redirecionado para uma página diferente que tem uma barra de pesquisa.
3. Nessa barra de pesquisa o utilizador insere o nome do:
    1. filme/livro
    2. produtor/autor 
    3. ator/editora 
4. Aparece uma lista de sugestões relacionadas com a pesquisa(que são retiradas das API's MovieDB para filmes/séries e Google Books para livros). 

### Ler o código de barra dos livros: 
1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas a a câmera.
2. Ao carregar no icon da câmera, o utilizador é redirecionado para a câmera do smartphone.
3. Com a câmera o utilizador pode ler o código de barras e o livro é inserido automáticamente na sua lista.
4. Quando o livro é lido pela câmera, na aplicação aparece a foto da capa do livro com um pequeno resumo ao lado ou em baixo, aparece o autor e a editora do livro.
5. Aparece uma lista de sugestões relacionadas com a pesquisa(que são retiradas da API Google Books para livros).

### Menu:
1.  Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas o menu que se encontra no canto superior esquerdo do ecrâ, onde o utilizador tem acesso à sua lista de:
  1. livros lidos, para ler e favoritos.
  2. filmes vistos, para ver e favoritos.
  3. séries vistas, para ver e favoritos.


### Eventos:
1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas a localização que se encontra no canto inferior esquerdo.
2. Pedir acesso ao utilizador para usarmos a localização.
3. 



   


***

## Conclusão:
Assim, esta aplicação pode ser usada de diferentes maneiras, para pessoas com diferentes gostos. Ao desenvolvermos a libraryverse oferecemos uma maneira mais simples e fácil de organizar e criar listas, tornando a experiencia de ler livros ou ver filmes mais apelativa. 
