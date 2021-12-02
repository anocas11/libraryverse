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

@Entity
@Table(name="movie")
public class Movie 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="movie_id") private int id;
    @Column(name="movie_name") private String name;
    @Column(name="movie_date") private String date;
    @Column(name="movie_duration") private String duration;
    @Column(name="movie_description") private String description;
    @OneToOne @JoinColumn(name="movie_cu_id") private CinematicUniverse cinematicUniverse;

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

    
    
}
