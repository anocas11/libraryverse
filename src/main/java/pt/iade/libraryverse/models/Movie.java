package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pt.iade.libraryverse.models.CinematicUniverse;
import pt.iade.libraryverse.models.Genre;

@Entity
@Table(name="movie")
public class Movie 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="movie_id") private int id;
    @Column(name="movie_name") private String name;
    @Column(name="movie_date") private String date;
    @Column(name="movie_duration") private int duration;
    @Column(name="movie_description") private String description;
    @Column(name="movie_genre_id") private Genre genre;
    @Column(name="movie_cu_id") private CinematicUniverse cu;

    public Movie()
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
