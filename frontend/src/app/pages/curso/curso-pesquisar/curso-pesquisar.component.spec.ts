import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoPesquisarComponent } from './curso-pesquisar.component';

describe('CursoPesquisarComponent', () => {
  let component: CursoPesquisarComponent;
  let fixture: ComponentFixture<CursoPesquisarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursoPesquisarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursoPesquisarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
