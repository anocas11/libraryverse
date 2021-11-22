package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cinematicuniverse")
public class CinematicUniverse 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name="cu_id") private int id;
    @Column(name="cu_name") private int name;
    
    public CinematicUniverse()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
