import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarrosselParceirasComponent } from './carrossel-parceiras.component';

describe('CarrosselParceirasComponent', () => {
  let component: CarrosselParceirasComponent;
  let fixture: ComponentFixture<CarrosselParceirasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarrosselParceirasComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarrosselParceirasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
