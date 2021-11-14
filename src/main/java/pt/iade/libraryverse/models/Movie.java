package main.java.pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="movie_id") private int id;
    @Column(name="movie_name") private int name;
    @Column(name="movie_date") private int date;
    @Column(name="movie_duration") private int duration;
    @Column(name="movie_description") private int description;

    public Movie()
    {

    }

    
}
