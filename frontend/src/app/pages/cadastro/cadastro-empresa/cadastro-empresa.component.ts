import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { AutenticacaoService } from 'src/app/autenticacao/autenticacao.service';
import { confirmacaoSenha } from 'src/app/compartilhado/validadores/confirmacao-senha.validator';
import { CadastroEmpresaService } from './cadastro-empresa.service';

@Component({
  selector: 'app-cadastro-empresa',
  templateUrl: './cadastro-empresa.component.html',
  styleUrls: ['./cadastro-empresa.component.scss']
})
export class CadastroEmpresaComponent implements OnInit {
  public form: FormGroup;
  constructor(
    private fb: FormBuilder,
    private servicoCadastroEmpresa: CadastroEmpresaService,
    private autenticacaoService: AutenticacaoService
  ) {
    this.form = this.fb.group({
      file: [null],
      nomeInstituicao: ['', [Validators.required, Validators.minLength(3)]],
      cnpjInstituicao: ['', [Validators.required, Validators.minLength(14)]],
      sobreInstituicao: ['', [Validators.required, Validators.minLength(1)]],
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required, Validators.minLength(4)]],
      confirmacaoSenha: ['', [Validators.required, confirmacaoSenha()]],
    });
  }

  ngOnInit(): void {
  }

  public obterReferencia(nomeCampo: string): AbstractControl {
    return this.form.controls[nomeCampo];
  }

  public async aoSubmeter() {
    if (this.form.invalid) {
      alert('Preencha todos os campos corretamente!');
      return;
    }

    try {
      const valoresDoFormulario = this.form.value;
      const corpoDaRequisicao = new FormData();
      corpoDaRequisicao.append('nomeInstituicao', valoresDoFormulario.nomeInstituicao);
      corpoDaRequisicao.append('cnpjInstituicao', valoresDoFormulario.cnpjInstituicao);
      corpoDaRequisicao.append('sobreInstituicao', valoresDoFormulario.sobreInstituicao);
      corpoDaRequisicao.append('email', valoresDoFormulario.email);
      corpoDaRequisicao.append('senha', valoresDoFormulario.senha);
     
      if (valoresDoFormulario.file) {
        corpoDaRequisicao.append('file', valoresDoFormulario.file);
      } 

      await this.servicoCadastroEmpresa.cadastrar(corpoDaRequisicao);
      await this.autenticacaoService.login({
        login: valoresDoFormulario.email,
        senha: valoresDoFormulario.senha
      });
    } catch (excecao: any) {
      const mensagemErro = excecao?.error?.erro || 'Erro ao realizar o cadastro!';
      alert(mensagemErro);
    }
  }
}
