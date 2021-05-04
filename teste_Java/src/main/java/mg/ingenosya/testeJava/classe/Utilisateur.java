package mg.ingenosya.testeJava.classe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="users")
public class Utilisateur {
	@Id
	private String username;
	private String password;
	@OneToMany(mappedBy = "utilisateur", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Commentaire> commentaires;
	private Boolean enabled;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",
	joinColumns = {
			@JoinColumn(name = "username"
					)},
	inverseJoinColumns = {
			@JoinColumn(name = "role"
					)})
	private Set<Role> roles=new HashSet<>();
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Boolean getActive() {
		return enabled;
	}
	public void setActive(Boolean active) {
		this.enabled = active;
	}
	public Utilisateur(String pseudo, String mdp) {
		super();
		this.username = pseudo;
		this.password = mdp;
		this.enabled=true;
	}
	public String getPseudo() {
		return username;
	}
	public void setPseudo(String pseudo) {
		this.username = pseudo;
	}
	public String getMdp() {
		return password;
	}
	public void setMdp(String mdp) {
		this.password = mdp;
	}
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	
}
