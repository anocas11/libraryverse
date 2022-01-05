package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //marca a classe para ser uma entidade de dados
@Table(name="character") //porque o nome da classe não é igual ao nome da tabela
public class Character {
    @Id //identica a chave da tabela
    @GeneratedValue(strategy=GenerationType.IDENTITY) //util para quando se guardam novos livros, porque o id é gerado pela bd
    @Column(name="character_id") private int id; //ligar o nome do atributo ao nome da coluna
    @Column(name="character_name") private String name;

    public Character() //construtor default sem argumentos
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

    
}
