import { Component, OnInit } from '@angular/core';
import { FlagService } from '../flag.service';

@Component({
  selector: 'app-score-component',
  templateUrl: './score-component.component.html',
  styleUrls: ['./score-component.component.css']
})
export class ScoreComponentComponent implements OnInit {

  
  BLANK = {
    total : "",
    flags : []
  }

   
  ERR = {
    total : "ERR",
    flags : []
  }

  constructor(private service:FlagService) { 
    this.score = this.BLANK;
  
  }

  score:any;

  ngOnInit(): void {
    var self = this;
    this.service.getScore().then(result => self.score = result).catch(err=> self.score = self.ERR);
  }

}
