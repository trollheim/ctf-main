import { FlagService } from './../flag.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-submission-component',
  templateUrl: './submission-component.component.html',
  styleUrls: ['./submission-component.component.css']
})
export class SubmissionComponentComponent implements OnInit {

  
  

  BLANK =  {
    number : "",
    title : "",
    description : "",
    url : "",
    submitted : true,
  }
  
  ERR =  {
    number : "",
    title : "ERR",
    description : "",
    url : "",
    submitted : false,
  }

  TEST = [this.BLANK, this.ERR];

  flag: any;

  submission = {
    flag :"",
    code : ""
  }
  constructor(private service:FlagService, private route: ActivatedRoute) { 
    this.route.params.subscribe(params => {
      console.log(params);
      if (params['id']) {  
        this.loadFlag(params['id'])
      }
    });
  }

  loadFlag(id){
    var self = this;
    this.service.getFlag(id).then(result =>  self.setFlag(result)).catch(err=> self.flag = self.ERR);
  }


  ngOnInit(): void {
  }


setFlag(flag){
  this.flag = flag;
  this.submission.flag = flag.number;

}

submit(){
  var self = this;
  
  this.service.submitFlag(this.submission).then(r=> self.submitted(r));
}

submitted(r){
  //TODO find better way 
  window.location.reload();

  alert(r);
}




}
