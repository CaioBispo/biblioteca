package br.com.cast.livroAngular.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.livroAngular.entidades.Autor;

@Repository
public class AutorRepository {

	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Autor> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
					  jpql.append("select a ")
					  	  .append("from ")
					  	  .append(Autor.class.getName())
					  	  .append(" a ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
}
