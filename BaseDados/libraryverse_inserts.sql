
insert into book (book_id, book_name, book_date, book_description) values('1','Tintim na América' , to_date('1931', 'YYYY'), 'Depois de enfrentar um bando de gângsters no Congo, Tintim é enviado para Chicago, EUA, para livrar a cidade dos criminosos. ... Assim que escapa dos comparsas de Al Capone, Tintim cai numa armadilha de Bobby Smiles, líder do Sindicato dos Gângsters de Chicago');
insert into book (book_id, book_name, book_date, book_description) values('2', 'Harry Potter e a camera dos segredos', to_date('1998', 'YYYY'), 'Após as sofríveis férias na casa dos tios, Harry Potter se prepara para voltar a Hogwarts e começar seu segundo ano na escola de bruxos. Na véspera do início das aulas, a estranha criatura Dobby aparece em seu quarto e o avisa de que voltar é um erro e que algo muito ruim pode acontecer se Harry insistir em continuar os estudos de bruxaria. O garoto, no entanto, está disposto a correr o risco e se livrar do lar problemático.');
insert into book (book_id, book_name, book_date, book_description) values('3', 'As serviçais', to_date('2009', 'YYYY'), 'Nos anos 60, no Mississippi, Skeeter é uma garota da alta sociedade que retorna determinada a se tornar escritora. Ela começa a entrevistar as mulheres negras da cidade, que deixaram suas vidas para trabalhar na criação dos filhos da elite branca, da qual a própria Skeeter faz parte. Aibileen Clark, a emprega da melhor amiga de Skeeter, é a primeira a conceder uma entrevista. Apesar das críticas, Skeeter e Aibileen continuam trabalhando juntas e, aos poucos, conseguem novas adesões.');
insert into book (book_id, book_name, book_date, book_description) values('4', 'No coração do mar', to_date('2000', 'YYYY'), 'No Coração do Mar é um livro do historiador americano Nathaniel Philbrick, no qual ele narra em detalhes a tragédia do navio baleeiro Essex que, em 1820, perseguiu uma baleia Cachalote no Pacífico, vindo a afundar.' );
insert into book (book_id, book_name, book_date, book_description) values('5', 'Harry Potter e a Pedra Filosofal', to_date('1995', 'YYYY'), '«Voltando o sobrescrito ao contrário, com as mãos a tremer, Harry viu um selo de lacre cor de púrpura com um brasão onde podia distinguir-se um leão, uma águia, um texugo e uma serpente envolvendo a letra H.» Harry Potter nunca tinha ouvido falar de Hogwarts quando as cartas começaram a cair na entrada do número quatro, em Privet Drive. Com a morada escrita a verde num sobrescrito em papel pergaminho amarelo com lacre a roxo, são rapidamente confiscadas pelos seus tios horríveis. Mas no dia do décimo primeiro aniversário de Harry, um gigante de olhos pretos e brilhantes chamado Rubeus Hagrid entra abruptamente com notícias surpreendentes: Harry Potter é um feiticeiro e tem um lugar à sua espera na escola de magia e feitiçaria de Hogwarts. Vai começar uma incrível aventura!');

insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description, movie_cu_id) values ('1', 'As Aventuras de TinTim - O Segredo do Licorne', to_date('2011-10-24', 'YYYY-MM-DD'), '01:47:00', 'A aventura começa assim que Tintim compra a miniatura de um barco. Sem saber o segredo do objeto, ele e seu cachorro são sequestrados. Presos em um barco, conseguem escapar junto com o capitão e, aos poucos, vão decifrando todos os mistérios.', '2');
insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description, movie_cu_id) values ('2', 'Harry Potter e a Câmara dos Segredos',  to_date('2002-11-13', 'YYYY-MM-DD'), '02:41:00', 'Após as sofríveis férias na casa dos tios, Harry Potter se prepara para voltar a Hogwarts e começar seu segundo ano na escola de bruxos. Na véspera do início das aulas, a estranha criatura Dobby aparece em seu quarto e o avisa de que voltar é um erro e que algo muito ruim pode acontecer.', '1');
insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description) values ('3', 'As Serviçais', to_date('2011-10-8', 'YYYY-MM-DD'), '02:26:00', 'Nos anos 60, no Mississippi, Skeeter é uma garota da alta sociedade que retorna determinada a se tornar escritora. Ela começa a entrevistar as mulheres negras da cidade, que deixaram suas vidas para trabalhar na criação dos filhos da elite branca, da qual a própria Skeeter faz parte. ');    
insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description) values ('4', 'No coração do mar', to_date('2015-11-12', 'YYYY-MM-DD'), '02:02:00', 'A tripulação do barco baleeiro Essex precisa fazer o impossível para sobreviver em uma ilha deserta após sofrer brutal ataque de uma baleia gigantesca.');  
insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description, movie_cu_id) values ('5', 'Harry Potter e a Pedra Filosofal',  to_date('2001-11-16', 'YYYY-MM-DD'), '02:32:00', 'Após as sofríveis férias na casa dos tios, Harry Potter se prepara para voltar a Hogwarts e começar seu segundo ano na escola de bruxos. Na véspera do início das aulas, a estranha criatura Dobby aparece em seu quarto e o avisa de que voltar é um erro e que algo muito ruim pode acontecer.', '1');

insert into cinematicuniverse (cu_id, cu_name) values('1', 'Wizarding World');
insert into cinematicuniverse (cu_id, cu_name) values('2', 'Les Aventures de Tintin');

insert into genre (genre_id, genre_name) values('1', 'Drama');
insert into genre (genre_id, genre_name) values('2', 'Adventure');
insert into genre (genre_id, genre_name) values('3', 'Fantasy');
insert into genre (genre_id, genre_name) values('4', 'Action');
insert into genre (genre_id, genre_name) values('5', 'Biography');
insert into genre (genre_id, genre_name) values('6', 'Animation');
insert into genre (genre_id, genre_name) values('7', 'Comics');