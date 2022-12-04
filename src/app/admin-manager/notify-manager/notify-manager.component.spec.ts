import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotifyManagerComponent } from './notify-manager.component';

describe('NotifyManagerComponent', () => {
  let component: NotifyManagerComponent;
  let fixture: ComponentFixture<NotifyManagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotifyManagerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NotifyManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
