import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOrganisationEditComponent } from './admin-organisation-edit.component';

describe('AdminOrganisationEditComponent', () => {
  let component: AdminOrganisationEditComponent;
  let fixture: ComponentFixture<AdminOrganisationEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminOrganisationEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminOrganisationEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
