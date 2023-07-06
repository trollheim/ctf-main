import { Component, OnInit } from '@angular/core';
import { FlagService } from '../flag.service';

@Component({
  selector: 'flag-list',
  templateUrl: './flag-list.component.html',
  styleUrls: ['./flag-list.component.css']
})
export class FlagListComponent implements OnInit {

  constructor(private service:FlagService) { }

  flags  = [
      
  ]


  ngOnInit(): void {
    var self = this
    this.service.getFlags().subscribe( { next : flags => self.setFlags(flags), error : this.error});
    
  }


  setFlags(f){
    console.log("received flags");
    this.flags = f
  }


  error(err){

    console.log(err);
    
  }
  

}
