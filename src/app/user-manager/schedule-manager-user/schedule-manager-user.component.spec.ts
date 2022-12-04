import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleManagerUserComponent } from './schedule-manager-user.component';

describe('ScheduleManagerUserComponent', () => {
  let component: ScheduleManagerUserComponent;
  let fixture: ComponentFixture<ScheduleManagerUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleManagerUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScheduleManagerUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
