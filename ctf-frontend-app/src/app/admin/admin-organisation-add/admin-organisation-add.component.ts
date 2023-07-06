import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { OrganisationService } from 'src/app/organisation.service';

@Component({
  selector: 'admin-organisation-add',
  templateUrl: './admin-organisation-add.component.html',
  styleUrls: ['./admin-organisation-add.component.css']
})
export class AdminOrganisationAddComponent {

  newOrg ={
    name :"",
    image :""
  }


  private handler = {
    next : response => {
      this.router.navigate(['/admin/orgs']); 
    },
    error : error =>{ 
      console.log(error)
      alert("error")}
    }

  constructor(private service:OrganisationService, private router: Router) { 
  }

 

  submit(){
    this.service.createOrg(this.newOrg).subscribe(this.handler)
  }


}
