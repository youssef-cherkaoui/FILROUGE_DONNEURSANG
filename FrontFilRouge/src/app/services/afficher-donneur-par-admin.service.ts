import { Injectable } from '@angular/core';
import {DonneurSangModel} from "../classes/DonneurModel.model";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AfficherDonneurParAdminService {

  private baseUrl = 'http://localhost:8097/api/v1/auth/Admin';  // URL de l'API backend

  constructor(private http: HttpClient) { }

  // Méthode pour récupérer tous les donneurs de sang
  getAllDonneurSang(): Observable<DonneurSangModel[]> {
    return this.http.get<DonneurSangModel[]>(`${this.baseUrl}/ShowAllDonneur`);
  }

  // Méthode pour mettre à jour un donneur
  updateDonneurSang(id: number, donneurSangModel: DonneurSangModel): Observable<DonneurSangModel> {
    const url = `${this.baseUrl}/editDonneur/${id}`;
    return this.http.put<DonneurSangModel>(url, donneurSangModel);
  }

  // Méthode pour supprimer un donneur
  deleteDonneurSang(id: number): Observable<void> {
    const url = `${this.baseUrl}/deleteDonneur/${id}`;
    return this.http.delete<void>(url);
  }

  getDonneurById(id: number): Observable<DonneurSangModel> {
    const url = `${this.baseUrl}/ShowDonneurByID/${id}`;
    return this.http.get<DonneurSangModel>(url);
  }
}
