import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Livro } from '../model/livro.model';
import { HttpClient } from '@angular/common/http';

const URL_API: string = 'http://localhost:8080/livro/';

@Injectable({
  providedIn: 'root'
})

export class LivroService {

  livro: Livro = new Livro;

  constructor(private http: HttpClient) { }

  public buscarTodos(): Observable<Livro[]>{
    return this.http.get<Livro[]>(URL_API);
  }

  public addLivro(livro: Livro): Observable<Livro>{
    return this.http.post<Livro>(URL_API, livro);
  }

  public excluir(id: number): Observable<number>{
    return this.http.delete<number>(URL_API + id);
  }

  public setLivro(l: Livro){
    this.livro = l;
  }

  public alterarLivro(livro: Livro): Observable<Livro>{
    return this.http.put<Livro>(URL_API+livro.id, livro);
  }
} 
