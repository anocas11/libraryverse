
insert into book (book_id, book_name, book_date, book_description, book_cu_id) values('1','Tintim na América' , to_date('1931', 'YYYY'), 'Depois de enfrentar um bando de gângsters no Congo, Tintim é enviado para Chicago, EUA, para livrar a cidade dos criminosos. ... Assim que escapa dos comparsas de Al Capone, Tintim cai numa armadilha de Bobby Smiles, líder do Sindicato dos Gângsters de Chicago', '2');
insert into book (book_id, book_name, book_date, book_description, book_cu_id) values('2', 'Harry Potter e a camera dos segredos', to_date('1998', 'YYYY'), 'Após as sofríveis férias na casa dos tios, Harry Potter se prepara para voltar a Hogwarts e começar seu segundo ano na escola de bruxos. Na véspera do início das aulas, a estranha criatura Dobby aparece em seu quarto e o avisa de que voltar é um erro e que algo muito ruim pode acontecer se Harry insistir em continuar os estudos de bruxaria. O garoto, no entanto, está disposto a correr o risco e se livrar do lar problemático.', '1');
insert into book (book_id, book_name, book_date, book_description) values('3', 'As serviçais', to_date('2009', 'YYYY'), 'Nos anos 60, no Mississippi, Skeeter é uma garota da alta sociedade que retorna determinada a se tornar escritora. Ela começa a entrevistar as mulheres negras da cidade, que deixaram suas vidas para trabalhar na criação dos filhos da elite branca, da qual a própria Skeeter faz parte. Aibileen Clark, a emprega da melhor amiga de Skeeter, é a primeira a conceder uma entrevista. Apesar das críticas, Skeeter e Aibileen continuam trabalhando juntas e, aos poucos, conseguem novas adesões.');
insert into book (book_id, book_name, book_date, book_description) values('4', 'No coração do mar', to_date('2000', 'YYYY'), 'No Coração do Mar é um livro do historiador americano Nathaniel Philbrick, no qual ele narra em detalhes a tragédia do navio baleeiro Essex que, em 1820, perseguiu uma baleia Cachalote no Pacífico, vindo a afundar.' );
insert into book (book_id, book_name, book_date, book_description, book_cu_id) values('5', 'Harry Potter e a Pedra Filosofal', to_date('1995', 'YYYY'), '«Voltando o sobrescrito ao contrário, com as mãos a tremer, Harry viu um selo de lacre cor de púrpura com um brasão onde podia distinguir-se um leão, uma águia, um texugo e uma serpente envolvendo a letra H.» Harry Potter nunca tinha ouvido falar de Hogwarts quando as cartas começaram a cair na entrada do número quatro, em Privet Drive. Com a morada escrita a verde num sobrescrito em papel pergaminho amarelo com lacre a roxo, são rapidamente confiscadas pelos seus tios horríveis. Mas no dia do décimo primeiro aniversário de Harry, um gigante de olhos pretos e brilhantes chamado Rubeus Hagrid entra abruptamente com notícias surpreendentes: Harry Potter é um feiticeiro e tem um lugar à sua espera na escola de magia e feitiçaria de Hogwarts. Vai começar uma incrível aventura!', '1');

insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description, movie_cu_id) values ('1', 'As Aventuras de TinTim - O Segredo do Licorne', to_date('2011-10-24', 'YYYY-MM-DD'), '01:47:00', 'A aventura começa assim que Tintim compra a miniatura de um barco. Sem saber o segredo do objeto, ele e seu cachorro são sequestrados. Presos em um barco, conseguem escapar junto com o capitão e, aos poucos, vão decifrando todos os mistérios.', '2');
insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description, movie_cu_id) values ('2', 'Harry Potter e a Câmara dos Segredos',  to_date('2002-11-13', 'YYYY-MM-DD'), '02:41:00', 'Após as sofríveis férias na casa dos tios, Harry Potter se prepara para voltar a Hogwarts e começar seu segundo ano na escola de bruxos. Na véspera do início das aulas, a estranha criatura Dobby aparece em seu quarto e o avisa de que voltar é um erro e que algo muito ruim pode acontecer.', '1');
insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description) values ('3', 'As Serviçais', to_date('2011-10-8', 'YYYY-MM-DD'), '02:26:00', 'Nos anos 60, no Mississippi, Skeeter é uma garota da alta sociedade que retorna determinada a se tornar escritora. Ela começa a entrevistar as mulheres negras da cidade, que deixaram suas vidas para trabalhar na criação dos filhos da elite branca, da qual a própria Skeeter faz parte. ');    
insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description) values ('4', 'No coração do mar', to_date('2015-11-12', 'YYYY-MM-DD'), '02:02:00', 'A tripulação do barco baleeiro Essex precisa fazer o impossível para sobreviver em uma ilha deserta após sofrer brutal ataque de uma baleia gigantesca.');  
insert into movie (movie_id, movie_name, movie_date, movie_duration, movie_description, movie_cu_id, movie_poster) values ('5', 'Harry Potter e a Pedra Filosofal',  to_date('2001-11-16', 'YYYY-MM-DD'), '02:32:00', 'Após as sofríveis férias na casa dos tios, Harry Potter se prepara para voltar a Hogwarts e começar seu segundo ano na escola de bruxos. Na véspera do início das aulas, a estranha criatura Dobby aparece em seu quarto e o avisa de que voltar é um erro e que algo muito ruim pode acontecer.', '1', 'https://m.media-amazon.com/images/M/MV5BNjQ3NWNlNmQtMTE5ZS00MDdmLTlkZjUtZTBlM2UxMGFiMTU3XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_FMjpg_UX510_.jpg');

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

insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('1', 'Daniel Radcliffe', to_date('1989-07-23', 'YYYY-MM-DD'), 'Daniel Jacob Radcliffe (born 23 July 1989) is an English actor who rose to prominence playing the titular character in the Harry Potter film series. His work on the series has earned him several awards and more than £60 million. Radcliffe made his acting debut at age ten in BBC Ones television movie David Copperfield (1999), followed by his film debut in 2001s The Tailor of Panama. Cast as Harry at the age of eleven, Radcliffe has starred in seven Harry Potter films since 2001, with the final installment releasing in July 2011. In 2007 Radcliffe began to branch out from the series, starring in the London and New York productions of the play Equus, and the 2011 Broadway revival of the musical How to Succeed in Business Without Really Trying. The Woman in Black (2012) will be his first film project following the final Harry Potter movie. Radcliffe has contributed to many charities, including Demelza House Childrens Hospice and The Trevor Project. He has also made public service announcements for the latter. In 2011 the actor was awarded the Trevor Projects "Hero Award".');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('2', 'Rupert Grint', to_date('1988-08-24', 'YYYY-MM-DD'), 'Rupert Grint is an English actor, who rose to prominence playing Ron Weasley, one of the three main characters in the Harry Potter film series. Grint was cast as Ron at the age of 11, having previously acted only in school plays and at his local theatre group. From 2001 to 2010, he starred in eight Harry Potter movies alongside Daniel Radcliffe and Emma Watson. Beginning in 2002, Grint began to work outside of the Harry Potter franchise, taking on a co-leading role in Thunderpants. He has had starring roles in Driving Lessons, a dramedy released in 2006, and Cherrybomb, a small budgeted drama released in 2010. Grint co-starred with Bill Nighy and Emily Blunt in Wild Target, a comedy. His first project following the end of the Harry Potter series will be Comrade, a 2012 anti-war release in which he stars as the main role.');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('3', 'Emma Watson', to_date('1990-04-15', 'YYYY-MM-DD'), 'Emma Watson (born 15 April 1990) is an English actress who rose to prominence playing Hermione Granger, one of three starring roles in the Harry Potter film series. Watson was cast as Hermione at the age of nine, having previously acted only in school plays. From 2001 to 2011, she starred in eight Harry Potter films alongside Daniel Radcliffe and Rupert Grint. Watsons work on the Harry Potter series has earned her several awards and more than £10 million. She made her modelling debut for Burberrys Autumn/Winter campaign in 2009. In 2007, Watson announced her involvement in two non-Harry Potter productions: the television adaptation of the novel Ballet Shoes and an animated film, The Tale of Despereaux. Ballet Shoes was broadcast on 26 December 2007 to an audience of 5.2 million, and The Tale of Despereaux, based on the novel by Kate DiCamillo, was released in 2008 and grossed over US $70 million in worldwide sales. In 2012, she starred in Stephen Chbosks film adaptation of The Perks of Being a Wallflower, and was cast in the role of Ila in Darren Aronofskys biblical epic Noah.');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('4', 'Emma Stone', to_date('1988-11-06', 'YYYY-MM-DD'), 'Emily Jean "Emma" Stone is an American actress. The recipient of numerous accolades, including an Academy Award and a Golden Globe Award, she was the worlds highest-paid actress in 2017. Born and raised in Scottsdale, Arizona, Stone began acting as a child, in a theater production of The Wind in the Willows in 2000. As a teenager, she relocated to Los Angeles with her mother and made her television debut in In Search of the New Partridge Family (2004), a reality show that produced only an unsold pilot. After small television roles, she made her film debut in Superbad (2007), and received positive media attention for her role in Zombieland (2009). The 2010 teen comedy Easy A was Stones first starring role, earning her nominations for the BAFTA Rising Star Award and a Golden Globe Award for Best Actress. Stone gained wider recognition as Gwen Stacy in the 2012 superhero film The Amazing Spider-Man, and its 2014 sequel. She was nominated for the Academy Award for Best Supporting Actress for playing a recovering drug addict in the black comedy Birdman (2014), and her Broadway debut came in a revival of the musical Cabaret (2014–2015). She won the Academy Award for Best Actress for playing an aspiring actress in the romantic musical La La Land (2016). Stone received a third Academy Award nomination for her portrayal of Abigail Masham in the historical comedy-drama The Favourite (2018).');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('5', 'Viola Davis', to_date('1965-08-11', 'YYYY-MM-DD'), 'Viola Davis (born August 11, 1965) is an American actress. Known primarily as a stage actress, Davis won a Tony Award for Best Performance by a Featured Actress in a Play and a Drama Desk Award for her role in King Hedley II (2001). She won a Tony Award for Best Performance by a Leading Actress in a Play for her role in Fences. She won a second Drama Desk Award for Intimate Apparel (2004). Her films include Traffic (2000), Antwone Fisher (2002), and Solaris (2002). Her performance in Doubt (2008) was nominated for several awards, including an Academy Award for Best Supporting Actress and a Golden Globe Award for Best Supporting Actress in a Motion Picture.');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('6', 'Octavia Spencer', to_date('1972-05-25', 'YYYY-MM-DD'), 'Octavia Lenora Spencer is an American actress, author, and producer. She is the recipient of several accolades, including an Academy Award, a British Academy Film Award, a Golden Globe Award, and three Screen Actors Guild Awards. She is one of two black actresses to have received three Academy Award nominations, the first black actress to receive two consecutive Academy Award nominations in back-to-back years, and the first black actress to receive an Academy Award nomination after previously winning.');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('7', 'Bryce Dallas Howard', to_date('1981-03-02', 'YYYY-MM-DD'), 'Bryce Dallas Howard (born March 2, 1981) is an American actress and director. She is the eldest daughter of actor and filmmaker Ron Howard and landed her first major film role in the 2004 M. Night Shyamalan feature The Village (2004). She received a Golden Globe Award nomination for her performance in the TV movie As You Like It. She also stars as Claire Dearing in the 2015 blockbuster Jurassic World.');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('8', 'Chris Hemsworth', to_date('1983-08-11', 'YYYY-MM-DD'), 'Chris Hemsworth (born 11 August 1983) is an Australian actor. He is best known for his roles as Kim Hyde in the Australian TV series Home and Away (2004) and as Thor in the Marvel Cinematic Universe films Thor (2011), The Avengers (2012), Thor: The Dark World (2013), Avengers: Age of Ultron (2015), Thor: Ragnarok (2017), Avengers: Infinity War (2018), Avengers: Endgame (2019), and the upcoming Thor: Love and Thunder (2022). He has also appeared in the science fiction action film Star Trek(2009), the thriller adventure A Perfect Getaway (2009), the horror comedy The Cabin in the Woods (2012), the dark fantasy action film Snow White and the Huntsman (2012), the war film Red Dawn (2012) and the biographical sports drama film Rush (2013).');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('9', 'Benjamin Walker', to_date('1982-06-21', 'YYYY-MM-DD'), 'Benjamin Walker (born 1982) is an American actor, best known for his film appearances in Kinsey (as Alfred Kinsey at age 19), Harlon Block in Clint Eastwoods Flags of Our Fathers, and his critically acclaimed portrayal of Andrew Jackson in the Off- and On Broadway incarnations of Bloody Bloody Andrew Jackson.');
insert into actor(actor_id, actor_name, actor_birthday, actor_bio) values('10', 'Cilian Murphy', to_date('1976-05-25', 'YYYY-MM-DD'), 'Cillian Murphy is an Irish film and theatre actor. He is often noted by critics for his chameleonic performances in diverse roles and distinctive blue eyes. A native of Cork, Murphy began his performing career as a rock musician. After turning down a record deal, he made his professional acting debut in the play Disco Pigs in 1996. He went on to star in Irish and UK film and stage productions throughout the late 1990s and early 2000s, first coming to international attention in 2003 as the hero in the post-apocalyptic film 28 Days Later. Murphy is best known for his work with director Christopher Nolan, where he appeared as the villain Jonathan Crane/Scarecrow in all three films in the Dark Knight trilogy. Murphy has also worked with Nolan on Inception and Dunkirk. In 2013, Murphy started working on a TV show for BBC titled “Peaky Blinders” as the show’s lead role, Thomas Shelby. The show is still airing as of 2020 with five highly critically acclaimed seasons under its belt. A resident of London since 2001, Murphy often works in or near the city and has expressed no desire to move to Hollywood. Uncomfortable on the celebrity circuit, he customarily gives interviews about his work, but does not appear on television talk shows or discuss details of his private life with the press.');