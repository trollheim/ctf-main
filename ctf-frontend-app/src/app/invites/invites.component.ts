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
    {"code" : "some-code-4", owner :"CORPO1", active : false },
    {"code" : "some-code-1", owner :"CORPO1", active : true },
    {"code" : "some-code-2", owner :"CORPO1", active : true },
    {"code" : "some-code-3", owner :"CORPO1", active : true }
    


  ]

  ngOnInit(): void {
    var self = this;
    // this.invites = this.test
    this.rest.getInvites().subscribe({ next : i => self.invites = i, error :  err => console.log(err)});
  }

}
