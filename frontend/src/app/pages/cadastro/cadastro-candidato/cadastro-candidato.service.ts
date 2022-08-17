import { BridgeApiService } from '../../../compartilhado/servicos/bridge-api.service';
import { Injectable } from '@angular/core';
import { CadastroCandidato } from './cadastro-candidato.type';
import { RespostaApiBridge } from '../../../compartilhado/tipos/resposta-api-bridge.type';

@Injectable({
  providedIn: 'root'
})
export class CadastroCandidatoService extends BridgeApiService {
  cadastrar(dadosCadastroCandidato: FormData): Promise<RespostaApiBridge> {
    return this.post('cadastrocandidato', dadosCadastroCandidato);
  }
}
