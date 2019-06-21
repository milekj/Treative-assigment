import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TouristFlightsListComponent } from './tourist-flights-list.component';

describe('TouristFlightsListComponent', () => {
  let component: TouristFlightsListComponent;
  let fixture: ComponentFixture<TouristFlightsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TouristFlightsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TouristFlightsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
