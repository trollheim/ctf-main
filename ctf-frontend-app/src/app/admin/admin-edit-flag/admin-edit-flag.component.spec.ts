import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEditFlagComponent } from './admin-edit-flag.component';

describe('AdminEditFlagComponent', () => {
  let component: AdminEditFlagComponent;
  let fixture: ComponentFixture<AdminEditFlagComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminEditFlagComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminEditFlagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
