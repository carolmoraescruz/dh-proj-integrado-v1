import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ModalCursoComponent } from '../modal-curso/modal-curso.component';
import { CursoService } from '../service/curso.service';
import { Curso } from '../shared/models/curso.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CursoPesquisar } from './curso-pesquisar';

@Component({
  selector: 'app-curso-pesquisar',
  templateUrl: './curso-pesquisar.component.html',
  styleUrls: ['./curso-pesquisar.component.scss']
})
export class CursoPesquisarComponent implements OnInit {

  cursos: Curso[] = [];

  constructor(private cursoService : CursoService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.cursos = this.listarTodos();
  }

  listarTodos(): Curso[] {
    return this.cursoService.listarTodos();

  }

  abrirModalCurso(curso: Curso) {
    const modalRef = this.modalService.open(ModalCursoComponent);
    modalRef.componentInstance.curso = curso;
  }
}

