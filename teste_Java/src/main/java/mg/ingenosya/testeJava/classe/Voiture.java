package mg.ingenosya.testeJava.classe;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Voiture {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdVoiture;
	private String marque;
	private String modele;
	private String couleur;
	
	@OneToMany(mappedBy = "voiture", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Commentaire> commentaires;
	
	public Voiture() { super(); }
	public Voiture(String marque, String modele, String couleur) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.couleur = couleur;
	}
	public long getIdVoiture() {
		return IdVoiture;
	}
	public void setIdVoiture(long idVoiture) {
		IdVoiture = idVoiture;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	

}
