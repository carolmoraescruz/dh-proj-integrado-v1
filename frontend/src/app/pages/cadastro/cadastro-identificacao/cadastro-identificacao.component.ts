import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-cadastro-identificacao',
  templateUrl: './cadastro-identificacao.component.html',
  styleUrls: ['./cadastro-identificacao.component.scss']
})
export class CadastroIdentificacaoComponent implements OnInit {

  @Input() pergunta?: string;
  @Input() textoDaAcao?: string;
  @Input() rota?: string;
  
  constructor() { }

  ngOnInit(): void {
  }

}
