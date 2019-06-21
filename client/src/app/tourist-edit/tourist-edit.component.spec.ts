import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TouristEditComponent } from './tourist-edit.component';

describe('TouristEditComponent', () => {
  let component: TouristEditComponent;
  let fixture: ComponentFixture<TouristEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TouristEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TouristEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
