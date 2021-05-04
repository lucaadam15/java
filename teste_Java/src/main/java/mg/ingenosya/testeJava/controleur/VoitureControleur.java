package mg.ingenosya.testeJava.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mg.ingenosya.testeJava.Repository.CommentaireRepository;
import mg.ingenosya.testeJava.Repository.VoitureRepository;
import mg.ingenosya.testeJava.classe.Commentaire;
import mg.ingenosya.testeJava.classe.Voiture;

@Controller
@RequestMapping(value="voiture")
public class VoitureControleur {
	@Autowired
	VoitureRepository voitureRepository;
	@Autowired
	CommentaireRepository commentaireRepository;
	
	@RequestMapping(value="consulter")
	public String consulter(Model model, @RequestParam(name="id",defaultValue = "1") long id){
		model.addAttribute("id", id);
		Voiture voiture = null;
		Optional<Voiture> v = voitureRepository.findById(id);
		if(v.isPresent()) {
			voiture=v.get();
		}
		model.addAttribute("voiture", voiture);
		List<Commentaire> commentaires = commentaireRepository.listeCommentaire(voiture.getIdVoiture());
		model.addAttribute("commentaires", commentaires);
		model.addAttribute("voitures", (List<Voiture>) voitureRepository.findAll());
		return  "/voiture/detail";
	}
	
	@RequestMapping(value="save")
	public String ajouter(Model model){
		
		
		return  "index";
	}
	
	@RequestMapping(value="delete")
	public List<Voiture> supprime(int idvoiture){
		voitureRepository.deleteById((long) idvoiture);
		return  (List<Voiture>) voitureRepository.findAll();
	}
}
