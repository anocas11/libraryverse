
insert into book (book_id, book_name, book_date, book_description, book_cu_id) values('1','Tintim na América' , to_date('1931', 'YYYY'), 'Depois de enfrentar um bando de gângsters no Congo, Tintim é enviado para Chicago, EUA, para livrar a cidade dos criminosos. ... Assim que escapa dos comparsas de Al Capone, Tintim cai numa armadilha de Bobby Smiles, líder do Sindicato dos Gângsters de Chicago', '2');
insert into book (book_id, book_name, book_date, book_description, book_cu_id) values('2', 'Harry Potter e a camera dos segredos', to_date('1998', 'YYYY'), 'Após as sofríveis férias na casa dos tios, Harry Potter se prepara para voltar a Hogwarts e começar seu segundo ano na escola de bruxos. Na véspera do início das aulas, a estranha criatura Dobby aparece em seu quarto e o avisa de que voltar é um erro e que algo muito ruim pode acontecer se Harry insistir em continuar os estudos de bruxaria. O garoto, no entanto, está disposto a correr o risco e se livrar do lar problemático.', '1');
insert into book (book_id, book_name, book_date, book_description) values('3', 'As serviçais', to_date('2009', 'YYYY'), 'Nos anos 60, no Mississippi, Skeeter é uma garota da alta sociedade que retorna determinada a se tornar escritora. Ela começa a entrevistar as mulheres negras da cidade, que deixaram suas vidas para trabalhar na criação dos filhos da elite branca, da qual a própria Skeeter faz parte. Aibileen Clark, a emprega da melhor amiga de Skeeter, é a primeira a conceder uma entrevista. Apesar das críticas, Skeeter e Aibileen continuam trabalhando juntas e, aos poucos, conseguem novas adesões.');
insert into book (book_id, book_name, book_date, book_description) values('4', 'No coração do mar', to_date('2000', 'YYYY'), 'No Coração do Mar é um livro do historiador americano Nathaniel Philbrick, no qual ele narra em detalhes a tragédia do navio baleeiro Essex que, em 1820, perseguiu uma baleia Cachalote no Pacífico, vindo a afundar.' );
insert into book (book_id, book_name, book_date, book_description, book_cu_id) values('5', 'Harry Potter e a Pedra Filosofal', to_date('1995', 'YYYY'), '«Voltando o sobrescrito ao contrário, com as mãos a tremer, Harry viu um selo de lacre cor de púrpura com um brasão onde podia distinguir-se um leão, uma águia, um texugo e uma serpente envolvendo a letra H.» Harry Potter nunca tinha ouvido falar de Hogwarts quando as cartas começaram a cair na entrada do número quatro, em Privet Drive. Com a morada escrita a verde num sobrescrito em papel pergaminho amarelo com lacre a roxo, são rapidamente confiscadas pelos seus tios horríveis. Mas no dia do décimo primeiro aniversário de Harry, um gigante de olhos pretos e brilhantes chamado Rubeus Hagrid entra abruptamente com notícias surpreendentes: Harry Potter é um feiticeiro e tem um lugar à sua espera na escola de magia e feitiçaria de Hogwarts. Vai começar uma incrível aventura!', '1');

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
insert into genre (genre_id, genre_name) values('8', 'Fiction');
insert into genre (genre_id, genre_name) values('9', 'Historical Fiction');
insert into genre (genre_id, genre_name) values('10', 'History');
insert into genre (genre_id, genre_name) values('11', 'Nonfiction');
insert into genre (genre_id, genre_name) values('12', 'Young Adult');

insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('1', '1', '6');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('2', '1', '4');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('3', '1', '2');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('4', '2', '2');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('5', '2', '3');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('6', '3', '1');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('7', '4', '4');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('8', '4', '2');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('9', '4', '5');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('10', '5', '2');
insert into moviegenre (mg_id, mg_movie_id, mg_genre_id) values('11', '5', '3');

insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('1', '1', '7');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('2', '1', '2');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('3', '2', '8');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('4', '2', '2');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('5', '2', '3');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('6', '2', '12');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('7', '3', '9');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('8', '4', '10');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('9', '4', '11');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('10', '5', '3');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('11', '5', '8');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('12', '5', '12');
insert into bookgenre (bg_id, bg_book_id, bg_genre_id) values('13', '5', '2');

