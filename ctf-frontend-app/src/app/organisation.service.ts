import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Organisation } from './app.models';

@Injectable({
  providedIn: 'root'
})
export class OrganisationService {





  addInvite(id: any) {
    return this.http.get("/api/admin/organisation/"+id+"/addinvite");
  }
  
  
  
  delete(id: any) {
    return this.http.delete("/api/admin/organisation/"+id);

  }

  constructor(private http: HttpClient) { 
   
  }

  createOrg(newOrg : any){
    return this.http.post("/api/admin/organisation/new", newOrg);
  }

   getOrgList(){
     return this.http.get<Organisation[]>("/api/admin/organisation/list");
   }


}
