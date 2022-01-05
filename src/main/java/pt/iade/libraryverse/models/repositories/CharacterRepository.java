package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.Character;

public interface CharacterRepository extends CrudRepository<Character,Integer>{
    //Criamos a interface que extende CrudRepository que contem todas as funções crud do springboot
    //Os parâmetros significam que o repositório vai gerir os personagens e o id dos personagens é um int 

}
