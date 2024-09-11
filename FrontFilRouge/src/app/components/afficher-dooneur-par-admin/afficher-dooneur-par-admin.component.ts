import { Component } from '@angular/core';
import {DonneurSangModel} from "../../classes/DonneurModel.model";
import {AfficherDonneurParAdminService} from "../../services/afficher-donneur-par-admin.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-afficher-dooneur-par-admin',
  templateUrl: './afficher-dooneur-par-admin.component.html',
  styleUrls: ['./afficher-dooneur-par-admin.component.css']
})
export class AfficherDooneurParAdminComponent {

  donneurs: DonneurSangModel[]=[]

  constructor(private donneurService : AfficherDonneurParAdminService, private router:Router) {
  }

  ngOnInit():void{
    this.donneurService.getAllDonneurSang().subscribe((data)=>{
      this.donneurs=data;
      console.log(data)
    })
  }

  supprimerDonneur(id: number ) {
    this.donneurService.deleteDonneurSang(id).subscribe(()=>{
      this.donneurs = this.donneurs.filter(e=>e.id !==id)
    })
  }

  modifierDonneur(id: number) {
    this.router.navigate(['edit-donneur/'+id])

  }

  addDonneur() {
    this.router.navigate(['addDonneurSang'])
  }
}
