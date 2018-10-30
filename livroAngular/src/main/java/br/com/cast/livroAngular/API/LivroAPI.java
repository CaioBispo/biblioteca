package br.com.cast.livroAngular.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.livroAngular.DTO.LivroDTO;
import br.com.cast.livroAngular.service.LivroService;

@RestController
@RequestMapping(path="/livro")
public class LivroAPI {

	
	@Autowired
	private LivroService livroService;
	
	@RequestMapping(method=RequestMethod.POST)
	public void inserir(@RequestBody LivroDTO dto) {
		System.out.println("passou aki");
		livroService.addLivro(dto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<LivroDTO> buscarTodos() {
		return livroService.buscarTodos();
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.DELETE)
	public void excluir(@PathVariable("id") Integer id) {
		livroService.excluir(id);
	}
	
	@RequestMapping(path="/{id}", method=RequestMethod.PUT)
	public void alterar(@PathVariable("id") Integer id, @RequestBody LivroDTO dto) {
		livroService.alterarLivro(dto, id);
	}
}
