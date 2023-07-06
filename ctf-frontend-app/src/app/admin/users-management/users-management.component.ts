import { Component } from '@angular/core';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'users-management',
  templateUrl: './users-management.component.html',
  styleUrls: ['./users-management.component.css']
})
export class UsersManagementComponent {

  users = []


  organisations = []

  
  constructor(private service:UserService) { }

 
  private reload(){
    var self = this
    // this.service.getUsers().subscribe( { next : flags => self.setFlags(flags), error : this.error});
  }

  ngOnInit(): void {
    this.reload();
   
    
  }
 
  // setUsers(org: UserListItem[]){
  //   console.log("received flags");
  //   this.organisations = org
  // }

  delete(id){
    // this.service.delete(id).subscribe({
    //   next : result => this.reload(),
    //   error : result => this.reload(),
    // })
   }


   error = function(err) { console.log(err);}
}
