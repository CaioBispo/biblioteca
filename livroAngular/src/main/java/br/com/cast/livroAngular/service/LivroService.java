package br.com.cast.livroAngular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livroAngular.DTO.AutorDTO;
import br.com.cast.livroAngular.DTO.CategoriaDTO;
import br.com.cast.livroAngular.DTO.LivroDTO;
import br.com.cast.livroAngular.entidades.Autor;
import br.com.cast.livroAngular.entidades.Categoria;
import br.com.cast.livroAngular.entidades.Livro;
import br.com.cast.livroAngular.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;
	
	public void addLivro(LivroDTO dto) {
		
		Livro livro = new Livro();
		
		Categoria categoria = new Categoria();
		categoria.setId(dto.getCategoriaDTO().getId());
		
		Autor autor = new Autor();
		autor.setId(dto.getAutorDTO().getId());
		
		livro.setId(dto.getId());
		livro.setData(dto.getData());
		livro.setTitulo(dto.getTitulo());
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		livroRepository.inserirLivro(livro);
		
	
	}

	public List<LivroDTO> buscarTodos() {
		List<Livro> livros = livroRepository.buscarTodos();
		List<LivroDTO> dtos = new ArrayList<>();
		
		for (Livro livro : livros) {
			dtos.add(convertToDTO(livro));
		}
		
		return dtos;

	}

	public void excluir(Integer id) {
		livroRepository.excluir(id);
	}

	public LivroDTO buscarPorID(Integer id) {
		LivroDTO dto = convertToDTO(livroRepository.buscarPorId(id));
		return dto;
	}
	
	public void alterarLivro(LivroDTO dto, Integer id) {
		
		Livro livro = livroRepository.buscarPorId(id);

		livro.setTitulo(dto.getTitulo());
		livro.setData(dto.getData());
		
		
		Categoria categoria = new Categoria();
		categoria.setId(dto.getCategoriaDTO().getId());
				
		Autor autor = new Autor();
		autor.setId(dto.getAutorDTO().getId());
		
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		livroRepository.alterarLivro(livro);
	}
	
	private LivroDTO convertToDTO(Livro livro) {
		
		LivroDTO dto = new LivroDTO();
		CategoriaDTO cDTO = new CategoriaDTO();
		AutorDTO aDTO = new AutorDTO();
		
		
		dto.setId(livro.getId());
		dto.setDtPublicacao(livro.getData());
		dto.setTitulo(livro.getTitulo());
		
		cDTO.setId(livro.getCategoria().getId());
		cDTO.setDescricao(livro.getCategoria().getDescricao());

		aDTO.setId(livro.getAutor().getId());
		aDTO.setNome(livro.getAutor().getNome());
		aDTO.setPseudonimo(livro.getAutor().getPseudonimo());
		
		dto.setAutorDTO(aDTO);
		dto.setCategoriaDTO(cDTO);
		
		return dto;	
	}
	
	private Livro convertToEntidade(LivroDTO dto) {
		
		Livro livro = new Livro();
		Categoria categoria = new Categoria();
		Autor autor = new Autor();
		
		
		livro.setId(dto.getId());
		livro.setData(dto.getData());
		livro.setTitulo(dto.getTitulo());
		
		categoria.setId(dto.getCategoriaDTO().getId());
		categoria.setDescricao(dto.getCategoriaDTO().getDescricao());

		autor.setId(dto.getAutorDTO().getId());
		autor.setNome(dto.getAutorDTO().getNome());
		autor.setPseudonimo(dto.getAutorDTO().getPseudonimo());
		
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		
		return livro;	
	}



}
