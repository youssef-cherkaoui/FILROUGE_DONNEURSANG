import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private apiUrl = '';

  constructor(private http: HttpClient) { }

  // Gestion des donneurs
  getDonneurs(): Observable<any> {
    return this.http.get(`${this.apiUrl}/donneurs`);
  }

  addDonneur(donneur: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/donneurs`, donneur);
  }

  deleteDonneur(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/donneurs/${id}`);
  }

  // Gestion des secrétaires
  getSecretaires(): Observable<any> {
    return this.http.get(`${this.apiUrl}/secretaires`);
  }

  addSecretaire(secretaire: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/secretaires`, secretaire);
  }

  deleteSecretaire(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/secretaires/${id}`);
  }

  // Gestion des centres de collecte
  getCentres(): Observable<any> {
    return this.http.get(`${this.apiUrl}/centres`);
  }

  addCentre(centre: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/centres`, centre);
  }

  deleteCentre(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/centres/${id}`);
  }

  // Statistiques des donneurs par ville
  getStatsByRegion(region: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/stats?region=${region}`);
  }
}
