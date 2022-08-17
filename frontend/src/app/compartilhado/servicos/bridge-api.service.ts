import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BridgeApiService {

  constructor(
    protected http: HttpClient,
    @Inject('BRIDGE_URL_API') private bridgeUrlApi: string
  ) { }

  public post(url: string, body: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.post(
        this.obterUrl(url),
        body
      ).subscribe({
        next: v => resolve(v),
        error: e => reject(e)
      })
    });
  }

  public put(url: string, body: any): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.put(
        this.obterUrl(url),
        body
      ).subscribe({
        next: v => resolve(v),
        error: e => reject(e)
      })
    });
  }

  public get(url: string): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.get(
        this.obterUrl(url)
      ).subscribe({
        next: v => resolve(v),
        error: e => reject(e)
      })
    });
  }

  private obterUrl(url: string): string {
    return `${this.bridgeUrlApi}/${url}`;
  }
}