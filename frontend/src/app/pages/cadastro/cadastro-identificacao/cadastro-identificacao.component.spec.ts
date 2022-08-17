import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroIdentificacaoComponent } from './cadastro-identificacao.component';

describe('CadastroIdentificacaoComponent', () => {
  let component: CadastroIdentificacaoComponent;
  let fixture: ComponentFixture<CadastroIdentificacaoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroIdentificacaoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CadastroIdentificacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
