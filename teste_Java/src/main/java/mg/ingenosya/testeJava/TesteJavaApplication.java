package mg.ingenosya.testeJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import mg.ingenosya.testeJava.Repository.UtilisateurRepositiry;
import mg.ingenosya.testeJava.classe.Utilisateur;

@SpringBootApplication
public class TesteJavaApplication implements CommandLineRunner{
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	@Autowired
//	UtilisateurRepositiry utilisateurRepositiry;
//	
	public static void main(String[] args) {
		SpringApplication.run(TesteJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * bCryptPasswordEncoder = new BCryptPasswordEncoder(); Utilisateur u = new
		 * Utilisateur("luca", bCryptPasswordEncoder.encode("admin"));
		 * utilisateurRepositiry.save(u);
		 */
;	}

}
