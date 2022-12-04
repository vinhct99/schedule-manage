import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleDepartmentManagerComponent } from './schedule-department-manager.component';

describe('ScheduleDepartmentManagerComponent', () => {
  let component: ScheduleDepartmentManagerComponent;
  let fixture: ComponentFixture<ScheduleDepartmentManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleDepartmentManagerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScheduleDepartmentManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
