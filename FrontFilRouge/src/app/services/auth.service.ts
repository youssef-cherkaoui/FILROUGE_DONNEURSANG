import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Jwt} from "../classes/Jwt/jwt";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = "http://localhost:8097/api/v1/auth"

  constructor(private httpClient: HttpClient) { }

  login(loginRequest: any): Observable<Jwt>{
    return this.httpClient.post<Jwt>(this.url + '/authenticate', loginRequest)
  }

  register(registerRequest: any): Observable<Jwt>{
    return this.httpClient.post<Jwt>(this.url + '/Admin/registerDonneur', registerRequest)
  }

  registerAdmin(registerRequest: any): Observable<Jwt>{
    return this.httpClient.post<Jwt>(this.url + '/registerAdmin', registerRequest)
  }

  registerSecretaire(registerRequest: any): Observable<Jwt>{
    return this.httpClient.post<Jwt>(this.url + '/Admin/registerSecretaire', registerRequest)
  }
}
