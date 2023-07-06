import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Organisation } from 'src/app/app.models';
import { OrganisationService } from 'src/app/organisation.service';

@Component({
  selector: 'admin-organisation-list',
  templateUrl: './admin-organisation-list.component.html',
  styleUrls: ['./admin-organisation-list.component.css']
})
export class AdminOrganisationListComponent {

  organisations = []

  private handler = {
    next : response => {
      this.router.navigate(['/admin/orgs']); 
    },
    error : error =>{ 
      console.log(error)
      alert("error")}
    }
  
  constructor(private service:OrganisationService,private router: Router) { }

 
  private reload(){
    var self = this
    this.service.getOrgList().subscribe( { next : orgs => self.setOrgs(orgs), error : this.error});
  }
  setOrgs(orgs: Organisation[]): void {
    this.organisations = orgs;
  }

  ngOnInit(): void {
    this.reload();
   
    
  }
 
  addInvite(id){
    this.service.addInvite(id).subscribe(this.handler)
  }
  
  addUser(id){
    alert("not implemented yet")
  }

  delete(id){
    this.service.delete(id).subscribe({
      next : result => this.reload(),
      error : result => this.reload(),
    })
   }


   error = function(err) { console.log(err);}
}
