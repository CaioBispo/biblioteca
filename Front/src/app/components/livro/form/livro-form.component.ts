import { Component, OnInit } from '@angular/core';
import { LivroService } from '../../service/livro.service';
import { AutorService } from '../../service/autor.service';
import { CategoriaService } from '../../service/categoria.service';
import { Categoria } from '../../model/categoria.model';
import { Autor } from '../../model/autor.model';
import { Livro } from '../../model/livro.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-livro-form',
  templateUrl: './livro-form.component.html',
  styleUrls: ['./livro-form.component.css']
})
export class LivroFormComponent implements OnInit {

  constructor(private livroService: LivroService, private autorService: AutorService, 
              private categoriaService: CategoriaService,
              private router: Router) { }

  categorias: Categoria[];
  autores: Autor[];
  livro: Livro = new Livro();


  ngOnInit() {
    this.categorias = new Array<Categoria>();
    this.autores = new Array<Autor>();
    this.getLivro()
    this.listarAutor();
    this.listarCategoria();
  }
 
  public listarAutor(){
    this.autorService.buscarTodos().subscribe(resposta => this.autores = resposta);
  }

  public listarCategoria(){
    this.categoriaService.buscarTodos().subscribe(resposta => this.categorias = resposta);
  }

  public addLivro(){
    if(this.livro.id == null){
      this.livroService.addLivro(this.livro).subscribe(() => this.voltar());
    }else{
      this.livroService.alterarLivro(this.livro).subscribe(() => this.voltar());
    }
  }

  private voltar(): void {
    this.router.navigate(['/livro/listar'])
  }

  private getLivro(){
    this.livro = this.livroService.livro;
  }


}
