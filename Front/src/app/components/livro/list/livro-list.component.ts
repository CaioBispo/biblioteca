import { Component, OnInit } from '@angular/core';
import { Livro } from '../../model/livro.model';
import { LivroService } from '../../service/livro.service';

@Component({
  selector: 'app-livro-list',
  templateUrl: './livro-list.component.html',
  styleUrls: ['./livro-list.component.css']
})
export class LivroListComponent implements OnInit {

  constructor(private service: LivroService) { }

  livros: Livro[];

  ngOnInit() {
    this.livros = new Array<Livro>();
    this.buscarTodos();
  }

  public buscarTodos(){
    this.service.buscarTodos().subscribe(resposta => this.livros = resposta);
  }

  public excluir(id: number){
    if(confirm('Deseja Excluir este livro?')){

      this.service.excluir(id).subscribe(resposta => this.buscarTodos());
    }
  }

  public setLivro(livro: Livro){
    this.service.setLivro(livro);
  }

}
