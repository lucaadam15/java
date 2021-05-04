package mg.ingenosya.testeJava.controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mg.ingenosya.testeJava.Repository.CommentaireRepository;
import mg.ingenosya.testeJava.Repository.UtilisateurRepositiry;
import mg.ingenosya.testeJava.Repository.VoitureRepository;
import mg.ingenosya.testeJava.classe.Commentaire;
import mg.ingenosya.testeJava.classe.Utilisateur;
import mg.ingenosya.testeJava.classe.Voiture;

@Controller
@RequestMapping(value="commentaire")
public class CommentaireControleur {
	@Autowired
	CommentaireRepository commentaireRepository;
	@Autowired
	UtilisateurRepositiry utilisateurRepositiry;
	@Autowired
	VoitureRepository voitureRepository;
	
	@RequestMapping(value="")
	public List<Commentaire> listeCommentaire(@RequestParam(name="voiture", defaultValue = "1") int id){
		List<Commentaire> commentaires=new ArrayList<Commentaire>();
		commentaireRepository.findAll().forEach(e ->{
			if(e.getVoiture().getIdVoiture() == id) {
				commentaires.add(e);
			}
		});
		return commentaires;
	}
	@RequestMapping(value="ajouter",method = RequestMethod.POST)
	public String ajouter(Model model, String voitur, String coment){
		//Optional<Utilisateur> u = utilisateurRepositiry.findById(pseudo);
		Optional<Voiture> v = voitureRepository.findById(Long.parseLong(voitur));
		Commentaire commentaire= new Commentaire(coment);
		/*
		 * if(u.isPresent()) { c.setUtilisateur(u.get()); }
		 */
		if(v.isPresent()) {
			commentaire.setVoiture(v.get());
		}
		commentaireRepository.save(commentaire);
		List<Commentaire> commentaires=commentaireRepository.listeCommentaire(Long.parseLong(voitur));
		model.addAttribute("commentaires", commentaires);
		return "redirect:/voiture/consulter?id="+voitur;
	}
}
