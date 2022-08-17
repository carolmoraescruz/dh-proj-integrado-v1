import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from 'src/app/pages/curso/shared/models/curso.model';

const LS_CHAVE: string = "cursos";

@Injectable({
  providedIn: 'root'
})

export class CursoService {

  constructor(private _http:HttpClient) { }

  listarTodos(): Curso[] {
    const cursos = localStorage[LS_CHAVE];

    return cursos ? JSON.parse(cursos) : [];
  }

  inserirCurso(curso:Curso) : Observable<Curso>{
    return this._http.post<Curso>('http://localhost:8080/api/curso/v1', curso);
 
    }

  inserir(curso: Curso): void {
    const cursos = this.listarTodos();

    curso.id = new Date().getTime();

    cursos.push(curso);
    localStorage[LS_CHAVE] = JSON.stringify(cursos);

    
  }

  buscarPorId(id:number): Curso | undefined {
    const cursos: Curso[]= this.listarTodos();

    return cursos.find(curso => curso.id === id);
  }

  atualizar(curso: Curso): void{
    const cursos: Curso [] = this.listarTodos();

    cursos.forEach(
      (obj, index, objs) => {
        if (curso.id === obj.id) {
          objs[index] = curso;
        }
      }
    );
  
    localStorage[LS_CHAVE] = JSON.stringify(cursos);
  }

  remover(id: number):void{
    let cursos: Curso[] = this.listarTodos();
    cursos = cursos.filter(curso => curso.id !== id);
    localStorage[LS_CHAVE] = JSON.stringify(cursos);
  }
}
