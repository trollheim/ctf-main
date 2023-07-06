import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOrganisationListComponent } from './admin-organisation-list.component';

describe('AdminOrganisationListComponent', () => {
  let component: AdminOrganisationListComponent;
  let fixture: ComponentFixture<AdminOrganisationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminOrganisationListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminOrganisationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
