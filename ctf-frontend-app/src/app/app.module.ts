import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ScoreComponentComponent } from './score-component/score-component.component';
import { SubmissionComponentComponent } from './submission-component/submission-component.component';
import { RankingComponentComponent } from './ranking-component/ranking-component.component';
import { NgbModule, NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule, HttpClientXsrfModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { FlagListComponent } from './flag-list/flag-list.component';
import { InvitesComponent } from './invites/invites.component';
import { AboutComponent } from './about/about.component';
import { ErrorComponent } from './error/error.component';
 import { UsersManagementComponent } from './admin/users-management/users-management.component';
import { AdminMainComponent } from './admin/admin-main/admin-main.component';
import { AdminAddFlagComponent } from './admin/admin-add-flag/admin-add-flag.component';
import { AdminListFlagsComponent } from './admin/admin-list-flags/admin-list-flags.component';
import { AdminPanelComponent } from './admin/admin-panel/admin-panel.component';
import { AdminEditFlagComponent } from './admin/admin-edit-flag/admin-edit-flag.component';
import { AdminOrganisationListComponent } from './admin/admin-organisation-list/admin-organisation-list.component';
import { AdminOrganisationAddComponent } from './admin/admin-organisation-add/admin-organisation-add.component';
import { AdminOrganisationEditComponent } from './admin/admin-organisation-edit/admin-organisation-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    ScoreComponentComponent,
    SubmissionComponentComponent,
    RankingComponentComponent,
    FlagListComponent,
     InvitesComponent,
    AboutComponent,
    ErrorComponent,
    UsersManagementComponent,
    AdminMainComponent,
    AdminAddFlagComponent,
    AdminListFlagsComponent,
    AdminPanelComponent,
    AdminEditFlagComponent,
    AdminOrganisationListComponent,
    AdminOrganisationAddComponent,
    AdminOrganisationEditComponent
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    NgbNavModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
