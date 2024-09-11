import { TestBed } from '@angular/core/testing';

import { AfficherDonneurParAdminService } from './afficher-donneur-par-admin.service';

describe('AfficherDonneurParAdminService', () => {
  let service: AfficherDonneurParAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AfficherDonneurParAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
