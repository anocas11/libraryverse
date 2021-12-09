create table users (
    users_id SERIAL not null,
    users_name VARCHAR(60) not null,
    users_username VARCHAR(30) not null,
    users_email VARCHAR(60) not null,
    users_password VARCHAR(60) not null,
    primary key (users_id)
);

create table author (
    author_id SERIAL not null, 
    author_name VARCHAR(60) not null, 
    author_bio VARCHAR(10000) not null, 
    primary key (author_id)
);

create table book (
    book_id SERIAL not null, 
    book_name VARCHAR(120) not null, 
    book_date date not null, 
    book_description VARCHAR(10000),
    book_cu_id integer,
    book_poster varchar(200),
    primary key(book_id)
);

create table genre (
    genre_id SERIAL not null,
    genre_name VARCHAR(20) not null,
    primary key (genre_id)
);

create table movie (
    movie_id SERIAL not null, 
    movie_name VARCHAR(120), 
    movie_date date not null, 
    movie_duration time not null, 
    movie_description VARCHAR(10000) not null, 
    movie_cu_id integer,
    movie_poster varchar(200),
    primary key (movie_id)
);

create table actor (
    actor_id SERIAL not null, 
    actor_name VARCHAR(60), 
    actor_birthday date not null,
    actor_deathday date, 
    actor_bio VARCHAR(10000), 
    primary key(actor_id)
);

create table question (
    question_id SERIAL not null, 
    question_text VARCHAR(300) not null,
    question_book_id integer not null,
    question_movie_id integer not null, 
    primary key(question_id)
);

create table answer (
    answer_id SERIAL not null, 
    answer_text VARCHAR(300), 
    answer_iswrong boolean,
    answer_question_id integer,
    primary key(answer_id)
);

create table cinematicUniverse (
    cu_id SERIAL not null, 
    cu_name VARCHAR(30) not null, 
    primary key (cu_id)
);

create table bookAuthor (
    ba_id SERIAL not null, 
    ba_book_id integer not null, 
    ba_author_id integer not null, 
    primary key (ba_id)
);

create table userBooks (
    ub_id SERIAL not null, 
    ub_user_id integer not null, 
    ub_book_id integer not null, 
    ub_favorite boolean, 
    ub_read boolean, 
    ub_reading boolean, 
    ub_has boolean, 
    primary key (ub_id)
);

create table userMovies (
    um_id SERIAL not null, 
    um_user_id integer not null, 
    um_movie_id integer not null, 
    um_favorite boolean, 
    um_watched boolean, 
    um_has boolean, 
    primary key (um_id)
);

create table character ( 
    character_id SERIAL not null, 
    character_name VARCHAR(60) not null, 
    primary key (character_id)
);

create table bookcharacter ( 
    bc_id SERIAL not null, 
    bc_character_id int not null, 
    bc_book_id int not null, 
    primary key (bc_id)
);

create table moviecharacter ( 
    mc_id SERIAL not null, 
    mc_character_id int not null, 
    mc_movie_id int not null, 
    primary key (mc_id)
);

create table movieActor (
    ma_id SERIAL not null, 
    ma_mc_id integer not null, 
    ma_actor_id integer not null, 
    primary key (ma_id)
);

create table venue (
    venue_id SERIAL not null, 
    venue_address varchar(200) not null, 
    venue_city varchar(100) not null, 
    venue_country varchar(100) not null, 
    primary key(venue_id)
);

create table movievenue (
    mv_id SERIAL not null, 
    mv_venue_id integer not null, 
    mv_mc_id integer not null, 
    primary key (mv_id)
);

create table moviegenre(
    mg_id SERIAL not null, 
    mg_movie_id int not null, 
    mg_genre_id int not null, 
    primary key(mg_id)
);

create table bookgenre(
    bg_id SERIAL not null, 
    bg_book_id int not null, 
    bg_genre_id int not null, 
    primary key(bg_id)
);

-- Foreign Keys

alter table movie 
add constraint movie_fk_cinematicUniverse
foreign key (movie_cu_id) references cinematicUniverse(cu_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table book 
add constraint book_fk_cinematicUniverse
foreign key (book_cu_id) references cinematicUniverse(cu_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table bookAuthor 
add constraint bookAuthor_fk_book
foreign key (ba_book_id) references book(book_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table bookAuthor 
add constraint bookAuthor_fk_author
foreign key (ba_author_id) references author(author_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table userBooks 
add constraint userBooks_fk_user
foreign key (ub_user_id) references users(users_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table userBooks 
add constraint userBooks_fk_book
foreign key (ub_book_id) references book(book_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table userMovies 
add constraint userMovies_fk_user
foreign key (um_user_id) references users(users_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table userMovies 
add constraint userMovies_fk_movie
foreign key (um_movie_id) references movie(movie_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table bookcharacter
add constraint bookcharacter_fk_book
foreign key (bc_book_id) references book(book_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table bookcharacter
add constraint bookcharacter_fk_character
foreign key (bc_character_id) references character(character_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table moviecharacter
add constraint moviecharacter_fk_movie
foreign key (mc_movie_id) references movie(movie_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table moviecharacter
add constraint moviecharacter_fk_character
foreign key (mc_character_id) references character(character_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table movieActor 
add constraint movieActor_fk_moviecharacter
foreign key (ma_mc_id) references moviecharacter(mc_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table movieActor 
add constraint movieActor_fk_actor
foreign key (ma_actor_id) references actor(actor_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table movievenue 
add constraint movievenue_fk_moviecharacter
foreign key (mv_mc_id) references moviecharacter(mc_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table movievenue 
add constraint movievenue_fk_venue
foreign key (mv_venue_id) references venue(venue_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table question 
add constraint question_fk_book
foreign key (question_book_id) references book(book_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table question 
add constraint question_fk_movie
foreign key (question_movie_id) references movie(movie_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table answer 
add constraint answer_fk_question
foreign key (answer_question_id) references question(question_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table moviegenre
add constraint moviegenre_fk_movie
foreign key (mg_movie_id) references movie(movie_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table moviegenre
add constraint moviegenre_fk_genre
foreign key (mg_genre_id) references genre(genre_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table bookgenre
add constraint bookgenre_fk_book
foreign key (bg_book_id) references book(book_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table bookgenre
add constraint bookgenre_fk_genre
foreign key (bg_genre_id) references genre(genre_id)
ON DELETE NO ACTION ON UPDATE NO ACTION;