import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CursoListComponent } from './curso-list/curso-list.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CursoService } from './service/curso.service';
import { CursoInserirComponent } from './curso-inserir/curso-inserir.component';
import { CursoEditarComponent } from './curso-editar/curso-editar.component';
import { ModalCursoComponent } from './modal-curso/modal-curso.component';
import { CursoPesquisarComponent } from './curso-pesquisar/curso-pesquisar.component';



@NgModule({
  declarations: [
    CursoListComponent,
    CursoInserirComponent,
    CursoEditarComponent,
    ModalCursoComponent,
    CursoPesquisarComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  providers: [
    CursoService
  ]
})
export class CursoModule { }
