package br.com.cast.livroAngular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.livroAngular.DTO.AutorDTO;
import br.com.cast.livroAngular.entidades.Autor;
import br.com.cast.livroAngular.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;
	
	public List<AutorDTO> buscarTodos() {
		List<Autor> autores = autorRepository.buscarTodos();
		List<AutorDTO> dtos = new ArrayList<>();
		
		for (Autor autor : autores) {
			AutorDTO dto = new AutorDTO();
			
			dto.setId(autor.getId());
			dto.setNome(autor.getNome());
			dto.setPseudonimo(autor.getPseudonimo());
			
			dtos.add(dto);
		}
		
		return dtos;

	}
}
