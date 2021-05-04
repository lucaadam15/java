package mg.ingenosya.testeJava.controleur;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mg.ingenosya.testeJava.Repository.UtilisateurRepositiry;
import mg.ingenosya.testeJava.Repository.VoitureRepository;
import mg.ingenosya.testeJava.classe.Utilisateur;
import mg.ingenosya.testeJava.classe.Voiture;

@Controller
@RequestMapping(value="utilisateur")
public class UtilisateurControleur {
	@Autowired
	UtilisateurRepositiry utilisateurRepositiry;
	@Autowired
	VoitureRepository voitureRepository;
	@RequestMapping(value="connection")
	public String connecter(String pseudo, String mdp){
		return "utilisateurs/connexion";
	}
	
	@RequestMapping(value="sinscrir")
	public String inscription(Utilisateur utilisateur, String mdp1) {
		
		utilisateurRepositiry.save(utilisateur);
		return "redirect:/utilisateur/connection";
	}
	
}
