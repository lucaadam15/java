package mg.ingenosya.testeJava.classe;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Role implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRole;
	private String role;
	@JsonIgnore
	@ManyToMany(mappedBy = "roles")
	private Set<Utilisateur> users=new HashSet<>();
	
	public Role(String role) {
		super();
		this.role = role;
	}
	public Role() {};
	
	public long getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@JsonBackReference
	public Set<Utilisateur> getUsers() {
		return users;
	}
	public void setUsers(Set<Utilisateur> users) {
		this.users = users;
	}
	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}
}
