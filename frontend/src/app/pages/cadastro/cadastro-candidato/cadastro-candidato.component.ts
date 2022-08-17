import { CadastroCandidatoService } from './cadastro-candidato.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl } from '@angular/forms';
import { confirmacaoSenha } from '../../../compartilhado/validadores/confirmacao-senha.validator';
import { AutenticacaoService } from '../../../autenticacao/autenticacao.service';
import { TipoPCD } from 'src/app/enumeracao/TipoPCD';

@Component({
  selector: 'app-cadastro-candidato',
  templateUrl: './cadastro-candidato.component.html',
  styleUrls: ['./cadastro-candidato.component.scss']
})
export class CadastroCandidatoComponent implements OnInit {
  public form: FormGroup;

  tipoPCD: any[] = [];

  constructor(
    private fb: FormBuilder,
    private servicoCadastroCandidato: CadastroCandidatoService,
    private autenticacaoService: AutenticacaoService
  ) {
    this.form = this.fb.group({
      file: [null],
      nome: ['', [Validators.required, Validators.minLength(3)]],
      sobrenome: ['', [Validators.required, Validators.minLength(1)]],
      cpf: ['', [Validators.required, Validators.minLength(11)]],
      dataNascimento: ['', [Validators.required, Validators.minLength(8)]],
      tipoPCD: ['', [Validators.required, Validators.minLength(8)]],
      cvLinkedin: ['', [Validators.required, Validators.minLength(1)]],
      email: ['', [Validators.required, Validators.email]],
      senha: ['', [Validators.required, Validators.minLength(4)]],
      confirmacaoSenha: ['', [Validators.required, confirmacaoSenha()]],
    });
  }

  ngOnInit() {
    for (let item in TipoPCD) {
      if (isNaN(Number(item))) {
        this.tipoPCD.push({ text: item, value: TipoPCD[item] });
      }
    }
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
      corpoDaRequisicao.append('nome', valoresDoFormulario.nome);
      corpoDaRequisicao.append('sobrenomenome', valoresDoFormulario.sobrenome);
      corpoDaRequisicao.append('cpf', valoresDoFormulario.cpf);
      corpoDaRequisicao.append('dataNascimento', valoresDoFormulario.dataNascimento);
      corpoDaRequisicao.append('tipoPCD', valoresDoFormulario.tipoPCD);
      corpoDaRequisicao.append('email', valoresDoFormulario.email);
      corpoDaRequisicao.append('senha', valoresDoFormulario.senha);
     

      if (valoresDoFormulario.file) {
        corpoDaRequisicao.append('file', valoresDoFormulario.file);
      } 

      await this.servicoCadastroCandidato.cadastrar(corpoDaRequisicao);
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
