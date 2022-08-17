import { BridgeApiService } from '../../../compartilhado/servicos/bridge-api.service';
import { Injectable } from '@angular/core';
import { CadastroEmpresa } from './cadastro-empresa.type';
import { RespostaApiBridge } from '../../../compartilhado/tipos/resposta-api-bridge.type';

@Injectable({
  providedIn: 'root'
})
export class CadastroEmpresaService extends BridgeApiService {
  cadastrar(dadosCadastroEmpresa: FormData): Promise<RespostaApiBridge> {
    return this.post('cadastroempresa', dadosCadastroEmpresa);
  }
}
