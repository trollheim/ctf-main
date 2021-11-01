import { Component, OnInit } from '@angular/core';
import { FlagService } from '../flag.service';

@Component({
  selector: 'invites',
  templateUrl: './invites.component.html',
  styleUrls: ['./invites.component.css']
})
export class InvitesComponent implements OnInit {

  constructor(private rest:FlagService) {}

  invites = [
  ]

  test = [
    {"code" : "some-code-4", active : false },
    {"code" : "some-code-1", active : true },
    {"code" : "some-code-2", active : true },
    {"code" : "some-code-3", active : true }
    


  ]

  ngOnInit(): void {
    var self = this;
    this.rest.getInvites().then(i => self.invites = i ).catch(err => console.log(err));
  }

}
