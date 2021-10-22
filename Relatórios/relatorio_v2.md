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
Hoje em dia, temos a casa desorganizada e cheia de livros [[1]](https://rr.sapo.pt/noticia/vida/2021/09/06/venda-de-livros-em-portugal-recupera-e-sobe-141/252153/) e filmes. É mais fácil comprá-los do que organizá-los, por isso acabamos por os amontoar em prateleiras sem qualquer tipo de ordem. Com isto, torna-se fácil de perder a noção de onde estão os livros ou de quantos livros ou filmes se tem ou até os que emprestamos. Apesar de serem feitas listas para manter a organização, nem sempre é fácil pois com o aumento de livros ou filmes torna-se difícil de manter as listas organizadas.


***


## Objetivos: 
Para solucionar este problema, pretendemos desenvolver uma aplicação que ajude os bibliófilos ou cinéfilos na organização dos seus livros e filmes. Pretendemos criar um catálogo digital que permita saber aquilo que o utilizador tem de uma forma fácil, tornando a experiência do utilizador mais apreciativa. Com esta aplicação também vem a facilidade de organização de livros e filmes sendo mais fácil inserir os dados para tornar a lista mais organizada.


***


## Funcionalidades:
Criar diversas listas de livros/filmes, assim como, uma lista de já vistos/lidos, lista para ler/ver e fazer uma listagem daquilo que tem ou não em casa, de maneira a conseguir ter noção de quantos livros/filmes tem e se existem repetições. Caso o utilizador empreste ou peça emprestado a alguém também poderá guardar essa informação na Libraryverse. Nesta aplicação o utilizador também poderá encontrar informação sobre atores e autores.

A aplicação poderá ainda mostrar informações sobre os livros/filmes, ou seja, haverá sempre a possibilidade de o utilizador procurar o título, autor, ator, editor, produtor, entre outros e de obter os dados que procura. Devido ao ISBN, os livros terão a particularidade de, ao apontar a câmara do seu dispositivo móvel para o código ISBN, o utilizador obterá logo os detalhes do livro em questão. Para além de obter os detalhes do livro através do scan do ISBN, o utilizador ainda poderá adicionar, de forma mais rápida, o livro a uma das suas listas. Para obter as informações sobre os filmes vamos utilizar a API [The Movie Database (TMDB)](https://www.themoviedb.org/) e para obter informações sobre os livros vamos utilizar a API [Google Books](https://developers.google.com/books/docs/overview).

A Libraryverse contará ainda com a utilização da localização tendo em conta o Regulamento Geral da Proteção de Dados. Com este recurso poderemos mostrar os eventos por perto, relacionados com livros e filmes com a ajuda da API [Eventbrite](https://www.eventbrite.com/platform/api).

***

## Outras ferramentas já existentes:
As ferramentas que já existem não englobam todos estes temas juntos (livros/filmes). A aplicação Goodreads mostra informações sobre os livros, tem uma listagem de livros lidos, para ler e favoritos, também há a possibilidade de falar com pessoas, seguir listas de outras pessoas e também manda emails com sugestões de livros para ler. Na base de dados IMDB podemos obter dados sobre os filmes, séries e atores, podemos fazer listas, e ainda ver as próximas estreias.

***

## Guiões de teste
### Fazer login/Criar conta:
1. Inserir o nome de utilizador;
2. Inserir a palavra-passe;
3. Opção para criar conta caso o utilizador ainda não tenha conta:
    1. Inserir um username;
    2. Inserir o nome do utilizador;
    3. Inserir o email do utilizador;
    4. Inserir uma password;
    5. Repetir a password;
3. Após fazer login ou de criar uma conta, o utilizador é redirecionado para a página inicial onde irá ver:
      1. Os livros que o utilizador está a ler ou os últimos 3 livros que o utilizador leu.
      2. As séries que o utilizador está a ver ou as últimas 3 séries que o utilizador viu.
      3. Os últimos 3 filme que o utilizador viu.
 
### Procurar filme:
(Por procurar filme entende-se pesquisar filme, livro, autor ou ator)
1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas a pesquisa.
2. Ao clicar no icon da lupa, o utilizador é redirecionado para uma página diferente que tem uma barra de pesquisa.
3. Nessa barra de pesquisa o utilizador insere o nome do:
    1. filme/livro
    2. produtor/autor 
    3. ator/editora 
4. Aparece uma lista de sugestões relacionadas com a pesquisa(que são retiradas das API's The MovieDB para filmes/séries e Google Books para livros). 

### Ler o código de barra dos livros: 
1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas a da câmara;
2. Ao carregar no icon da câmara, o utilizador é redirecionado para a câmara do smartphone;
3. Fazer o scan do código de barras;
4. O livro é inserido automáticamente na sua lista;
5. São apresentados os dados do livro, assim como, a foto da capa do livro com um pequeno resumo ao lado ou em baixo, aparece o autor e a editora do livro.

### Menu:
1.  Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas o menu que se encontra no canto superior esquerdo do ecrâ, onde o utilizador tem acesso à sua lista de:
  1. livros lidos, para ler e favoritos.
  2. filmes vistos, para ver e favoritos.
  3. séries vistas, para ver e favoritos.

### Eventos:
1. Ao entrar, na página principal o utilizador tem acesso a várias funções, sendo uma delas a localização que se encontra no canto inferior esquerdo;
2. Ao carregar no icon do mapa, o utilizador recebe uma notificação a perguntar se aceita que a aplicação utilize a localização;
3. Ao aceitar o uso da localização, o utilizador é redirecionado para uma página diferente onde encontra um mapa;
   1. No topo do ecrã encontra uma barra de pesquisa onde o utilizador pode inserir a cidade/morada, e após inserir no mapa aparecem as localizações dos eventos mais próximos da morada inserida;
   2. A partir da localização pedir para mostrar quais são os eventos na área onde se encontra;
5. Após o utilizador carregar no evento que deseja ver, ele é redirecionado para uma nova pagina onde aparece o nome do evento, uma fotografia do evento e uma pequena descrição do evento.


***

## Conclusão:
Assim, esta aplicação pode ser usada de diferentes maneiras, para pessoas com diferentes gostos. Ao desenvolvermos a libraryverse oferecemos uma maneira mais simples e fácil de organizar e criar listas, tornando a experiencia de ler livros ou ver filmes mais apelativa. 
