import { Component, Input, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { FlagService } from './flag.service';
import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Capture The Flag';
 
  constructor(private service: FlagService, private userService: UserService,private sanitizer: DomSanitizer){

  }

  @Input()
  user = null;


  hasRole(role){
    if (this.user && this.user.roles.indexOf(role)>=0) {
      return true
    }
    return false
  }

  ngOnInit(): void {
   this.user = this.userService.getUserDetails()
  }
  
}
