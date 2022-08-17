import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompartilhadoModule } from './compartilhado/compartilhado.module';
import { LoginModule } from './pages/login/login.module';
import { Erro404Component } from './pages/erro404/erro404.component';
import { HomeComponent } from './pages/home/home.component';
import { QuemsomosComponent } from './pages/quemsomos/quemsomos.component';
import { TemplateModule } from './template/template.module';
import { CarrosselCursosComponent } from './carrossel-cursos/carrossel-cursos.component';
import { CadastroCandidatoModule } from './pages/cadastro/cadastro-candidato/cadastro-candidato.module';
import { CadastroEmpresaModule } from './pages/cadastro/cadastro-empresa/cadastro-empresa.module';
import { CadastroIdentificacaoModule } from './pages/cadastro/cadastro-identificacao/cadastro-identificacao.module';
import { CursoInserirComponent } from './pages/curso/curso-inserir/curso-inserir.component';
import { CursoListComponent } from './pages/curso/curso-list/curso-list.component';
import { CursoEditarComponent } from './pages/curso/curso-editar/curso-editar.component';
import { CarrosselParceirasComponent } from './carrossel-parceiras/carrossel-parceiras.component';
import { CursoPesquisarComponent } from './pages/curso/curso-pesquisar/curso-pesquisar.component';


@NgModule({
  declarations: [
    AppComponent,
    Erro404Component,
    QuemsomosComponent,
    HomeComponent,
    CarrosselCursosComponent,
    CarrosselParceirasComponent,
    CursoListComponent,
    CursoInserirComponent,
    CursoEditarComponent,
    CursoPesquisarComponent
    

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CompartilhadoModule,
    ReactiveFormsModule,
    FormsModule,
    LoginModule,
    TemplateModule,
    RouterModule,
    CadastroCandidatoModule,
    CadastroEmpresaModule,
    CadastroIdentificacaoModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }