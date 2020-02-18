import { TestBed } from '@angular/core/testing';

import { PromoService } from './promo.service';

describe('PromoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PromoService = TestBed.get(PromoService);
    expect(service).toBeTruthy();
  });
});
