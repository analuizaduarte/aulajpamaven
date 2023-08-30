package aplicacao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program3 {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //Name usado na tag persistence-unit do arquivo persistence.xml
		EntityManager em = emf.createEntityManager(); //Cria a conexão com o banco de dados
		
		Pessoa p = em.find(Pessoa.class, 3); //Pesquisa no DB
		
		em.getTransaction().begin();
		
		em.remove(p); //Deletar no DB
		
		em.getTransaction().commit();
		
		System.out.println("Pronto!!");
		em.clear();
		emf.close();

	}

}
