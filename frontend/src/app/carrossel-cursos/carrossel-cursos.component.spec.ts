import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrosselCursosComponent } from './carrossel-cursos.component';

describe('CarrosselCursosComponent', () => {
  let component: CarrosselCursosComponent;
  let fixture: ComponentFixture<CarrosselCursosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarrosselCursosComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarrosselCursosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
