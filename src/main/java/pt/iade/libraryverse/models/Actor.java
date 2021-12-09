package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor 
{
    @Id
    @GeneratedValue(strategy=GenertionType.IDENTITY)
    @Column(name="actor_id") private int id;
    @Column(name="actor_name") private String name;    
    @Column(name="actor_birthday") private String birthday;
    @Column(name="actor_bio") private String bio;

    public Actor()
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    
}
