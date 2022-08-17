import { HttpClient } from '@angular/common/http';
import { RespostaLoginBridge } from './resposta-login-bridge.type';
import { CredenciaisBridge } from './credenciais-bridge.type';
import { Inject, Injectable } from '@angular/core';
import { BridgeApiService } from '../compartilhado/servicos/bridge-api.service';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AutenticacaoService extends BridgeApiService {

  constructor(
    protected _http: HttpClient,
    @Inject('BRIDGE_URL_API') private _bridgeUrlApi: string,
    private router: Router,
    
  ) {
    super(_http, _bridgeUrlApi);
  }

  async login(credenciais: CredenciaisBridge): Promise<void> {
    const respostaLogin: RespostaLoginBridge = await this.post('login', credenciais);
    if (!respostaLogin.token) {
      throw new Error('Login inválido!');
    }

    localStorage.setItem('token', respostaLogin.token);
    localStorage.setItem('nome', respostaLogin.nome);
    localStorage.setItem('email', respostaLogin.email);

    this.router.navigateByUrl('/');
  }

  estaLogado(): boolean {
    return localStorage.getItem('token') !== null;
  }

  logout(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('nome');
    localStorage.removeItem('email');
    localStorage.removeItem('avatar');
    localStorage.removeItem('id');
    this.router.navigateByUrl('/login');
  }

}
