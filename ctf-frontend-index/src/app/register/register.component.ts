import { RestService } from './../rest.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private rest: RestService) { }

  payload = {
    inviteCode : "",
    password : "",
    username :""
  }

  confirm = "";

  ngOnInit(): void {
  }

  isValid(){
  if (this.payload.inviteCode.length ==0){
    return false;
  }
  if (this.payload.username.length ==0){
    return false;
  }
  if (this.payload.password.length ==0){
    return false;
  }

  if (this.payload.password !==this.confirm){
    return false;
  }

  return true;
  }

  submit(){
    this.rest.registerUser(this.payload).then(result =>  alert("Yey, now you can log in!")).catch(err=> alert("Something went wrong, feel free to yell and panic"!))

 
  }
}
