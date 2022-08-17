import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroIdentificacaoRoutingModule } from './cadastro-identificacao-routing.module';
import { CompartilhadoModule } from 'src/app/compartilhado/compartilhado.module';
import { CadastroIdentificacaoComponent } from './cadastro-identificacao.component';


@NgModule({
  declarations: [
    CadastroIdentificacaoComponent
  ],
  imports: [
    CommonModule,
    CadastroIdentificacaoRoutingModule,
    CompartilhadoModule
  ]
})
export class CadastroIdentificacaoModule { }
