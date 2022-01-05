package pt.iade.libraryverse.models;

import java.lang.annotation.Inherited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //marca a classe para ser uma entidade de dados
@Table(name="cinematicuniverse") //porque o nome da classe não é igual ao nome da tabela
public class CinematicUniverse 
{
    @Id //identica a chave da tabela
    @GeneratedValue(strategy=GenerationType.IDENTITY)  //util para quando se guardam novos universos, porque o id é gerado pela bd
    @Column(name="cu_id") private int id; //ligar o nome do atributo ao nome da coluna
    @Column(name="cu_name") private String name;
    
    public CinematicUniverse() //construtor default sem argumentos
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
