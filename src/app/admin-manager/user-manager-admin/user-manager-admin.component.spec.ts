import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserManagerAdminComponent } from './user-manager-admin.component';

describe('UserManagerAdminComponent', () => {
  let component: UserManagerAdminComponent;
  let fixture: ComponentFixture<UserManagerAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserManagerAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserManagerAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
