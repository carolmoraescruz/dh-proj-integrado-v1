import { TestBed } from '@angular/core/testing';

import { CadastroCandidatoService } from './cadastro-candidato.service';

describe('CadastroCandidatoService', () => {
  let service: CadastroCandidatoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CadastroCandidatoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
