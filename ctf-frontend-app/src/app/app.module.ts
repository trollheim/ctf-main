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

@NgModule({
  declarations: [
    AppComponent,
    ScoreComponentComponent,
    SubmissionComponentComponent,
    RankingComponentComponent,
    FlagListComponent,
     InvitesComponent,
    AboutComponent,
    ErrorComponent
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
