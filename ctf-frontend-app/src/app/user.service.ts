import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnInit {



  private DEFAULT_USER = {
    username : "",
    organisation : {
      name : "",
      logo : "data:image/gif;base64,R0lGODlhAQABAAAAACH5BAEKAAEALAAAAAABAAEAAAICTAEAOw=="
    },
    roles : []
  }

  constructor(private http: HttpClient) { 
    this.cachedUserDetails = this.DEFAULT_USER;
 
    console.log("------------- constructor")
    this.getUser();
  }

  cachedUserDetails = null;

   getUserDetails(){


         return this.cachedUserDetails;
  }

 async ngOnInit() {
   const x = await this.getUser();
 
  

}

async getUser(){
    this.http.get("/userAPI/current").subscribe(user => {
      this.cachedUserDetails.username = user["username"];
      this.cachedUserDetails.organisation = user["organisation"];
      this.cachedUserDetails.organisation.logo ="data:image/png;base64, " +this.cachedUserDetails.organisation.logo;
      this.cachedUserDetails.roles = user["roles"];

    return true;
},
(err) => {
  console.log("------------- err")
  this.cachedUserDetails.username = "error"
  this.cachedUserDetails.roles.push("ROLE_USER", "ROLE_ADMIN")
  this.cachedUserDetails.organisation.logo = "data:image/png;base64, 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";
  this.cachedUserDetails.organisation.name = "blob"
})
}

 

}
