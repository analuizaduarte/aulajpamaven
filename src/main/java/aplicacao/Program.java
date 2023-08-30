package aplicacao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joao Souza", "joao@gmail.com");
		Pessoa p3 = new Pessoa(null, "Maria Silva", "maria@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa"); //Name usado na tag persistence-unit do arquivo persistence.xml
		EntityManager em = emf.createEntityManager(); //Cria a conexão com o banco de dados
		
		em.getTransaction().begin(); //iniciar a transação
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit(); //commitar a transação
		
		System.out.println("Pronto!!");
		em.clear();
		emf.close();

	}

}
