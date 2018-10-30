package br.com.cast.livroAngular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livroAngular.DTO.CategoriaDTO;
import br.com.cast.livroAngular.entidades.Categoria;
import br.com.cast.livroAngular.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<CategoriaDTO> buscarTodos() {
		List<Categoria> categorias = categoriaRepository.buscarTodos();
		List<CategoriaDTO> dtos = new ArrayList<>();
		
		for (Categoria categoria : categorias) {
			CategoriaDTO dto = new CategoriaDTO();
			
			dto.setId(categoria.getId());
			dto.setDescricao(categoria.getDescricao());
	
			dtos.add(dto);
		}
		return dtos;
	}
}
