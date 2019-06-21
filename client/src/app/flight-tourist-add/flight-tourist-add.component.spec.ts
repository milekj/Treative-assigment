import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightTouristAddComponent } from './flight-tourist-add.component';

describe('FlightTouristAddComponent', () => {
  let component: FlightTouristAddComponent;
  let fixture: ComponentFixture<FlightTouristAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlightTouristAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightTouristAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
