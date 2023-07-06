import { Component } from '@angular/core';
import { Flag } from 'src/app/app.models';
import { FlagService } from 'src/app/flag.service';
 



 

const Flags: Flag[] = [
	{
    id : 1,
    title: "Flag 01",
    description: "SQLI",
    url: "localhost",
    submissions: 3
	},
	{
    id : 2,
    title: "Flag 02",
    description: "this will be very long description that we use to see how bad it can be.",
    url: "localhost",
    submissions: 6
	} 
];

@Component({
  selector: 'admin-list-flags',
  templateUrl: './admin-list-flags.component.html',
  styleUrls: ['./admin-list-flags.component.css']
})
export class AdminListFlagsComponent {
  flags = Flags;
  error = function(err) { console.log(err);}


  constructor(private service:FlagService) { }

 
  private reload(){
    var self = this
    this.service.getAdminFlags().subscribe( { next : flags => self.setFlags(flags), error : this.error});
  }

  ngOnInit(): void {
    this.reload();
   
    
  }
 
  setFlags(f: Flag[]){
    console.log("received flags");
    this.flags = f
  }

  delete(id){
    this.service.deleteFlag(id).subscribe({
      next : result => this.reload(),
      error : result => this.reload(),
    })
   }
 

    
    
}
