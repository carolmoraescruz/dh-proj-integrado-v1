import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Erro404Component } from './pages/erro404/erro404.component';
import { HomeComponent } from './pages/home/home.component';
import { QuemsomosComponent } from './pages/quemsomos/quemsomos.component';
import { CursoListComponent } from './pages/curso/curso-list/curso-list.component';
import { CursoInserirComponent } from './pages/curso/curso-inserir/curso-inserir.component';
import { LoginComponent } from './pages/login/login.component';
import { CursoEditarComponent } from './pages/curso/curso-editar/curso-editar.component';
import { CursoPesquisarComponent } from './pages/curso/curso-pesquisar/curso-pesquisar.component';


const routes: Routes = [
  {path:'', redirectTo:'home', pathMatch:'full'},
  {path:'home', component:HomeComponent},
  {path:'quemsomos',component:QuemsomosComponent},
  {path: 'login',loadChildren: () => import('./pages/login/login.module').then(m => m.LoginModule)},
  {path: 'cadastro-identificacao', loadChildren: () => import('./pages/cadastro/cadastro-identificacao/cadastro-identificacao.module').then(m => m.CadastroIdentificacaoModule)},
  {path: 'cadastro-candidato', loadChildren: () => import('./pages/cadastro/cadastro-candidato/cadastro-candidato.module').then(m => m.CadastroCandidatoModule)},
  {path: 'cadastro-empresa', loadChildren: () => import('./pages/cadastro/cadastro-empresa/cadastro-empresa.module').then(m => m.CadastroEmpresaModule)},
  {path:'', redirectTo: 'cursos/listar', pathMatch: 'full'},
  {path:'cursos',redirectTo: 'cursos/listar'},
  {path:'cursos/listar',component:CursoListComponent},
  {path:'cursos/novo',component: CursoInserirComponent},
  {path:'cursos/editar/:id',component: CursoEditarComponent},
  {path:'cursos-pesquisar',component:CursoPesquisarComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
