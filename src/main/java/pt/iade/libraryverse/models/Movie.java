package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

import pt.iade.libraryverse.models.CinematicUniverse;
import pt.iade.libraryverse.models.Genre;
import pt.iade.libraryverse.models.Actor;
import pt.iade.libraryverse.models.Character;

@Entity //marca a classe para ser uma entidade de dados
@Table(name="movie") //porque o nome da classe não é igual ao nome da tabela
public class Movie 
{
    @Id //identica a chave da tabela
    @GeneratedValue(strategy=GenerationType.IDENTITY) //util para quando se guardam novos filmes, porque o id é gerado pela bd
    @Column(name="movie_id") private int id; //ligar o nome do atributo ao nome da coluna
    @Column(name="movie_name") private String name;
    @Column(name="movie_date") private String date;
    @Column(name="movie_duration") private String duration;
    @Column(name="movie_description") private String description;
    @Column(name="movie_poster") private String poster;
    @OneToOne @JoinColumn(name="movie_cu_id") private CinematicUniverse cinematicUniverse;
    //@OneToMany @JoinColumn(name="mg_genre_id") private Genre genre;
    //@OneToMany @JoinColumn(name="mc_character_id") private Character character;
    //@OneToMany @JoinColumn(name="ma_actor_id") private Actor actor;

    public Movie() //construtor default sem argumentos
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public CinematicUniverse getCinematicUniverse() {
        return cinematicUniverse;
    }

    public void setCinematicUniverse(CinematicUniverse cinematicUniverse) {
        this.cinematicUniverse = cinematicUniverse;
    }
    
}
