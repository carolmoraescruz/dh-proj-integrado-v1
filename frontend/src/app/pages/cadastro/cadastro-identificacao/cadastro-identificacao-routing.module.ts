import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroIdentificacaoComponent } from './cadastro-identificacao.component';

const routes: Routes = [
  {
    path: '',
    component: CadastroIdentificacaoComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroIdentificacaoRoutingModule { }
