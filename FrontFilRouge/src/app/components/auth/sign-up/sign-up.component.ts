import {Component, AfterViewInit, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AuthService} from "../../../services/auth.service";
import {Router} from "@angular/router";
import {Jwt} from "../../../classes/Jwt/jwt";
import {Utilisateur} from "../../../classes/Utilisateur/utilisateur";
import {Role} from "../../../classes/enums/Role/role";

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit, AfterViewInit {

  loginForm !: FormGroup;
  isAuthenticated: boolean = false;
  utilisateur: Utilisateur = new Utilisateur();
  constructor(private service: AuthService,
              private fb: FormBuilder,
              private router: Router) {
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      motdepasse: ['', [Validators.required]]
    });
  }

  ngAfterViewInit(): void {
    this.initializeEventListeners();
  }

  submitForm(): void {
    console.log(this.loginForm.value);
    const user  = this.loginForm.value;
    this.service.login(user).subscribe(
      (response: Jwt) => {
        const jwtToken = response.token;
        const userId = response.user.id;
        const userRole = response.user.role;

        localStorage.setItem('jwt', jwtToken);
        localStorage.setItem('userId', userId.toString());
        localStorage.setItem('userRole', userRole);
if (userRole == Role.ADMIN){
  this.router.navigate(['admin-page'])
}
console.log("role not match")
        // Rediriger après une connexion réussie (si nécessaire)
        //this.router.navigate(['home']);
      }
    );
  }

  private initializeEventListeners(): void {
    // Sélection des éléments DOM avec vérifications de type
    const signUpButton = document.getElementById('signUp') as HTMLButtonElement | null;
    const signInButton = document.getElementById('signIn') as HTMLButtonElement | null;
    const container = document.querySelector('.container') as HTMLElement | null;
    const goToSignUp = document.getElementById('goToSignUp') as HTMLAnchorElement | null;
    const goToLogin = document.getElementById('goToLogin') as HTMLAnchorElement | null;
    const authButton = document.getElementById('authButton') as HTMLButtonElement | null;

    if (signUpButton && signInButton && container) {
      signUpButton.addEventListener('click', () => {
        container.classList.add('right-panel-active');
      });

      signInButton.addEventListener('click', () => {
        container.classList.remove('right-panel-active');
      });
    }

    if (goToSignUp && goToLogin && container) {
      goToSignUp.addEventListener('click', (event: Event) => {
        event.preventDefault();
        container.classList.add('right-panel-active');
      });

      goToLogin.addEventListener('click', (event: Event) => {
        event.preventDefault();
        container.classList.remove('right-panel-active');
      });
    }

    // Script pour gérer le bouton Connexion/Deconnexion
    if (authButton) {
      authButton.addEventListener('click', () => {
        this.isAuthenticated = !this.isAuthenticated;
        authButton.textContent = this.isAuthenticated ? 'Déconnexion' : 'Connexion';
        // Ajoutez ici la logique pour gérer la connexion/déconnexion
      });
    }
  }

  // Fonction pour montrer la section (si besoin)
  showSection(sectionId: string): void {
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => {
      if ((section as HTMLElement).id === sectionId) {
        section.classList.add('active');
      } else {
        section.classList.remove('active');
      }
    });
  }

  addUser(){
    this.service.register(this.utilisateur).subscribe(
      data=>{
        console.log(data);
      }
    )
  }

  onSubmit(){
    console.log(this.utilisateur.nom)
    this.addUser();
    this.router.navigate(['courses'])
  }
}

