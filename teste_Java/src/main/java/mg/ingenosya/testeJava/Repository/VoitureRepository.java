package mg.ingenosya.testeJava.Repository;

import org.springframework.data.repository.CrudRepository;

import mg.ingenosya.testeJava.classe.Voiture;

public interface VoitureRepository extends CrudRepository<Voiture, Long> {

}
