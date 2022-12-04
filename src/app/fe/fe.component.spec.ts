import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeComponent } from './fe.component';

describe('FeComponent', () => {
  let component: FeComponent;
  let fixture: ComponentFixture<FeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
