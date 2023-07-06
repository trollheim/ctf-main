import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminListFlagsComponent } from './admin-list-flags.component';

describe('AdminListFlagsComponent', () => {
  let component: AdminListFlagsComponent;
  let fixture: ComponentFixture<AdminListFlagsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListFlagsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminListFlagsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
