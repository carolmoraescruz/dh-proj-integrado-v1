import { Component, OnInit } from '@angular/core';
import { CursoService } from '../service/curso.service';
import { Curso } from 'src/app/pages/curso/shared/models/curso.model';
import { ModalCursoComponent } from '../modal-curso/modal-curso.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-curso-list',
  templateUrl: './curso-list.component.html',
  styleUrls: ['./curso-list.component.scss']
})
export class CursoListComponent implements OnInit {

  cursos: Curso[] = [];

  constructor(private cursoService : CursoService,
              private modalService: NgbModal) { }

  ngOnInit(): void {
    this.cursos = this.listarTodos();
  }

  listarTodos(): Curso[] {
    return this.cursoService.listarTodos();

  }

  remover($event: any, curso: Curso): void{
    $event.preventDefault();
    if (confirm('Deseja realmente remover o curso ${curso.nome}?')) {
      this.cursoService.remover(curso.id!);
      this.cursos = this.listarTodos();
    }
  }

  abrirModalCurso(curso: Curso) {
    const modalRef = this.modalService.open(ModalCursoComponent);
    modalRef.componentInstance.curso = curso;
  }
}

