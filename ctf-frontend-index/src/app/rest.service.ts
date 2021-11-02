import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private http: HttpClient) { }

  async  registerUser(registration: any){
    return await this.http.post("/userAPI/register", registration).toPromise();
  }

}
