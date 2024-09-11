// import { Component } from '@angular/core';
//
// @Component({
//   selector: 'app-page-admin',
//   templateUrl: './page-admin.component.html',
//   styleUrls: ['./page-admin.component.css']
// })
// export class PageAdminComponent {
//
// }

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-page-admin',
  templateUrl: './page-admin.component.html',
  styleUrls: ['./page-admin.component.css']
})
export class AdminComponent implements OnInit {
  donneurForm !: FormGroup;
  secretaireForm !: FormGroup;
  centreForm !: FormGroup;

  showDonneurForm = false;
  showSecretaireForm = false;
  showCentreForm = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.donneurForm = this.fb.group({
      name: [''],
      email: [''],
      telephone: [''],
      groupSanguin: [''],

    });

    this.secretaireForm = this.fb.group({
      name: [''],
      email: [''],
      telephone: [''],
      groupSanguin:[]
    });

    this.centreForm = this.fb.group({
      nom: [''],
    });
  }

  showAddDonneurForm() {
    this.showDonneurForm = true;
  }

  showAddSecretaireForm() {
    this.showSecretaireForm = true;
  }

  showAddCentreForm() {
    this.showCentreForm = true;
  }

  addDonneur() {
    const newDonneur = this.donneurForm.value;
    console.log('Donneur ajouté:', newDonneur);
    // Appel API pour ajouter le donneur
  }

  addSecretaire() {
    const newSecretaire = this.secretaireForm.value;
    console.log('Secrétaire ajoutée:', newSecretaire);
    // Appel API pour ajouter la secrétaire
  }

  addCentre() {
    const newCentre = this.centreForm.value;
    console.log('Centre ajouté:', newCentre);
    // Appel API pour ajouter le centre
  }

  searchDonneur(event: any) {
    const searchValue = event.target.value;
    console.log('Recherche donneur:', searchValue);
    // Appel API pour rechercher les donneurs
  }

  searchSecretaire(event: any) {
    const searchValue = event.target.value;
    console.log('Recherche secrétaire:', searchValue);
    // Appel API pour rechercher les secrétaires
  }

  searchCentre(event: any) {
    const searchValue = event.target.value;
    console.log('Recherche centre:', searchValue);
    // Appel API pour rechercher les centres de collecte
  }

  updateStats(event: any) {
    const region = event.target.value;
    console.log('Région sélectionnée:', region);
    // Appel API pour récupérer les statistiques des donneurs par région/ville
  }
}
