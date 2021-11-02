import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private client: HttpClient) { }

  login = {
    username :"",
    password :"" }

  ngOnInit(): void {
  }

  submit(){
    var formData: any = new FormData();
    formData.append("username", this.login.username);
    formData.append("password", this.login.password);
  
    this.client.post('login', formData).subscribe(
      (response) => window.location.href="/app/index.html",
      (error) => window.location.href="/app/index.html"
    )
    alert(1)
  }
}
