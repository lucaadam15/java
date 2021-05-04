package mg.ingenosya.testeJava.controleur;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mg.ingenosya.testeJava.Repository.UtilisateurRepositiry;
import mg.ingenosya.testeJava.Repository.VoitureRepository;
import mg.ingenosya.testeJava.classe.Utilisateur;
import mg.ingenosya.testeJava.classe.Voiture;

@Controller
@RequestMapping(value="/")
public class MainControleur {
	@Autowired
	VoitureRepository voitureRepository;
	@Autowired
	UtilisateurRepositiry utilisateurRepositiry;
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public String accueil(Model model) {
		List<Voiture> voitures = (List<Voiture>) voitureRepository.findAll();
		System.out.println("-----------------");
		System.out.println(getUserLoged());
		model.addAttribute("pseudo", "");
		model.addAttribute("voitures", voitures);
		return "index";
	}
	@RequestMapping(value="inscription", method = RequestMethod.GET)
	public String connexion(Model model) {
		return "/utilisateurs/inscription";
	}
	private Utilisateur getUserLoged(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Optional<Utilisateur> utilisateur = utilisateurRepositiry.findById(authentication.getName());
		if(utilisateur.isPresent()) {
			return utilisateur.get();
		}
		return null;
	}
}
