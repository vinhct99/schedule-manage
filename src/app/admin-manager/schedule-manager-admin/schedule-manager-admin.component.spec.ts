import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScheduleManagerAdminComponent } from './schedule-manager-admin.component';

describe('ScheduleManagerAdminComponent', () => {
  let component: ScheduleManagerAdminComponent;
  let fixture: ComponentFixture<ScheduleManagerAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScheduleManagerAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScheduleManagerAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
