package mg.ingenosya.testeJava.classe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Commentaire {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long IdCom;
	private String commentair;
	@ManyToOne
	@XmlTransient
	@JoinColumn(name="voiture")
	private Voiture voiture;
	@ManyToOne
	@XmlTransient
	@JoinColumn(name="utilisateur")
	private Utilisateur utilisateur;
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commentaire(String commentair) {
		super();
		this.commentair = commentair;
	}
	public long getIdCom() {
		return IdCom;
	}
	public void setIdCom(long idCom) {
		IdCom = idCom;
	}
	public String getCommentair() {
		return commentair;
	}
	public void setCommentair(String commentair) {
		this.commentair = commentair;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
