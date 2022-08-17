import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CursoService } from '../service/curso.service';
import { Curso } from '../shared/models/curso.model';


@Component({
  selector: 'app-curso-inserir',
  templateUrl: './curso-inserir.component.html',
  styleUrls: ['./curso-inserir.component.scss']
})
export class CursoInserirComponent implements OnInit {

  @ViewChild('formCurso') formCurso! : NgForm;

  curso! : Curso;

  constructor(
    private cursoService: CursoService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.curso = new Curso();
  }

  inserir(): void{
    if (this.formCurso.form.valid){
      this.cursoService.inserir(this.curso);
      this.router.navigate(["/cursos"]);
    }
  }

  listarTodos(): Curso[] {
    return this.cursoService.listarTodos(); 
  }

}
