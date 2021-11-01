import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FlagService {

  constructor(private http: HttpClient) { }
  
  
  async  submitFlag(submission: any){
    return await this.http.post("/api/submit", submission).toPromise();
  }


   async getFlags(){
    return await this.http.get<string>("/api/flags").toPromise();
  }


  async getFlag(id){
    return await this.http.get<string>("/api/flag/"+id).toPromise();
  }

  async getInvites(){
    return await this.http.get<any>("/api/invites").toPromise();
  }

  async getRanks(){
    return await this.http.get<string>("/api/ranks").toPromise();
  }

  async getScore(){
    return await this.http.get<string>("/api/score").toPromise();
  }
}
