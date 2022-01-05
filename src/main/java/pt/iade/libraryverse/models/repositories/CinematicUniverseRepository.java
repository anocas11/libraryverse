package pt.iade.libraryverse.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.libraryverse.models.CinematicUniverse;

public interface CinematicUniverseRepository extends CrudRepository<CinematicUniverse,Integer>{
    //Criamos a interface que extende CrudRepository que contem todas as funções crud do springboot
    //Os parâmetros significam que o repositório vai gerir os universos e o id dos universos é um int 

}
