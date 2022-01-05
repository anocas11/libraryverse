package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //marca a classe para ser uma entidade de dados
@Table(name="usermovies") //porque o nome da classe não é igual ao nome da tabela
public class UserMovies 
{
    @Id //identica a chave da tabela
    @GeneratedValue(strategy=GenerationType.IDENTITY) //util para quando se guardam novos filmes, porque o id é gerado pela bd
    @Column(name="um_id") private int id; //ligar o nome do atributo ao nome da coluna
    @Column(name="um_user_id") private int userId;
    @Column(name="um_movie_id") private int movieId;
    @Column(name="um_favorite") private boolean favorite;
    @Column(name="um_watched") private boolean watched; 
    @Column(name="um_has") private boolean has;

    public UserMovies() //construtor default sem argumentos
    {
        
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
    public boolean isWatched() {
        return watched;
    }
    public void setWatched(boolean watched) {
        this.watched = watched;
    }
    public boolean isHas() {
        return has;
    }
    public void setHas(boolean has) {
        this.has = has;
    }

    
}
