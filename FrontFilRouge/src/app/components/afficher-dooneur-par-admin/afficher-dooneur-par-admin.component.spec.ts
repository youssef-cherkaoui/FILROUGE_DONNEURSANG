import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AfficherDooneurParAdminComponent } from './afficher-dooneur-par-admin.component';

describe('AfficherDooneurParAdminComponent', () => {
  let component: AfficherDooneurParAdminComponent;
  let fixture: ComponentFixture<AfficherDooneurParAdminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AfficherDooneurParAdminComponent]
    });
    fixture = TestBed.createComponent(AfficherDooneurParAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
