import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CursoInserirComponent } from './curso-inserir.component';

describe('CursoInserirComponent', () => {
  let component: CursoInserirComponent;
  let fixture: ComponentFixture<CursoInserirComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CursoInserirComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CursoInserirComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