insert into author (author_id, author_name, author_bio) values('1','Hergé', 'Georges Prosper Remi (22 May 1907 – 3 March 1983), better known by the pen name Hergé, was a Belgian comics writer and artist. His best known and most substantial work is The Adventures of Tintin comic book series, which he wrote and illustrated from 1929 until his death in 1983, leaving the twenty-fourth Tintin adventure Tintin and Alph-Art unfinished. His work remains a strong influence on comics, particularly in Europe. He was inducted into the Comic Book Hall of Fame in 2003.');
insert into author (author_id, author_name, author_bio) values('2','J.K. Rowling', 'Although she writes under the pen name J.K. Rowling, pronounced like rolling, her name when her first Harry Potter book was published was simply Joanne Rowling. Anticipating that the target audience of young boys might not want to read a book written by a woman, her publishers demanded that she use two initials, rather than her full name. As she had no middle name, she chose K as the second initial of her pen name, from her paternal grandmother Kathleen Ada Bulgen Rowling. She calls herself Jo and has said, "No one ever called me "Joanne" when I was young, unless they were angry." Following her marriage, she has sometimes used the name Joanne Murray when conducting personal business. During the Leveson Inquiry she gave evidence under the name of Joanne Kathleen Rowling. In a 2012 interview, Rowling noted that she no longer cared that people pronounced her name incorrectly.');
insert into author (author_id, author_name, author_bio) values('3','Kathryn Stockett', 'Kathryn Stockett was born and raised in Jackson, Mississippi. After graduating from the University of Alabama with a degree in English and creative writing, she moved to New York City, where she worked in magazine publishing for nine years. She currently lives in Atlanta with her husband and daughter. She is working on her second novel.');
insert into author (author_id, author_name, author_bio) values('4', 'Nathaniel Philbrick', 'Philbrick was Brown’s first Intercollegiate All-American sailor in 1978; that year he won the Sunfish North Americans in Barrington, RI; today he and his wife Melissa sail their Beetle Cat Clio and their Tiffany Jane 34 Marie-J in the waters surrounding Nantucket Island. After grad school, Philbrick worked for four years at Sailing World magazine; was a freelancer for a number of years, during which time he wrote/edited several sailing books, including Yaahting: A Parody (1984), for which he was the editor-in-chief; during this time he was also the primary caregiver for his two children. After moving to Nantucket in 1986, he became interested in the history of the island and wrote Away Off Shore: Nantucket Island and Its People. He was offer ...more');

insert into bookauthor (ba_id, ba_book_id, ba_author_id) values('1', '1', '1');
insert into bookauthor (ba_id, ba_book_id, ba_author_id) values('2', '2', '2');
insert into bookauthor (ba_id, ba_book_id, ba_author_id) values('3', '3', '3');
insert into bookauthor (ba_id, ba_book_id, ba_author_id) values('4', '4', '4');
insert into bookauthor (ba_id, ba_book_id, ba_author_id) values('5', '5', '2');

insert into users(users_id, users_name, users_username, users_email, users_password) values('1', 'André Gomes', 'andre.gomes', 'andre.gomes@iade.pt', 'gomandre123');
insert into users(users_id, users_name, users_username, users_email, users_password) values('2', 'Catarina Silva', 'cat.silva', 'cat.silva@iade.pt', 'catarina456');
insert into users(users_id, users_name, users_username, users_email, users_password) values('3', 'Francisco Sousa', 'kiko.sousa', 'kiko.sousa@iade.pt', 'kikosousa789');
insert into users(users_id, users_name, users_username, users_email, users_password) values('4', 'Joana Carneiro', 'jo.carneiro', 'joana.carneiro@iade.pt', 'joana123');
insert into users(users_id, users_name, users_username, users_email, users_password) values('5', 'Hugo Andrade', 'hugo.andrade', 'hugo.andrade@iade.pt', 'hugo456');

insert into character(character_id, character_name) values('1', 'Harry Potter');
insert into character(character_id, character_name) values('2', 'Hermione Granger');
insert into character(character_id, character_name) values('3', 'Ronald Weasley');
insert into character(character_id, character_name) values('4', 'Tintim');
insert into character(character_id, character_name) values('5', 'Thomson and Thompson');
insert into character(character_id, character_name) values('6', 'Captain Haddock');
insert into character(character_id, character_name) values('7', 'Snowy');
insert into character(character_id, character_name) values('8', 'Skeeter Phelan');
insert into character(character_id, character_name) values('9', 'Aibileen Clark');
insert into character(character_id, character_name) values('10', 'Hilly Holbrook');
insert into character(character_id, character_name) values('11', 'Minny Jackson');
insert into character(character_id, character_name) values('12', 'Owen Chase');
insert into character(character_id, character_name) values('13', 'George Pollard');
insert into character(character_id, character_name) values('14', 'Matthew Joy');

insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('1','1','2');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('2','2','2');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('3','3','2');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('4','4','1');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('5','5','1');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('6','6','1');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('7','7','1');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('8','8','3');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('9','9','3');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('10','10','3');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('11','11','3');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('12','12','4');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('13','13','4');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('14','14','4');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('15','1','5');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('16','2','5');
insert into bookcharacter(bc_id, bc_character_id, bc_book_id) values('17','3','5');

insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('1','1','2');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('2','2','2');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('3','3','2');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('4','4','1');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('5','5','1');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('6','6','1');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('7','7','1');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('8','8','3');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('9','9','3');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('10','10','3');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('11','11','3');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('12','12','4');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('13','13','4');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('14','14','4');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('15','1','5');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('16','2','5');
insert into moviecharacter(mc_id, mc_character_id, mc_movie_id) values('17','3','5');