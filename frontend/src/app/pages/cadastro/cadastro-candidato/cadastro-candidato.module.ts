import { CompartilhadoModule } from 'src/app/compartilhado/compartilhado.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroCandidatoRoutingModule } from './cadastro-candidato-routing.module';
import { CadastroCandidatoComponent } from './cadastro-candidato.component';



@NgModule({
  declarations: [
    CadastroCandidatoComponent
  ],

  imports: [
    CommonModule,
    CadastroCandidatoRoutingModule,
    CompartilhadoModule
  ]
})
export class CadastroCandidatoModule { }
