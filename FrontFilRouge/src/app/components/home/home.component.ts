import { Component, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements AfterViewInit {
  slides!: NodeListOf<HTMLDivElement>;
  currentSlide: number = 0;
  authButton!: HTMLButtonElement;

  ngAfterViewInit(): void {
    this.slides = document.querySelectorAll<HTMLDivElement>('.slide');
    this.authButton = document.getElementById('authButton') as HTMLButtonElement;

    this.showSlide();
    setInterval(() => this.showSlide(), 3000); // Change slide every 3 seconds

    if (this.authButton) {
      this.authButton.addEventListener('click', () => {
        if (this.authButton.textContent === 'Se Connecter') {
          this.authButton.textContent = 'Se Déconnecter';
        } else {
          this.authButton.textContent = 'Se Connecter';
        }
      });
    }
  }

  showSlide(): void {
    this.slides.forEach((slide, index) => {
      slide.classList.toggle('active', index === this.currentSlide);
    });
    this.currentSlide = (this.currentSlide + 1) % this.slides.length;
  }
}
