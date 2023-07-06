import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOrganisationAddComponent } from './admin-organisation-add.component';

describe('AdminOrganisationAddComponent', () => {
  let component: AdminOrganisationAddComponent;
  let fixture: ComponentFixture<AdminOrganisationAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminOrganisationAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminOrganisationAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
