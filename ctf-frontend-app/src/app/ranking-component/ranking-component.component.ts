import { FlagService } from './../flag.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ranking-component',
  templateUrl: './ranking-component.component.html',
  styleUrls: ['./ranking-component.component.css']
})
export class RankingComponentComponent implements OnInit {

    BLANK = {
    player : "",
    top : []  
  };

  ERR = {
    player : "ERROR",
    top : []  
  };

  constructor(private service:FlagService) { 
    this.rank = this.BLANK;

  }

  rank:any;
  self : any;


  ngOnInit(): void {
    var self = this;

    this.service.getRanks().subscribe( { next : result => self.rank= result, error : err => self.rank = self.ERR});
  }

}
