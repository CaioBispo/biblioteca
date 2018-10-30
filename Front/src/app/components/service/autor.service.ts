import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Autor } from '../model/autor.model';
import { Observable } from 'rxjs';

const URL_API: string = 'http://localhost:8080/autor/';

@Injectable({
  providedIn: 'root'
})
export class AutorService {

  constructor(private http: HttpClient) { }

  public buscarTodos(): Observable<Autor[]>{
    return this.http.get<Autor[]>(URL_API);
  }
}
 