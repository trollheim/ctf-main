import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddFlagComponent } from './admin-add-flag.component';

describe('AdminAddFlagComponent', () => {
  let component: AdminAddFlagComponent;
  let fixture: ComponentFixture<AdminAddFlagComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminAddFlagComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminAddFlagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
