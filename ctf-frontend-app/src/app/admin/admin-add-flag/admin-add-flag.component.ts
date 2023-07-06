import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { FlagService } from '../../flag.service';

@Component({
  selector: 'admin-add-flag',
  templateUrl: './admin-add-flag.component.html',
  styleUrls: ['./admin-add-flag.component.css']
})
export class AdminAddFlagComponent {

  newFlag = {
      startDate : { },
      endDate : { },
      description : "",
      title : "",
      code : "",
      url : "",
  }

  

  constructor(private service:FlagService, private router: Router) { 
    var date = new Date();
    var endMonth = date.getMonth()+2;
    var endYear = date.getFullYear();
    if (endMonth>12){
        endMonth = 1
        endYear +=1;
    }

    this.newFlag.startDate = { day: date.getDate(), month: date.getMonth()+1, year: date.getFullYear()};
    this.newFlag.endDate = { day: date.getDate(), month: endMonth, year: endYear};
  }
  
 
 submit(){

  this.service.createFlag(this.newFlag).subscribe({
    next : response => {
      this.router.navigate(['/admin/flags']); 
    },
    error : error =>{ 
      console.log(error)
      alert("error")}
    })
 }


}
