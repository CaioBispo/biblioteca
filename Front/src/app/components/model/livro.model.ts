import { Autor } from "./autor.model";
import { Categoria } from "./categoria.model";

export class Livro {
    id: number;
    titulo: string;
    data: Date;
    autor: Autor = new Autor();
    categoria: Categoria = new Categoria();
}