import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TouristFlightAddComponent } from './tourist-flight-add.component';

describe('TouristFlightAddComponent', () => {
  let component: TouristFlightAddComponent;
  let fixture: ComponentFixture<TouristFlightAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TouristFlightAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TouristFlightAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
