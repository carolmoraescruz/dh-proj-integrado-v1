import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Curso } from '../shared/models/curso.model';

@Component({
  selector: 'app-modal-curso',
  templateUrl: './modal-curso.component.html',
  styleUrls: ['./modal-curso.component.scss']
})
export class ModalCursoComponent implements OnInit {
  @Input() curso!: Curso;

  constructor(public activeModal: NgbActiveModal) { }
  
  ngOnInit(): void {
  }

}