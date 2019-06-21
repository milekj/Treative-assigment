import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightTouristsListComponent } from './flight-tourists-list.component';

describe('FlightTouristsListComponent', () => {
  let component: FlightTouristsListComponent;
  let fixture: ComponentFixture<FlightTouristsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FlightTouristsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightTouristsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
