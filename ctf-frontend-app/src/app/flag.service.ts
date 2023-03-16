import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Flag } from './app.models';

@Injectable({
  providedIn: 'root'
})
export class FlagService {
  
  
    deleteFlag(id: any) {
      return this.http.delete("/api/admin/flag/"+id);
  }

  constructor(private http: HttpClient) { }

  submitFlag(submission: any){
    return this.http.post("/api/submit", submission);
  }


   getFlags(){
    return  this.http.get<string>("/api/flags");
  }

  createFlag(newFlag : any){
    return this.http.post("/api/admin/flag/new", newFlag);
  }

   getAdminFlags(){
     return this.http.get<Flag[]>("/api/admin/flag/list");
   }

  getFlag(id){
    return  this.http.get<string>("/api/flag/"+id);
  }

  getInvites(){
    return  this.http.get<any>("/api/invites");
  }

   getRanks(){
    return  this.http.get<string>("/api/ranks");
  }

  getScore(){
    return  this.http.get<string>("/api/score");
  }
}
