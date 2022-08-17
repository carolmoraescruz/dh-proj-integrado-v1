import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroEmpresaRoutingModule } from './cadastro-empresa-routing.module';
import { CadastroEmpresaComponent } from './cadastro-empresa.component';
import { CompartilhadoModule } from 'src/app/compartilhado/compartilhado.module';


@NgModule({
  declarations: [
    CadastroEmpresaComponent,
  ],
  imports: [
    CommonModule,
    CadastroEmpresaRoutingModule,
    CompartilhadoModule
  ]
})
export class CadastroEmpresaModule { }
