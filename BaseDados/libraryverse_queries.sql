select book_name
from book 
inner join bookauthor on book_id = ba_book_id
where ba_author_id = id;

select book_name, book_date, book_description, book_poster, cu_name, genre_name 
from book
left join cinematicuniverse on book_cu_id = cu_id
inner join bookGenre on bg_book_id = book_id
inner join genre on bg_genre_id = genre_id
where book_id = id;

select author_name from author
inner join bookauthor on author_id = ba_author_id
where ba_book_id = id;

select character_name
from character
inner join bookcharacter on character_id = bc_character_id
where bc_book_id = id;

select genre_name from genre
inner join moviegenre on genre_id = mg_genre_id
inner join movie on mg_movie_id = movie_id
where movie_id = id;

select genre_name genreName from genre
inner join bookgenre on genre_id = bg_genre_id
inner join book on bg_book_id = book_id
where book_id = id;

select movie_name, movie_duration, movie_date, movie_description, cu_name, genre_name, movie_poster
from movie
left join cinematicuniverse on movie_cu_id = cu_id
inner join movieGenre on mg_movie_id = movie_id
inner join genre on mg_genre_id = genre_id
where movie_id = id;

select character_name
from character
inner join moviecharacter on character_id = mc_character_id
where mc_movie_id = id;

select actor_name from actor
inner join movieactor on actor_id = ma_actor_id
inner join moviecharacter on ma_mc_id = mc_id
where mc_movie_id = id;

select movie_name from movie
inner join moviecharacter on movie_id = mc_movie_id
inner join movieactor on mc_id = ma_mc_id
where ma_actor_id = id;