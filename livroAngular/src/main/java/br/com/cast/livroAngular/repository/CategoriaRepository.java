package br.com.cast.livroAngular.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cast.livroAngular.entidades.Categoria;

@Repository
public class CategoriaRepository {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Categoria> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
					  jpql.append("select c ")
					  	  .append("from ")
					  	  .append(Categoria.class.getName())
					  	  .append(" c ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();
	}
}
