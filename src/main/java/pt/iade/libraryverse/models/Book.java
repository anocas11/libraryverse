package pt.iade.libraryverse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //marca a classe para ser uma entidade de dados
@Table(name="book") //porque o nome da classe não é igual ao nome da tabela
public class Book 
{
    @Id //identica a chave da tabela
    @GeneratedValue(strategy=GenerationType.IDENTITY) //util para quando se guardam novos livros, porque o id é gerado pela bd
    @Column(name="book_id") private int id; //ligar o nome do atributo ao nome da coluna
    @Column(name="book_name") private String name;
    @Column(name="book_date") private String date;
    @Column(name="book_description") private String description;
    @Column(name="book_poster") private String poster;
    @OneToOne @JoinColumn(name="book_cu_id") private CinematicUniverse cinematicUniverse;

    public Book() //construtor default sem argumentos
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
