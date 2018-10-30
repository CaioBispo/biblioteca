package br.com.cast.livroAngular.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cast.livroAngular.entidades.Livro;

@Repository
public class LivroRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void inserirLivro(Livro livro) {
		em.persist(livro);
	}
	
	@SuppressWarnings("unchecked")
	public List<Livro> buscarTodos() {
		StringBuilder jpql = new StringBuilder();
					  jpql.append("select l ")
					  	  .append("from ")
					  	  .append(Livro.class.getName())
					  	  .append(" l ");

		Query query = em.createQuery(jpql.toString());
		return query.getResultList();

	}
	
	@Transactional
	public Livro buscarPorId(Integer id) {
		return em.find(Livro.class, id);
	}
	
	@Transactional
	public void excluir(Integer id) {
		em.remove(buscarPorId(id));
	}
	
	@Transactional
	public void alterarLivro(Livro livro) {
		em.merge(livro);
	}

}
