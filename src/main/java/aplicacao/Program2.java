package aplicacao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program2 {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //Name usado na tag persistence-unit do arquivo persistence.xml
		EntityManager em = emf.createEntityManager(); //Cria a conexão com o banco de dados
		
		Pessoa p = em.find(Pessoa.class, 2); //Pesquisa no DB
		System.out.println(p);
		
		System.out.println("Pronto!!");
		em.clear();
		emf.close();

	}

}
