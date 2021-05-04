package mg.ingenosya.testeJava.Repository;

import org.springframework.data.repository.CrudRepository;

import mg.ingenosya.testeJava.classe.Utilisateur;

public interface UtilisateurRepositiry extends CrudRepository<Utilisateur, String> {

}
