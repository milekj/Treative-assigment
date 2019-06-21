import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TouristCreateComponent } from './tourist-create.component';

describe('TouristCreateComponent', () => {
  let component: TouristCreateComponent;
  let fixture: ComponentFixture<TouristCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TouristCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TouristCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
