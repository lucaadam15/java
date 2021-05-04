package mg.ingenosya.testeJava.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mg.ingenosya.testeJava.classe.Commentaire;

public interface CommentaireRepository extends CrudRepository<Commentaire, Long> {
	@Query("select c from Commentaire c where c.voiture.IdVoiture=:i")
	public List<Commentaire> listeCommentaire(@Param("i") Long id);
}
