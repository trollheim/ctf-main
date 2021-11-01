import { AboutComponent } from './about/about.component';
import { InvitesComponent } from './invites/invites.component';
import { RankingComponentComponent } from './ranking-component/ranking-component.component';
import { ScoreComponentComponent } from './score-component/score-component.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SubmissionComponentComponent } from './submission-component/submission-component.component';
import { FlagListComponent } from './flag-list/flag-list.component';


const routes: Routes = [
  { path: '', redirectTo: 'flags', pathMatch: 'full' },
  { path: 'flags', component: FlagListComponent },
  { path: 'flag/:id', component: SubmissionComponentComponent },
  { path: 'score', component: ScoreComponentComponent },
  { path: 'ranking', component: RankingComponentComponent },
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
