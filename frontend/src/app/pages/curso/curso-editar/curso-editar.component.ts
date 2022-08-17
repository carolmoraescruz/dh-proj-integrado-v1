import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CursoService } from '../service/curso.service';
import { Curso } from '../shared/models/curso.model';

@Component({
  selector: 'app-curso-editar',
  templateUrl: './curso-editar.component.html',
  styleUrls: ['./curso-editar.component.scss']
})
export class CursoEditarComponent implements OnInit {
  @ViewChild("formCurso") formCurso!: NgForm;
  curso!: Curso;

  constructor(
    private cursoService: CursoService,
    private route: ActivatedRoute,
    private router: Router
    
  ) { }

  ngOnInit(): void {
    let id = +this.route.snapshot.params['id'];
    const res = this.cursoService.buscarPorId(id);
    if (res !== undefined)
      this.curso = res;
    else
      throw new Error ("Curso não encontrado: id = " + id);
  }

  atualizar(): void {
    if (this.formCurso.form.valid){
      this.cursoService.atualizar(this.curso);
      this.router.navigate(['/cursos']);
    }
  }

}
