### Libraryverse

###### Feito por: Ana Bernardino e Marta Sousa



***


## UCs: 
Projeto de Desenvolvimento Móvel, Programação Orientada a Objetos, Programação de Dispositivos Móveis, Bases de Dados, Competências Comunicacionais.





***


## Resumo: 
O nosso projeto de desenvolvimento móvel contribuirá para a organização de livros, filmes e jogos, cujo o nome será libraryverse e o público-alvo que tencionamos atingir são os bibliófilos, gamers e cinéfilos.






***


## Palavras-Chave: 
Livros, Organização, Biblioteca, ISBN, Acessibilidade, Empréstimos, Listas, Catálogo.






***


## Contexto: 
Hoje em dia, temos a casa desorganizada e cheia de livros, jogos e filmes. É mais fácil comprá-los do que organizá-los, por isso acabamos por os amontoar em prateleiras sem qualquer tipo de ordem. Com isto, torna-se fácil de perder a noção de onde estão os livros ou de quantos livros, jogos ou filmes se tem ou até os que emprestamos. Apesar de serem feitas listas para manter a organização, nem sempre é fácil pois com o aumento de livros, jogos ou filmes torna-se difícil de manter as listas organizadas.






***


## Objetivos: 
Para solucionar este problema, pretendemos desenvolver uma aplicação que ajude os bibliófilos, gamers ou cinéfilos na organização dos seus livros, jogos, filmes. Pretendemos criar um catálogo digital que permita saber aquilo que o utilizador tem de uma forma fácil, tornando a experiencia do utili<adpr mais apreciativa. Com esta aplicação também vem a facilidade de organização de livros, jogos e filmes sendo mais fácil inserir os dados para tornar a lista mais organizada.





***


## Funcionalidades:
Criar diversas listas de livros/filmes/jogos, assim como, uma lista de já vistos/lidos/jogados, lista para ler/ver/jogar e fazer uma listagem daquilo que tem ou não em casa, de maneira a conseguir ter noção de quantos livros/jogos/filmes tem e se existem repetições. Caso o utilizador empreste ou peça emprestado a alguém também poderá guardar essa informação na Libraryverse.  

A aplicação poderá ainda mostrar informações sobre os livros/filmes/jogos, ou seja, haverá sempre a possibilidade de o utilizador procurar o título, autor, ator, editor, produtor, entre outros e de obter os dados que procura. Devido ao ISBN, os livros terão a particularidade de ao apontar a câmara do seu dispositivo móvel para o código ISBN, o utilizador obterá logo os detalhes do livro em questão. Para obter as informações sobre os filmes vamos utilizar a API [The Movie Database (TMDB)](https://www.themoviedb.org/) , para obter informações sobre os jogos vamos utilizar a API [Steam Web API Documentation](https://steamapi.xpaw.me/) . 

A Libraryverse contará ainda com a utilização da localização tendo em conta o Regulamento Geral da Proteção de Dados e com este recurso poderemos mostrar os eventos por perto, relacionados com livros, filmes e jogos.


## Outras ferramentas já existentes:
As ferramentas que já existem não englobam todos estes temas juntos (livros/jogos/filmes). A Steam é uma aplicação que apenas faz uma listagem de jogos para computador, tem chat para falar com amigos e uma lista de desejos onde às vezes mostra promoções para os jogos aí listados. A aplicação Goodreads mostra informações sobre os livros, tem uma listagem de livros lidos, para ler e favoritos, também há a possibilidade de falar com pessoas, seguir listas de outras pessoas e também manda emails com sugestões de livros para ler. Na base de dados IMDB podemos obter dados sobre os filmes, séries e atores, podemos fazer listas, ver as próximas estreias e ainda ver as próximas estreias.

## Guiões de teste
### Guião de teste nº1:
1. Fazer login 
    1. Inserir username 
    2. Inserir password 
2. Utilizador é redirecionado para a página principal 
    1. 3 últimos filmes vistos 
    2. 3 últimos livros lidos 
    3. 3 últimos jogos jogados 
3. Carregar no botão para fazer scan do ISBN dos livros 
4. Obter informações sobre o livro 
5. Adicionar aos livros lidos 
6. Numa barra no fundo do ecrã, o utilizador seleciona a lista dos jogos, filmes ou jogos 

### Guião de texto nº2: 
1. O utilizador abre a aplicação 
2. O utilizador é redirecionado para a página principal 
    1. 3 últimos filmes vistos 
    2. 3 últimos livros lidos 
    3. 3 últimos jogos jogados 
3. Numa barra de texto, inserir o nome do jogo 
4. Obter dados sobre o jogo 
5. Adicionar aos jogos favoritos 
6. Numa barra no fundo do ecrã, o utilizador seleciona a lista dos jogos, filmes ou jogos 

### Guião de texto nº3: 
1. O utilizador abre a aplicação 
2. O utilizador é redirecionado para a página principal 
   1. 3 últimos filmes vistos 
   2. 3 últimos livros lidos 
   3. 3 últimos jogos jogados 
3. Numa barra de texto, inserir o nome do filme 
4. Obter dados sobre o filme 
5. Adicionar aos filmes vistos 
6. Numa barra no fundo do ecrã, o utilizador seleciona a lista dos jogos, filmes ou jogos 


O presente relatório visa propor um projeto de desenvolvimento móvel que contribuirá para a organização de livros, filmes e jogos para computador, telemóvel e outras consolas, cujo nome será Libraryverse e o público-alvo que tencionamos atingir são os bibliófilos, gamers e cinéfilos.

Esta aplicação tem como objetivo criar uma biblioteca para livros, filmes e/ou jogos, uma vez que depende do gosto do utilizador. A principal ideia é o utilizador poder criar diversas listas de livros/filmes/jogos, assim como, uma lista de já vistos/lidos/jogados, lista para ler/ver/jogar e fazer uma listagem daquilo que tem ou não em casa, de maneira a conseguir ter noção de quantos livros/jogos/filmes tem e se existem repetições. Caso o utilizador empreste ou peça emprestado a alguém também poderá guardar essa informação na Libraryverse.  

A aplicação poderá ainda mostrar informações sobre os livros/filmes/jogos, ou seja, haverá sempre a possibilidade de o utilizador procurar o título, autor, ator, editor, produtor, entre outros e de obter os dados que procura. Devido ao ISBN, os livros terão a particularidade de ao apontar a câmara do seu dispositivo móvel para o código ISBN, o utilizador obterá logo os detalhes do livro em questão.

A Libraryverse contará ainda com a utilização da localização tendo em conta o Regulamento Geral da Proteção de Dados e com este recurso poderemos mostrar os eventos por perto, relacionados com livros, filmes e jogos.

As ferramentas que já existem não englobam todos estes temas juntos (livros/jogos/filmes). A Steam é uma aplicação que apenas faz uma listagem de jogos para computador, tem chat para falar com amigos e uma lista de desejos onde às vezes mostra promoções para os jogos aí listados. A aplicação Goodreads mostra informações sobre os livros, tem uma listagem de livros lidos, para ler e favoritos, também há a possibilidade de falar com pessoas, seguir listas de outras pessoas e também manda emails com sugestões de livros para ler. Na base de dados IMDB podemos obter dados sobre os filmes, séries e atores, podemos fazer listas, ver as próximas estreias e ainda ver as próximas estreias.


