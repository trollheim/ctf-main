import { AboutComponent } from './about/about.component';
import { InvitesComponent } from './invites/invites.component';
import { RankingComponentComponent } from './ranking-component/ranking-component.component';
import { ScoreComponentComponent } from './score-component/score-component.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SubmissionComponentComponent } from './submission-component/submission-component.component';
import { FlagListComponent } from './flag-list/flag-list.component';
import { AdminAddFlagComponent } from './admin/admin-add-flag/admin-add-flag.component';
import { AdminListFlagsComponent } from './admin//admin-list-flags/admin-list-flags.component';

import { UsersManagementComponent } from './admin/users-management/users-management.component';
import { AdminMainComponent } from './admin//admin-main/admin-main.component';
import { AdminEditFlagComponent } from './admin//admin-edit-flag/admin-edit-flag.component';
import { AdminOrganisationListComponent } from './admin/admin-organisation-list/admin-organisation-list.component';
import { AdminOrganisationAddComponent } from './admin/admin-organisation-add/admin-organisation-add.component';
import { AdminOrganisationEditComponent } from './admin/admin-organisation-edit/admin-organisation-edit.component';


const routes: Routes = [
  { path: '', redirectTo: 'flags', pathMatch: 'full' },
  { path: 'flags', component: FlagListComponent },
  { path: 'flag/:id', component: SubmissionComponentComponent },
  { path: 'score', component: ScoreComponentComponent },
  { path: 'ranking', component: RankingComponentComponent },
  { path: 'admin', children: [
                            { path: '', component: AdminMainComponent },
                            { path: 'flag', children: [
                                  { path: '', component: AdminAddFlagComponent},
                                  { path: ':id', component: AdminEditFlagComponent},
                            ]},
                            { path: 'flags', component: AdminListFlagsComponent},
                            { path: 'users', component: UsersManagementComponent},
                            { path: 'orgs', component: AdminOrganisationListComponent},
                            { path: 'org', children: [
                                { path: '', component: AdminOrganisationAddComponent},
                                { path: ':id', component: AdminOrganisationEditComponent},
                            ]},
                            ] },
  { path: 'user', component: Error},
  { path: 'invite', component: InvitesComponent},
  { path: 'about', component: AboutComponent},
  {path: '404', component: Error},
  {path: '**', redirectTo: '/404'}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
