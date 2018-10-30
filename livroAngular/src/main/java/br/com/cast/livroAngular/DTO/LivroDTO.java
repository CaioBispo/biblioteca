package br.com.cast.livroAngular.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LivroDTO {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("titulo")
	private String titulo;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date data;
	@JsonProperty("autor")
	private AutorDTO autorDTO;
	@JsonProperty("categoria")
	private CategoriaDTO categoriaDTO;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getData() {
		return data;
	}
	public void setDtPublicacao(Date data) {
		this.data = data;
	}
	public AutorDTO getAutorDTO() {
		return autorDTO;
	}
	public void setAutorDTO(AutorDTO autorDTO) {
		this.autorDTO = autorDTO;
	}
	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}
	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}
	
	
}
