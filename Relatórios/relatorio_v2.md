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
1. Fazer login 
    1. Inserir username 
    2. Inserir password 
2. O utilizador é redirecionado para a página principal onde visiona os:
    1. 3 sugestões de filmes
    2. 3 sugestões de livros 

### Procurar filme: 
1. O utilizador faz login
2. O utilizador é redirecionado para a página principal 
    1. 3 últimos filmes vistos 
    2. 3 últimos livros lidos 

### Guião de teste nº3: 
1. O utilizador abre a aplicação 
2. O utilizador é redirecionado para a página principal 
   1. 3 últimos filmes vistos 
   2. 3 últimos livros lidos 
3. Numa barra de texto, inserir o nome do filme 
4. Obter dados sobre o filme 
5. Adicionar aos filmes vistos 
6. Numa barra no fundo do ecrã, o utilizador seleciona filmes ou jogos 

***

## Conclusão:
Assim, esta aplicação pode ser usada de diferentes maneiras, para pessoas com diferentes gostos. Ao desenvolvermos a libraryverse oferecemos uma maneira mais simples e fácil de organizar e criar listas, tornando a experiencia de ler livros ou ver filmes mais apelativa. 
