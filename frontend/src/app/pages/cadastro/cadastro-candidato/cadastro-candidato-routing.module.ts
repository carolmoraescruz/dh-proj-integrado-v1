import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CursoListComponent } from '../../curso/curso-list/curso-list.component';
import { CadastroCandidatoComponent } from './cadastro-candidato.component';

const routes: Routes = [
  {
    path: '',
    component: CadastroCandidatoComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroCandidatoRoutingModule { }
