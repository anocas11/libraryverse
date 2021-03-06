package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //marca a classe para ser uma entidade de dados
@Table(name="actor") //porque o nome da classe não é igual ao nome da tabela
public class Actor 
{
    @Id //identica a chave da tabela
    @GeneratedValue(strategy=GenerationType.IDENTITY) //util para quando se guardam novos atores, porque o id é gerado pela bd
    @Column(name="actor_id") private int id; //ligar o nome do atributo ao nome da coluna
    @Column(name="actor_name") private String name;    
    @Column(name="actor_birthday") private String birthday;
    @Column(name="actor_bio") private String description;
    @Column(name="actor_poster") private String poster;

    public Actor() //construtor default sem argumentos
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

    
    
}
