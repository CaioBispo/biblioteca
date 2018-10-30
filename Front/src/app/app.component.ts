import { LivroService } from './components/service/livro.service';
import { Component } from '@angular/core';
import { Livro } from './components/model/livro.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BuscaLivros';

  constructor(private service: LivroService){}

  public novoLivro(){
    this.service.livro = new Livro();
  }
}
